# Play I18n using HOCON

[![Build Status](https://travis-ci.org/marcospereira/play-i18n-hocon.svg?branch=master)](https://travis-ci.org/marcospereira/play-i18n-hocon)

[HOCON](https://github.com/typesafehub/config/blob/v1.3.0/HOCON.md) (Human-Optimized Config Object Notation) and Typesafe Config are the standard way to [configure Play applications](https://www.playframework.com/documentation/2.5.x/Configuration). But, for Internationalization, Play uses [Java Properties](https://docs.oracle.com/javase/tutorial/essential/environment/properties.html) which don't have a syntax to structure an tree of keys used to i18n.

 This plugin offers that by using HOCON as the language for I18n too, so your `messages` files will be like:

 ```
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

> **Attention**: This is a work in progress version and it is not meant to be used as a drop-in replacement to default built-in module.

## How to use

Just follow the steps below:

#### Add Module Dependency

Add the dependency to your `build.sbt` file:

```scala
libraryDependencies += "com.github.marcospereira" %% "play-hocon-i18n" % "0.0.1"
```

#### Disable built-in I18n Module

Add the following line to your `conf/application.conf` file:

```
play.modules.disabled += play.api.i18n.I18nModule
```

#### Enable HOCON I18n Module

Add the following line to your `conf/application.conf` file:

```
play.modules.enabled += com.marcospereira.play.i18n.HoconI18nModule
```

## License

Copyright 2016 Marcos Pereira

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.