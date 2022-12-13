import sbt._

import java.io.File

class ApplyConverterGenerator(sourceManaged: File)
    extends SourceGenerator(
      sourceManaged / "app" / "tulz" / "tuplez" / "ApplyConverter.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    enter("""abstract class ApplyConverter[L, O] {""")("}") {
      println("""type In""")
      println("""def apply(f: In): L => O""")
    }
    println()
    println("""trait ApplyConverters[O] extends ApplyConverterInstances[O]""")
  }

}
