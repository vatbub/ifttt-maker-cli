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

data class IftttMakerChannelResponse(val responseCode: Int, val responseText: String?) {
    fun throwExceptionIfNecessary() :IftttMakerChannelResponse{
        if (responseText == null) throw IftttMakerChannelException(NullPointerException("Request returned no response body"))
        if (!responseText.contains("Congratulations"))
            throw IftttMakerChannelException("Ifttt returned some error. Response http code was: $responseCode, Response body was: $responseText")
        if (responseCode != 200) throw IftttMakerChannelException("Response code was $responseCode")
        return this
    }
}
