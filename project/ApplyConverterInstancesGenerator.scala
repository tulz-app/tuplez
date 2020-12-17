import sbt._

import java.io.File

class ApplyConverterInstancesGenerator(sourceManaged: File)
    extends TuplezSourceGenerator(
      sourceManaged / "scala" / "app" / "tulz" / "tuplez" / "ApplyConverterInstances.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    enter("""trait ApplyConverterInstances[O] {""")
    for (size <- 1 to 22) {
      val tpe  = tupleType(size)
      val mtch = tupleType(size, "t")
      enter(
        s"""implicit def toTupled${size}[${tpe}]: ApplyConverter[Tuple${size}[${tupleType(size)}], O] { type In = (${tupleType(
          size
        )}) => O } = new ApplyConverter[Tuple${size}[${tpe}], O] {"""
      )
      println(s"""type In = (${tpe}) => O""")
      enter(s"""def apply(fn: In): (Tuple${size}[${tpe}]) => O = { case Tuple${size}(${mtch}) =>""")
      println(s"""fn(${mtch})""")
      leave("""}""")
      leave("""}""")
    }
    leave("""}""")
  }

}
