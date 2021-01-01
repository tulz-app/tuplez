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
ThisBuild / releasePublishArtifactsAction := PgpKeys.publishSigned.value
ThisBuild / publishTo := sonatypePublishToBundle.value
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / sonatypeProfileName := "yurique"
ThisBuild / publishArtifact in Test := false
ThisBuild / publishMavenStyle := true
ThisBuild / releaseCrossBuild := true
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

lazy val commonSettings = Seq(
  scalaVersion := "2.13.4",
  crossScalaVersions := Seq("2.12.12", "2.13.4"),
  scalacOptions := Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-Xlint:nullary-unit,inaccessible,infer-any,missing-interpolator,private-shadow,type-parameter-shadow,poly-implicit-overload,option-implicit,delayedinit-select,stars-align",
    "-Xcheckinit",
    "-Ywarn-value-discard",
    "-language:implicitConversions",
    "-encoding",
    "utf8"
  ),
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "utest" % "0.7.5" % Test
  ),
  testFrameworks += new TestFramework("utest.runner.Framework")
)

lazy val `tuplez-full` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/full"))
    .settings(commonSettings)
    .settings(
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

lazy val `tuplez-full-light` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/full-light"))
    .settings(commonSettings)
    .settings(
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

lazy val `tuplez-basic` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/basic"))
    .settings(commonSettings)
    .settings(
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

lazy val `tuplez-basic-light` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/basic-light"))
    .settings(commonSettings)
    .settings(
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

lazy val `tuplez-apply` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/apply"))
    .settings(commonSettings)
    .settings(
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
    `tuplez-full`.js,
    `tuplez-full-light`.js,
    `tuplez-basic`.js,
    `tuplez-basic-light`.js,
    `tuplez-apply`.js,
  )

lazy val `tuplez-jvm` = project
  .in(file(".tuplez-jvm"))
  .settings(
    name := "tuplez-jvm"
  )
  .settings(noPublish)
  .aggregate(
    `tuplez-full`.jvm,
    `tuplez-full-light`.jvm,
    `tuplez-basic`.jvm,
    `tuplez-basic-light`.jvm,
    `tuplez-apply`.jvm,
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
