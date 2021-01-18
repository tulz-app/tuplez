ThisBuild / scalaVersion := ScalaVersions.v3M3
ThisBuild / crossScalaVersions := Seq(ScalaVersions.v3RC1, ScalaVersions.v3M3, ScalaVersions.v213, ScalaVersions.v212)

lazy val `tuplez-full` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/full"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
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
      description := "Scala tuple composition."
    )

lazy val `tuplez-full-light` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/full-light"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
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
      description := "Scala tuple composition."
    )

lazy val `tuplez-basic` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/basic"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
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
      description := "Scala tuple composition."
    )

lazy val `tuplez-basic-light` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/basic-light"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
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
      description := "Scala tuple composition."
    )

lazy val `tuplez-apply` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/apply"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
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
      }
    )

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    "junit"         % "junit"           % "4.11" % Test,
    ("com.novocode" % "junit-interface" % "0.11" % Test).exclude("junit", "junit-dep")
  ),
  scalacOptions in (Compile, doc) ~= (_.filterNot(
    Set(
      "-scalajs",
      "-deprecation",
      "-explain-types",
      "-explain",
      "-feature",
      "-language:existentials,experimental.macros,higherKinds,implicitConversions",
      "-unchecked",
      "-Xfatal-warnings",
      "-Ykind-projector",
      "-from-tasty",
      "-encoding",
      "utf8",
    )
  ))
)

lazy val noPublish = Seq(
  publishLocal / skip := true,
  publish / skip := true,
  publishTo := Some(Resolver.file("Unused transient repository", file("target/unusedrepo")))
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "tuplez"
  )
  .settings(noPublish)
  .aggregate(
    `tuplez-full`.js,
    `tuplez-full-light`.js,
    `tuplez-basic`.js,
    `tuplez-basic-light`.js,
    `tuplez-apply`.js,
    `tuplez-full`.jvm,
    `tuplez-full-light`.jvm,
    `tuplez-basic`.jvm,
    `tuplez-basic-light`.jvm,
    `tuplez-apply`.jvm,
  )
