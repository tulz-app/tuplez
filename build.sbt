import sbt.librarymanagement.CrossVersion

inThisBuild(
  List(
    organization := "app.tulz",
    homepage := Some(url("https://github.com/tulz-app/tuplez")),
    licenses := List("MIT" -> url("https://github.com/tulz-app/tuplez/blob/main/LICENSE.md")),
    developers := List(Developer("yurique", "Iurii Malchenko", "i@yurique.com", url("https://github.com/yurique"))),
    scmInfo := Some(ScmInfo(url("https://github.com/tulz-app/tuplez"), "scm:git@github.com/tulz-app/tuplez.git")),
    (Test / publishArtifact) := false,
    scalaVersion := ScalaVersions.v213,
    crossScalaVersions := Seq(
      ScalaVersions.v3,
      ScalaVersions.v213,
      ScalaVersions.v212
    ),
    ThisBuild / versionScheme := Some("early-semver"),
    versionPolicyIntention := Compatibility.BinaryCompatible,
    githubWorkflowTargetTags ++= Seq("v*"),
    githubWorkflowPublishTargetBranches := Seq(RefPredicate.StartsWith(Ref.Tag("v"))),
    githubWorkflowBuild ++= Seq(WorkflowStep.Sbt(List("versionPolicyCheck"))),
    githubWorkflowPublish := Seq(WorkflowStep.Sbt(List("ci-release"))),
    githubWorkflowEnv ~= (_ ++ Map(
      "PGP_PASSPHRASE"    -> s"$${{ secrets.PGP_PASSPHRASE }}",
      "PGP_SECRET"        -> s"$${{ secrets.PGP_SECRET }}",
      "SONATYPE_PASSWORD" -> s"$${{ secrets.SONATYPE_PASSWORD }}",
      "SONATYPE_USERNAME" -> s"$${{ secrets.SONATYPE_USERNAME }}"
    ))
  )
)

lazy val `tuplez-full` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/full"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
    .settings(commonSettings)
    .jsSettings(commonJsSettings)
    .settings(
      name := "tuplez-full",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sharedScalaSource).value, to = 22, generateConcats = true, generatePrepends = true).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = true, testPrepends = true).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )

lazy val `tuplez-full-light` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/full-light"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
    .settings(commonSettings)
    .jsSettings(commonJsSettings)
    .settings(
      name := "tuplez-full-light",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sharedScalaSource).value, to = 10, generateConcats = true, generatePrepends = true).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = true, testPrepends = true).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )

lazy val `tuplez-basic` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/basic"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
    .settings(commonSettings)
    .jsSettings(commonJsSettings)
    .settings(
      name := "tuplez-basic",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sharedScalaSource).value, to = 22, generateConcats = false, generatePrepends = false).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = false, testPrepends = false).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )

lazy val `tuplez-basic-light` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/basic-light"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
    .settings(commonSettings)
    .jsSettings(commonJsSettings)
    .settings(
      name := "tuplez-basic-light",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionGenerator((Compile / sharedScalaSource).value, to = 10, generateConcats = false, generatePrepends = false).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = false, testPrepends = false).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )

lazy val `tuplez-apply` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/apply"))
    .jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin))
    .settings(commonSettings)
    .jsSettings(commonJsSettings)
    .settings(
      name := "tuplez-apply",
      Compile / sourceGenerators += Def.task {
        Seq.concat(
          new ApplyConverterGenerator((Compile / sharedScalaSource).value).generate(),
          new ApplyConverterInstancesGenerator((Compile / sharedScalaSource).value).generate()
        )
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new ApplyConverterTestGenerator((Test / sourceManaged).value).generate()
        )
      }.taskValue,
      description := "Scala function apply converters."
    )

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    "junit"         % "junit"           % "4.13.2" % Test,
    ("com.novocode" % "junit-interface" % "0.11"   % Test).exclude("junit", "junit-dep")
  )
)

lazy val commonJsSettings = Seq(
  scalacOptions ++= {
    val sourcesGithubUrl = s"https://raw.githubusercontent.com/tulz-app/tuplez/${git.gitHeadCommit.value.get}/"
    val sourcesOptionName = CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, _)) => "-P:scalajs:mapSourceURI"
      case Some((3, _)) => "-scalajs-mapSourceURI"
      case _            => throw new RuntimeException(s"unexpected scalaVersion: ${scalaVersion.value}")
    }
    val moduleSourceRoot = file("").toURI.toString
    Seq(
      s"$sourcesOptionName:$moduleSourceRoot->$sourcesGithubUrl"
    )
  }
)

lazy val noPublish = Seq(
  publishLocal / skip := true,
  publish / skip := true,
  publishTo := Some(Resolver.file("Unused transient repository", file("target/unusedrepo")))
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "tuplez",
    versionPolicyCheck := {},
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
