name := """scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice,
  "com.github.marcospereira" %% "play-hocon-i18n" % "1.0.0-SNAPSHOT",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test
)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
