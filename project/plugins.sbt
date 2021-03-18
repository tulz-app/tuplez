logLevel := Level.Warn

val scalajsVersion = scala.sys.env.getOrElse("SCALAJS_VERSION", "1.5.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalajsVersion)

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.7")

addSbtPlugin("com.codecommit" % "sbt-github-actions" % "0.10.1")

addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.5.6")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.17")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")
