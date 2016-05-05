name := "play-hocon-i18n"

organization := "com.github.marcospereira"

scalaVersion := "2.11.8"

startYear := Some(2016)

description := "A Play modules that provides I18n using Hocon as the messages file."

scalacOptions := Seq("-feature", "-deprecation", "-Ywarn-unused-import")

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(publishSettings: _*)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  autoScalaLibrary := false,
  autoScalaLibrary in test := false,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra :=
    <url>https://github.com/marcospereira/play-i18n-hocon</url>
    <licenses>
      <license>
        <name>Apache License</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>https://github.com/marcospereira/play-i18n-hocon.git</url>
      <connection>scm:git@github.com:marcospereira/play-i18n-hocon.git</connection>
    </scm>
    <developers>
      <developer>
        <id>marcospereira</id>
        <name>Marcos Pereira</name>
        <url>https://github.com/marcospereira</url>
      </developer>
    </developers>
)

addCommandAlias("full-release", ";release;publishSigned;sonatypeRelease")
