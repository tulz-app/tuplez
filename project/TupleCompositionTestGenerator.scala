import sbt._

import java.io.File

class TupleCompositionTestGenerator(sourceManaged: File, to: Int, testConcats: Boolean, testPrepends: Boolean)
    extends SourceGenerator(
      sourceManaged / "scala" / "app" / "tulz" / "tuplez" / "TupleCompositionTests.scala"
    ) {

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    println("""import utest._""")
    println()
    enter("""object TupleCompositionTests extends TestSuite {""")
    println()

    println("""private val unit: Unit = (): Unit""")
    println()

    enter("""val tests: Tests = Tests {""")
    println()

    enter("""test("Unit plus Unit") {""")
    println("""TupleComposition.compose(unit, unit) ==> unit""")
    leave("}")
    println()

    enter("""test("scalar plus scalar") {""")
    println("""TupleComposition.compose(1, 2) ==> (1, 2)""")
    leave("}")
    println()

    enter("""test("scalar plus unit") {""")
    println("""TupleComposition.compose(1, unit) ==> 1""")
    leave("}")
    println()

    enter("""test("unit plus scalar") {""")
    println("""TupleComposition.compose(unit, 2) ==> 2""")
    leave("}")
    println()

    def tupleValue(size: Int, offset: Int): String = {
      if (size == 1) {
        s"Tuple1(${offset + 1})"
      } else {
        s"(${(offset + 1 to offset + size).mkString(", ")})"
      }
    }

    for (size1 <- 1 to to - 1) {
      enter(s"""test("${size1}-tuple plus Unit") {""")
      println(s"""val tuple = ${tupleValue(size1, 100)}""")
      println(s"""TupleComposition.compose(tuple, (): Unit) ==> tuple""")
      println(s"""TupleComposition.compose((): Unit, tuple) ==> tuple""")
      leave(s"""}""")
      println()
    }

    for (size1 <- 1 to to - 1) {
      enter(s"""test("${size1}-tuple plus scalar") {""")
      println(s"""val tuple = ${tupleValue(size1, 100)}""")
      println(s"""val expected = (${(101 until 101 + size1).mkString(", ")}, 201)""")
      println(s"""TupleComposition.compose(tuple, 201) ==> expected""")
      leave(s"""}""")
      println()
    }

    if (testPrepends) {
      for (size1 <- 1 to to - 1) {
        enter(s"""test("scalar plus ${size1}-tuple") {""")
        println(s"""val tuple = ${tupleValue(size1, 100)}""")
        println(s"""val expected = (201, ${(101 until 101 + size1).mkString(", ")})""")
        println(s"""TupleComposition.compose(201, tuple) ==> expected""")
        leave(s"""}""")
        println()
      }
    }

    if (testConcats) {
      for (size1 <- 1 to to - 1) {
        for (size2 <- 1 to to - size1) {
          enter(s"""test("${size1}-tuple plus ${size2}-tuple") {""".stripMargin)
          println(s"""val tuple1 = ${tupleValue(size1, 100)}""")
          println(s"""val tuple2 = ${tupleValue(size2, 200)}""")
          println(s"""val expected = (${((101 until 101 + size1) ++ (201 until 201 + size2)).mkString(", ")})""")
          println(s"""TupleComposition.compose(tuple1, tuple2) ==> expected""")
          leave(s"""}""")
          println()
        }
      }
    }

    leave("}")
    println()

    leave("""}""")
  }

}
