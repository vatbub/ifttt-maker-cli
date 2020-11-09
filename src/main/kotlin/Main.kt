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

import com.beust.jcommander.JCommander
import kotlin.system.exitProcess

fun main(vararg args: String) {
    val commandlineParams = CommandlineParams()
    val jCommander = JCommander(commandlineParams)
    jCommander.parse(*args)

    if (commandlineParams.help) {
        jCommander.usage()
        exitProcess(1)
    }

    with(commandlineParams) {
        IftttMakerChannel(apiKey!!, endpoint).sendEvent(eventName!!, value1, value2, value3)
                .throwExceptionIfNecessary()
                .let { println(it.responseText) }
    }
}
