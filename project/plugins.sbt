logLevel := Level.Warn

val scalajsVersion = scala.sys.env.getOrElse("SCALAJS_VERSION", "1.9.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalajsVersion)

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.2.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.15")

addSbtPlugin("com.codecommit" % "sbt-github-actions" % "0.14.2")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.10")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.22")

addSbtPlugin("ch.epfl.scala" % "sbt-version-policy" % "2.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.2")
