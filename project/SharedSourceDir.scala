import sbt.Def

import sbt._
import sbt.Keys._

object SharedSourceDir extends AutoPlugin {
  override def trigger  = allRequirements
  override def requires = Plugins.empty

  object autoImport {

    val sharedScalaSource = settingKey[File]("slf4j").withRank(KeyRanks.Invisible)

  }

  import autoImport._

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    sharedScalaSource := (Compile / sourceDirectories).value.find { file =>
      val string = file.toString
      !string.contains(".js") &&
      !string.contains(".jvm") &&
      !string.contains("scala-")
    }.get
  )

}
