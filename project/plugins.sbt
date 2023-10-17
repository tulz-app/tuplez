logLevel := Level.Warn

val scalajsVersion = scala.sys.env.getOrElse("SCALAJS_VERSION", "1.9.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalajsVersion)

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.2.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.2.0")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.15")

addSbtPlugin("com.github.sbt" % "sbt-github-actions" % "0.18.0")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.11")

//addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.4.1")

addSbtPlugin("ch.epfl.scala" % "sbt-version-policy" % "2.1.0")

addSbtPlugin("com.github.sbt" % "sbt-git" % "2.0.0")
