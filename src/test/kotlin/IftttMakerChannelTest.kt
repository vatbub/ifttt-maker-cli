/*-
 * #%L
 * ifttt-maker-cli
 * %%
 * Copyright (C) 2016 - 2020 Frederik Kammel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.vatbub.ifttt.maker.cli

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.net.URL

class IftttMakerChannelTest {
    companion object {
        private const val eventName = "dummyEvent"
        private const val details1 = "myFirstValue"
        private const val details2 = "mySecondValue"
        private const val details3 = "myThirdValue"
        private const val invalidKeyResponse = "{\"errors\":[{\"message\":\"You sent an invalid key.\"}]}"
        private const val validKeyResponse = "Congratulations! You've fired the $eventName event"
    }

    private fun startMockServer(mockResponse: MockResponse, block: (URL) -> Unit) {
        val server = MockWebServer()
        server.enqueue(mockResponse)
        server.start()
        try {
            block(server.url("/").toUrl())
        } finally {
            server.shutdown()
        }
    }

    @Test
    fun incorrectApiKeyTest() = startMockServer(MockResponse().setBody(invalidKeyResponse)) { url ->
        val result = IftttMakerChannel("lkhbjlgv", url).sendEvent("dummyEvent")
        assertEquals(invalidKeyResponse, result.responseText)
    }

    @Test
    fun correctApiKeyTest() = startMockServer(MockResponse().setBody(validKeyResponse)) { url ->
        val eventName = "dummyEvent"
        val result = IftttMakerChannel("myCorrectApiKey", url).sendEvent(eventName, details1, details2, details3)
        assertEquals(validKeyResponse, result.responseText)
    }
}
