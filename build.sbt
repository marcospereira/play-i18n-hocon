name := "play-hocon-i18n"

version := "0.0.1"

scalaVersion := "2.11.8"

organization := "com.github.marcospereira"

organizationHomepage := Some(new URL("https://github.com/marcospereira"))

startYear := Some(2016)

description := "A Play modules that provides I18n using Hocon as the messages file."

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/marcospereira/play-hocon-i18n"))

scalacOptions := Seq("-feature", "-deprecation", "-Ywarn-unused-import")

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
