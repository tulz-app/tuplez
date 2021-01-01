import sbt._

import java.io.File

class ApplyConverterInstancesGenerator(sourceManaged: File)
    extends SourceGenerator(
      sourceManaged / "scala" / "app" / "tulz" / "tuplez" / "ApplyConverterInstances.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    enter("""trait ApplyConverterInstancesPriLow[O] {""")
    enter("""implicit def singleParam[T1]: ApplyConverter[T1, O] { type In = (T1) => O } = new ApplyConverter[T1, O] {""")
    println("""type In = T1 => O""")
    println("""def apply(fn: T1 => O): T1 => O = fn""")
    leave("""}""")
    leave("""}""")
    println()
    enter("""trait ApplyConverterInstances[O] extends ApplyConverterInstancesPriLow[O] {""")

    enter("""implicit def toTupled1[T1]: ApplyConverter[Tuple1[T1], O] { type In = (T1) => O } = new ApplyConverter[Tuple1[T1], O] {""")
    println("""type In = (T1) => O""")
    println("""def apply(fn: (T1) => O): (Tuple1[T1]) => O = t => fn(t._1)""")
    leave("""}""")
    for (size <- 2 to 22) {
      val tpe = tupleType(size)
      enter(
        s"""implicit def toTupled${size}[${tpe}]: ApplyConverter[Tuple${size}[${tupleType(size)}], O] { type In = (${tupleType(
          size
        )}) => O } = new ApplyConverter[Tuple${size}[${tpe}], O] {"""
      )
      println(s"""type In = (${tpe}) => O""")
      println(s"""def apply(fn: (${tpe}) => O): (Tuple${size}[${tpe}]) => O = fn.tupled""")
      leave("""}""")
    }
    leave("""}""")
  }

}
