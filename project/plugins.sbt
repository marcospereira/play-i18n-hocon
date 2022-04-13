logLevel := Level.Warn

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.15")

// Code formatting
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.3")

// Release plugins
addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.11")
addSbtPlugin("com.github.sbt" % "sbt-release" % "1.1.0")

// Code coverage plugins
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.9.3")

addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.3.15")
