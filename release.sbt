ThisBuild / organization := "app.tulz"
ThisBuild / homepage := Some(url("https://github.com/tulz-app/tuplez"))
ThisBuild / licenses += "MIT" -> url("https://github.com/tulz-app/tuplez/blob/main/LICENSE.md")
ThisBuild / developers += Developer("yurique", "Iurii Malchenko", "i@yurique.com", url("https://github.com/yurique"))
ThisBuild / publishTo := sonatypePublishToBundle.value
ThisBuild / sonatypeProfileName := "yurique"
ThisBuild / scmInfo := Some(ScmInfo(url("https://github.com/tulz-app/tuplez"), "scm:git@github.com/tulz-app/tuplez.git"))
ThisBuild / publishArtifact in Test := false
