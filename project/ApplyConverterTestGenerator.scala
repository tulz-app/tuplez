import sbt._

import java.io.File

class ApplyConverterTestGenerator(sourceManaged: File)
    extends SourceGenerator(
      sourceManaged / "app" / "tulz" / "tuplez" / "ApplyConverterTests.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    println("""import org.junit.Test""")
    println("""import org.junit.Assert._""")
    println()
    enter("""class ApplyConverterTests {""")
    println()
    println("""object instances extends ApplyConverterInstances[String]""")
    println("""import instances._""")

    def tupleValue(size: Int, offset: Int): String = {
      if (size == 1) {
        s"Tuple1(${offset + 1})"
      } else {
        s"(${(offset + 1 to offset + size).mkString(", ")})"
      }
    }

    for (size <- 1 to 22) {
      val tpe           = (1 to size).map(i => s"Int").mkString(",")
      val args          = (1 to size).map(i => s"x${i}").mkString(",")
      val argsToString  = (1 to size).map(i => s"$${x${i}}").mkString(",")
      val values        = tupleValue(size, 0)
      val tupleToString = (1 to size).map(i => s"$i").mkString(",")

      enter(s"""@Test def `converter for Tuple${size}`(): Unit = {""")
      println(s"""val acceptingTupledFunc: (Tuple${size}[${tpe}] => String) => String = func => func(${values})""")
      println(s"""assertEquals("should match", "${tupleToString}", acceptingTupledFunc(toTupled${size}((${args}) => s"${argsToString}")))""")
      leave(s"""}""")
      println()
    }

    leave("""}""")
  }

}
