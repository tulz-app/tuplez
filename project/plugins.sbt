logLevel := Level.Warn

val scalajsVersion = scala.sys.env.getOrElse("SCALAJS_VERSION", "1.20.2")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalajsVersion)

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.2.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.6")

addSbtPlugin("com.github.sbt" % "sbt-github-actions" % "0.29.0")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.11.2")

addSbtPlugin("org.typelevel" % "sbt-tpolecat" % "0.5.3")

addSbtPlugin("ch.epfl.scala" % "sbt-version-policy" % "3.2.1")

addSbtPlugin("com.raquo" % "sbt-buildkit-dynver" % "0.2.0-M1")
