import sbt.librarymanagement.CrossVersion
import com.typesafe.tools.mima.core.*
import org.typelevel.scalacoptions.{ ScalacOption, ScalacOptions }

inThisBuild(
  List(
    organization             := "app.tulz",
    homepage                 := Some(url("https://github.com/tulz-app/tuplez")),
    licenses                 := List("MIT" -> url("https://github.com/tulz-app/tuplez/blob/main/LICENSE.md")),
    developers               := List(Developer("yurique", "Iurii Malchenko", "i@yurique.com", url("https://github.com/yurique"))),
    scmInfo                  := Some(ScmInfo(url("https://github.com/tulz-app/tuplez"), "scm:git@github.com/tulz-app/tuplez.git")),
    (Test / publishArtifact) := false,
    scalaVersion             := ScalaVersions.v3,
    crossScalaVersions := Seq(
      ScalaVersions.v3,
      ScalaVersions.v213,
      ScalaVersions.v212
    ),
    ThisBuild / versionScheme := Some("early-semver"),
    versionPolicyIntention    := Compatibility.BinaryCompatible,
    mimaBinaryIssueFilters ++= Seq(
      ProblemFilters.exclude[DirectMissingMethodProblem]("app.tulz.tuplez.Composition.apply"),
      ProblemFilters.exclude[ReversedMissingMethodProblem]("app.tulz.tuplez.Composition.decompose"),
    ),
    githubWorkflowTargetTags ++= Seq("v*"),
    githubWorkflowPublishTargetBranches := Seq(RefPredicate.StartsWith(Ref.Tag("v"))),
    githubWorkflowBuild ++= Seq(WorkflowStep.Sbt(List("versionPolicyCheck", "test"))),
    githubWorkflowPublish := Seq(WorkflowStep.Sbt(List("ci-release"))),
    githubWorkflowEnv ~= (_ ++ Map(
      "PGP_PASSPHRASE"    -> s"$${{ secrets.PGP_PASSPHRASE }}",
      "PGP_SECRET"        -> s"$${{ secrets.PGP_SECRET }}",
      "SONATYPE_PASSWORD" -> s"$${{ secrets.SONATYPE_PASSWORD }}",
      "SONATYPE_USERNAME" -> s"$${{ secrets.SONATYPE_USERNAME }}"
    ))
  )
)

// scala3-only implementation without codegen
lazy val `tuplez-shared` =
  crossProject(JVMPlatform, JSPlatform)
    .crossType(CrossType.Pure)
    .in(file("modules/shared"))
    .settings(commonSettings)
    .jsSettings(commonJsSettings)
    .settings(
      name := "tuplez-shared",
      description := "Scala tuple composition, shared module with Scala 3 implementation."
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
        CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, _)) =>
            new TupleCompositionGenerator((Compile / sharedScala2Source).value, to = 22, splitPriorityAt = 6, generateConcats = true, generatePrepends = true).generate()
          case Some((3, _)) =>
            Seq.empty
          case _ => Seq.empty
        }
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = true, testPrepends = true, scala3 = CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )
    .dependsOn(`tuplez-shared`)

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
        CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, _)) =>
            new TupleCompositionGenerator((Compile / sharedScala2Source).value, to = 10, splitPriorityAt = 6, generateConcats = true, generatePrepends = true).generate()
          case Some((3, _)) =>
            Seq.empty
          case _ => Seq.empty
        }
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = true, testPrepends = true, scala3 = CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )
    .dependsOn(`tuplez-shared`)

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
        CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, _)) =>
            new TupleCompositionGenerator((Compile / sharedScala2Source).value, to = 22, splitPriorityAt = 6, generateConcats = false, generatePrepends = false).generate()
          case Some((3, _)) =>
            Seq.empty
          case _ => Seq.empty
        }
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 22, testConcats = false, testPrepends = false, scala3 = CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )
    .dependsOn(`tuplez-shared`)

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
        CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, _)) =>
            new TupleCompositionGenerator((Compile / sharedScala2Source).value, to = 10, splitPriorityAt = 6, generateConcats = false, generatePrepends = false).generate()
          case Some((3, _)) =>
            Seq.empty
          case _ => Seq.empty
        }
      }.taskValue,
      Test / sourceGenerators += Def.task {
        Seq.concat(
          new TupleCompositionTestGenerator((Test / sourceManaged).value, to = 10, testConcats = false, testPrepends = false, scala3 = CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)).generate()
        )
      }.taskValue,
      description := "Scala tuple composition."
    )
    .dependsOn(`tuplez-shared`)

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
    "junit"           % "junit"           % "4.13.2" % Test,
    ("com.github.sbt" % "junit-interface" % "0.13.3" % Test).exclude("junit", "junit-dep")
  ),
  scalacOptions := scalacOptions.value.filterNot(_ == "-Wdead-code"),
  Test / scalacOptions += "-Wconf:msg=a type was inferred to be `Any`:s",
  tpolecatScalacOptions += ScalacOptions.explain
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
  publish / skip      := true,
  publishTo           := Some(Resolver.file("Unused transient repository", file("target/unusedrepo")))
)

lazy val root = project
  .in(file("."))
  .settings(
    name               := "tuplez",
    versionPolicyCheck := {},
  )
  .settings(noPublish)
  .aggregate(
    `tuplez-shared`.js,
    `tuplez-shared`.jvm,
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
