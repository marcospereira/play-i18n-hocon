# Play I18n using HOCON

[![Build Status](https://travis-ci.org/marcospereira/play-i18n-hocon.svg?branch=master)](https://travis-ci.org/marcospereira/play-i18n-hocon) [![Build status](https://ci.appveyor.com/api/projects/status/n5ykw0wuq04rpd5a?svg=true)](https://ci.appveyor.com/project/marcospereira/play-i18n-hocon)
 [![codecov](https://codecov.io/gh/marcospereira/play-i18n-hocon/branch/master/graph/badge.svg)](https://codecov.io/gh/marcospereira/play-i18n-hocon) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/af05a1d033aa4256af5329a6f4711721)](https://www.codacy.com/app/marcospereira/play-i18n-hocon?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=marcospereira/play-i18n-hocon&amp;utm_campaign=Badge_Grade) [![Maven](https://img.shields.io/maven-central/v/com.github.marcospereira/play-hocon-i18n_2.12.svg)](http://mvnrepository.com/artifact/com.github.marcospereira/play-hocon-i18n_2.12)


[HOCON](https://github.com/typesafehub/config/blob/v1.3.0/HOCON.md) (Human-Optimized Config Object Notation) and Typesafe Config are the standard way to [configure Play applications](https://www.playframework.com/documentation/2.5.x/Configuration). But, for Internationalization, Play uses [Java Properties](https://docs.oracle.com/javase/tutorial/essential/environment/properties.html) which lack a syntax to structure a tree of keys used to i18n.

 This plugin offers that by using HOCON as the language for I18n too, so your `messages` files will be like:

```HOCON
 pages {
    signup {
        title = "The Signup page"
        form {
            title = "The signup form"
            name = "Type your name"
            email = "Type your email"
            password = "Type your password"
            submit = "Signup now"
        }
    }
 }
```

This is not meant to be used as a drop-in replacement to default built-in module since Java Properties syntax is not compatible with HOCON.

## How to use

Just follow the steps below:

### Add Module Dependency

Add the dependency to your `build.sbt` file:

```scala
libraryDependencies += "com.github.marcospereira" %% "play-hocon-i18n" % "1.0.1"
```

### Disable built-in I18n Module

Add the following line to your `conf/application.conf` file:

```
play.modules.disabled += play.api.i18n.I18nModule
```

### Enable HOCON I18n Module

Add the following line to your `conf/application.conf` file:

```
play.modules.enabled += com.marcospereira.play.i18n.HoconI18nModule
```

### Write your message files with HOCON syntax

As stated before, HOCON syntax and Java Properties are not fully compatible. The good part is that HOCON loader gives clear messages about invalid syntax and you can easily fix the errors. Of course, all HOCON features are enable here. Finally, you have to rename your messages files to have a `.conf` extension, per instance:

| Before                | After                      |
|:----------------------|:---------------------------|
| `conf/messages`       | `conf/messages.conf`       |
| `conf/messages.en`    | `conf/messages.en.conf`    |
| `conf/messages.en-US` | `conf/messages.en-US.conf` |

## License

Copyright 2016 Marcos Pereira

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
