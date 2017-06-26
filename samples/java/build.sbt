name := """java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice,
  "com.github.marcospereira" %% "play-hocon-i18n" % "1.0.0-SNAPSHOT"
)
