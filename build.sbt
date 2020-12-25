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

lazy val tuplez =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("."))
    .settings(
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
      testFrameworks += new TestFramework("utest.runner.Framework"),
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleGenerator((Compile / sourceManaged).value).generate(),
          new NonTupleGenerator((Compile / sourceManaged).value).generate(),
          new TupleCompositionGenerator((Compile / sourceManaged).value).generate(),
          new ApplyConverterGenerator((Compile / sourceManaged).value).generate(),
          new ApplyConverterInstancesGenerator((Compile / sourceManaged).value).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleTestGenerator((Test / sourceManaged).value).generate(),
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
      description := "A tiny library for tuple composition",
      scmInfo := Some(
        ScmInfo(
          url("https://github.com/tulz-app/tuplez"),
          "scm:git@github.com/tulz-app/tuplez.git"
        )
      )
    )
