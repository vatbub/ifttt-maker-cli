# ifttt-maker-cli

A simple command line interface for the Webhooks/Maker channel of the popular [IFTTT](https://ifttt.com)  service.

 
## Download
You can download the cli either from the releases page or from [Bintray](https://bintray.com/vatbub/fokprojectsReleases/ifttt-maker-cli).

## Usage
Assuming you have a working Java 14 JRE installed, the use of the cli is very simple:

```
java -jar target\ifttt-maker-cli-1.0-jar-with-dependencies.jar --apiKey <yourWebhooksApiKey> --eventName <eventName> --value1 <optionalValue1> --value2 <optionalValue2> --value3 <optionalValue3>
```

This will fire the specified event on IFTTT.

## Compiling
To compile this project, you need a working Java 14 JDK and Maven 3. Then, after cloning the repo, simply run `mvn package` to compile everything. You will find the binary in the subfolder `target`.

## License
ifttt-maker-cli

Copyright (C) 2020 - 2020 Frederik Kammel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)
 
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
