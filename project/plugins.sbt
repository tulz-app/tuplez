logLevel := Level.Warn

val scalajsVersion = scala.sys.env.getOrElse("SCALAJS_VERSION", "1.5.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalajsVersion)

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.6")

addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.5.3")

addSbtPlugin("com.codecommit" % "sbt-github-actions" % "0.10.1")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.16")
