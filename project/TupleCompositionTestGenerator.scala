import sbt._

import java.io.File

class TupleCompositionTestGenerator(sourceManaged: File, to: Int, testConcats: Boolean, testPrepends: Boolean)
    extends SourceGenerator(
      sourceManaged / "app" / "tulz" / "tuplez" / "TupleCompositionTests.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    println("""import org.junit.Test""")
    println("""import org.junit.Assert._""")
    println()
    enter("""class TupleCompositionTests {""")("}") {
      println()

      println("""private val unit: Unit = (): Unit""")
      println()

      enter("""@Test def `Unit+Unit`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", unit, TupleComposition.compose(unit, unit))""")
      }

      println()

      enter("""@Test def `scalar+scalar`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", ("1", "2"), TupleComposition.compose("1", "2"))""")
      }

      println()

      enter("""@Test def `scalar+unit`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", "1", TupleComposition.compose("1", unit))""")
      }

      println()

      enter("""@Test def `unit+scalar`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", "2", TupleComposition.compose(unit, "2"))""")
      }

      println()

      def tupleValue(size: Int, offset: Int): String = {
        if (size == 1) {
          s"Tuple1(${offset + 1})"
        } else {
          s"(${(offset + 1 to offset + size).mkString(", ")})"
        }
      }

      for (size1 <- 1 until to) {
        enter(s"""@Test def `${size1}-tuple+Unit`(): Unit = {""")("}") {
          println(s"""val tuple = ${tupleValue(size1, 100)}""")
          println(s"""assertEquals("composed should match", tuple, TupleComposition.compose(tuple, (): Unit))""")
          println(s"""assertEquals("composed should match", tuple, TupleComposition.compose((): Unit, tuple))""")
        }
        println()
      }

      for (size1 <- 1 until to) {
        enter(s"""@Test def `${size1}-tuple+scalar`(): Unit = {""")("}") {
          println(s"""val tuple = ${tupleValue(size1, 100)}""")
          println(s"""val expected = (${(101 until 101 + size1).mkString(", ")}, 201)""")
          println(s"""assertEquals("composed should match", expected, TupleComposition.compose(tuple, 201))""")
        }
        println()
      }

      if (testPrepends) {
        for (size1 <- 1 until to) {
          enter(s"""@Test def `scalar+${size1}-tuple`(): Unit = {""")("}") {
            println(s"""val tuple = ${tupleValue(size1, 100)}""")
            println(s"""val expected = (201, ${(101 until 101 + size1).mkString(", ")})""")
            println(s"""assertEquals("composed should match", expected, TupleComposition.compose(201, tuple))""")
          }
          println()
        }
      }

      if (testConcats) {
        for (size1 <- 1 until to) {
          for (size2 <- 1 to to - size1) {
            enter(s"""@Test def `${size1}-tuple+${size2}-tuple`(): Unit = {""".stripMargin)("}") {
              println(s"""val tuple1 = ${tupleValue(size1, 100)}""")
              println(s"""val tuple2 = ${tupleValue(size2, 200)}""")
              println(s"""val expected = (${((101 until 101 + size1) ++ (201 until 201 + size2)).mkString(", ")})""")
              println(s"""assertEquals("composed should match", expected, TupleComposition.compose(tuple1, tuple2))""")
            }
            println()
          }
        }
      }

    }
  }

}
