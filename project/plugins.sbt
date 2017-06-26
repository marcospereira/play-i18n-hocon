logLevel := Level.Warn

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.0")

// Code formatting
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

// Release plugins
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.5")

// Code coverage plugins
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")

addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.3.8")
