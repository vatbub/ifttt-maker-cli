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

import com.beust.jcommander.Parameter
import java.net.URL

class CommandlineParams {
    @Parameter(names = ["--apiKey"], description = "The api key for the Maker/Webhooks channel. Can be found under https://ifttt.com/maker_webhooks/settings", required = true, arity = 1)
    var apiKey: String? = null

    @Parameter(names = ["--eventName"], description = "The name of the event to be dispatched.", required = true, arity = 1)
    var eventName: String? = null

    @Parameter(names = ["--value1"], description = "Optional value to be passed to your IFTTT applet as value1.", required = false, arity = 1)
    var value1: String = ""

    @Parameter(names = ["--value2"], description = "Optional value to be passed to your IFTTT applet as value2.", required = false, arity = 1)
    var value2: String = ""

    @Parameter(names = ["--value3"], description = "Optional value to be passed to your IFTTT applet as value3.", required = false, arity = 1)
    var value3: String = ""

    @Parameter(names = ["--endpoint"], description = "If, for whatever reason, you don't want to sent your event to IFTTT, you can specify the api endpoint here. Defaults to https://maker.ifttt.com/", required = false, arity = 1)
    var endpoint: URL = URL("https://maker.ifttt.com/")

    @Parameter(names = ["--help"], description = "Print this help message.", help = true)
    var help: Boolean = false
}
