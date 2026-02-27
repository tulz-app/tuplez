import sbt.Def

import sbt._
import sbt.Keys._

object SharedSourceDir extends AutoPlugin {
  override def trigger  = allRequirements
  override def requires = Plugins.empty

  object autoImport {

    val sharedScalaSource = settingKey[File]("shared source dir").withRank(KeyRanks.Invisible)
    val sharedScala2Source = settingKey[File]("shared scala 2 source dir").withRank(KeyRanks.Invisible)
    val sharedScala3Source = settingKey[File]("shared scala 3 source dir").withRank(KeyRanks.Invisible)

  }

  import autoImport._

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    sharedScalaSource := (Compile / sourceDirectories).value.find { file =>
      val string = file.toString
      !string.contains(".js") &&
      !string.contains(".jvm") &&
      !string.contains("scala-")
    }.get,
    sharedScala2Source := {
      val f = sharedScalaSource.value
      new File(f.getAbsolutePath + "-2")
    },
    sharedScala3Source := {
      val f = sharedScalaSource.value
      new File(f.getAbsolutePath + "-3")
    },
  )

}
