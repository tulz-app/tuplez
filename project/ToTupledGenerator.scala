import sbt._

import java.io.File

class ToTupledGenerator(sourceManaged: File)
    extends TuplezSourceGenerator(
      sourceManaged / "scala" / "app" / "tulz" / "tuplez" / "ToTupled.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    enter("""object ToTupled {""")
    println("""def apply[In, L](f: In): L => O""")
    leave("""}""")
    println()
    println("""trait ApplyConverters[O] extends ApplyConverterInstances[O]""")
  }

}
