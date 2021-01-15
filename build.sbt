ThisBuild / organization := "app.tulz"
ThisBuild / homepage := Some(url("https://github.com/tulz-app/tuplez"))
ThisBuild / licenses += ("MIT", url("https://github.com/tulz-app/tuplez/blob/main/LICENSE.md"))
ThisBuild / developers := List(
  Developer(
    id = "yurique",
    name = "Iurii Malchenko",
    email = "i@yurique.com",
    url = url("https://github.com/yurique")
  )
)
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / sonatypeProfileName := "yurique"
ThisBuild / publishArtifact in Test := false
ThisBuild / publishMavenStyle := true
ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/tulz-app/tuplez"),
    "scm:git@github.com/tulz-app/tuplez.git"
  )
)

lazy val noPublish = Seq(
  publishLocal / skip := true,
  publish / skip := true,
  publishTo := Some(Resolver.file("Unused transient repository", file("target/unusedrepo")))
)

val scala213Version = "2.13.4"
val scala212Version = "2.12.12"
val scala3Version   = "3.0.0-M3"

lazy val commonSettings = Seq(
  scalaVersion := scala3Version,
  crossScalaVersions := Seq(scala3Version, scala212Version, scala213Version),
  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:implicitConversions",
    "-encoding",
    "utf8"
  ),
  scalacOptions ++= (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, minor)) if minor < 13 =>
      Seq(
        "-Xlint:nullary-unit,inaccessible,infer-any,missing-interpolator,private-shadow,type-parameter-shadow,poly-implicit-overload,option-implicit,delayedinit-select,stars-align",
        "-Xcheckinit",
        "-Ywarn-value-discard",
      )
    case Some((2, _)) =>
      Seq(
        "-Xlint:nullary-unit,inaccessible,infer-any,missing-interpolator,private-shadow,type-parameter-shadow,poly-implicit-overload,option-implicit,delayedinit-select,stars-align",
        "-Xcheckinit",
        "-Ywarn-value-discard",
      )
    case Some((3, _)) => Seq()
    case _            => Seq()
  }),
//  testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
)

lazy val jvmSettings = Seq(
  libraryDependencies ++= Seq(
    "junit"         % "junit"           % "4.11" % Test,
    ("com.novocode" % "junit-interface" % "0.11" % Test).exclude("junit", "junit-dep")
  )
)

lazy val `tuplez-full-js` =
  project
    .in(file("modules/full-js"))
    .enablePlugins(ScalaJSPlugin)
    .enablePlugins(ScalaJSJUnitPlugin)
    .settings(commonSettings)
    .settings(
      name := "tuplez-full",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 22, generateConcats = true, generatePrepends = true).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = true, testPrepends = true).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-full-jvm` =
  project
    .in(file("modules/full-jvm"))
    .settings(commonSettings)
    .settings(jvmSettings)
    .settings(
      name := "tuplez-full",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 22, generateConcats = true, generatePrepends = true).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = true, testPrepends = true).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-full-light-js` =
  project
    .in(file("modules/full-light-js"))
    .enablePlugins(ScalaJSPlugin)
    .enablePlugins(ScalaJSJUnitPlugin)
    .settings(commonSettings)
    .settings(
      name := "tuplez-full-light",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 10, generateConcats = true, generatePrepends = true).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = true, testPrepends = true).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-full-light-jvm` =
  project
    .in(file("modules/full-light-jvm"))
    .settings(commonSettings)
    .settings(jvmSettings)
    .settings(
      name := "tuplez-full-light",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 10, generateConcats = true, generatePrepends = true).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = true, testPrepends = true).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-basic-js` =
  project
    .in(file("modules/basic-js"))
    .enablePlugins(ScalaJSPlugin)
    .enablePlugins(ScalaJSJUnitPlugin)
    .settings(commonSettings)
    .settings(
      name := "tuplez-basic",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 22, generateConcats = false, generatePrepends = false).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = false, testPrepends = false).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-basic-jvm` =
  project
    .in(file("modules/basic-jvm"))
    .settings(commonSettings)
    .settings(jvmSettings)
    .settings(
      name := "tuplez-basic",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 22, generateConcats = false, generatePrepends = false).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = false, testPrepends = false).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-basic-light-js` =
  project
    .in(file("modules/basic-light-js"))
    .enablePlugins(ScalaJSPlugin)
    .enablePlugins(ScalaJSJUnitPlugin)
    .settings(commonSettings)
    .settings(
      name := "tuplez-basic-light",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 10, generateConcats = false, generatePrepends = false).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = false, testPrepends = false).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-basic-light-jvm` =
  project
    .in(file("modules/basic-light-jvm"))
    .settings(commonSettings)
    .settings(jvmSettings)
    .settings(
      name := "tuplez-basic-light",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sourceManaged).value, to = 10, generateConcats = false, generatePrepends = false).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = false, testPrepends = false).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-apply-js` =
  project
    .in(file("modules/apply-js"))
    .enablePlugins(ScalaJSPlugin)
    .enablePlugins(ScalaJSJUnitPlugin)
    .settings(commonSettings)
    .settings(
      name := "tuplez-apply",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new ApplyConverterGenerator((Compile / sourceManaged).value).generate(),
          new ApplyConverterInstancesGenerator((Compile / sourceManaged).value).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new ApplyConverterTestGenerator((Test / sourceManaged).value).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-apply-jvm` =
  project
    .in(file("modules/apply"))
    .settings(commonSettings)
    .settings(jvmSettings)
    .settings(
      name := "tuplez-apply",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new ApplyConverterGenerator((Compile / sourceManaged).value).generate(),
          new ApplyConverterInstancesGenerator((Compile / sourceManaged).value).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new ApplyConverterTestGenerator((Test / sourceManaged).value).generate()
        )
      }.taskValue,
      mappings in (Compile, packageSrc) := {
        val base  = (sourceManaged in Compile).value
        val files = (managedSources in Compile).value
        files.map { f =>
          (f, f.relativeTo(base / "scala").get.getPath)
        }
      },
      description := "A tiny library for tuple composition"
    )

lazy val `tuplez-js` = project
  .in(file(".tuplez-js"))
  .settings(
    name := "tuplez-js"
  )
  .settings(noPublish)
  .aggregate(
    `tuplez-full-js`,
    `tuplez-full-light-js`,
    `tuplez-basic-js`,
    `tuplez-basic-light-js`,
    `tuplez-apply-js`,
  )

lazy val `tuplez-jvm` = project
  .in(file(".tuplez-jvm"))
  .settings(
    name := "tuplez-jvm"
  )
  .settings(noPublish)
  .aggregate(
    `tuplez-full-jvm`,
    `tuplez-full-light-jvm`,
    `tuplez-basic-jvm`,
    `tuplez-basic-light-jvm`,
    `tuplez-apply-jvm`,
  )

lazy val root = project
  .in(file("."))
  .settings(
    name := "tuplez"
  )
  .settings(noPublish)
  .aggregate(
    `tuplez-jvm`,
    `tuplez-js`
  )
