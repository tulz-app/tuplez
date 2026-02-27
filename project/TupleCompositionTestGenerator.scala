import sbt._

import java.io.File

class TupleCompositionTestGenerator(sourceManaged: File, to: Int, testConcats: Boolean, testPrepends: Boolean, scala3: Boolean)
    extends SourceGenerator(
      sourceManaged / "app" / "tulz" / "tuplez" / "TupleCompositionTests.scala"
    ) {

  private val summon = if (scala3) "summon" else "implicitly"

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
        if (scala3) {
          println(s"""assertEquals("decomposed should match", (unit, unit), $summon[Decompose[Unit, Unit]].decompose(unit))""")
          println(s"""assertEquals("decomposed should match", (unit, unit), $summon[Composition[Unit, Unit]].decompose(unit))""")
        }
      }

      println()

      enter("""@Test def `scalar+scalar`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", ("1", "2"), TupleComposition.compose("1", "2"))""")
        if (scala3) { // TODO: scala-2 is not able to figure it out (the decompose.Composed type)
          println(s"""assertEquals("decomposed should match", ("1", "2"), $summon[Decompose[String, String]].decompose(Tuple2("1", "2")))""")
          println(s"""assertEquals("decomposed should match", ("1", "2"), $summon[Composition[String, String]].decompose(Tuple2("1", "2")))""")
        }
      }

      println()

      enter("""@Test def `scalar+unit`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", "1", TupleComposition.compose("1", unit))""")
        if (scala3) {
          println(s"""assertEquals("decomposed should match", ("1", unit), $summon[Decompose[String, Unit]].decompose("1"))""")
          println(s"""assertEquals("decomposed should match", ("1", unit), $summon[Composition[String, Unit]].decompose("1"))""")
        }
      }

      println()

      enter("""@Test def `unit+scalar`(): Unit = {""")("}") {
        println("""assertEquals("composed should match", "2", TupleComposition.compose(unit, "2"))""")
        if (scala3) {
          println(s"""assertEquals("decomposed should match", (unit, "2"), $summon[Decompose[Unit, String]].decompose("2"))""")
          println(s"""assertEquals("decomposed should match", (unit, "2"), $summon[Composition[Unit, String]].decompose("2"))""")
        }
      }

      println()

      def tupleElements(size: Int, offset: Int): String = {
        if (size == 1) {
          s"${offset + 1}"
        } else {
          s"${(offset + 1 to offset + size).mkString(", ")}"
        }
      }

      def tupleValue(size: Int, offset: Int): String = {
        if (size == 1) {
          s"Tuple1(${tupleElements(size, offset)})"
        } else {
          s"(${tupleElements(size, offset)})"
        }
      }

      def tupleType(size: Int): String = {
        if (size == 1) {
          s"Tuple1[Int]"
        } else {
          s"(${(1 to size).map(_ => "Int").mkString(", ")})"
        }
      }

      for (size1 <- 1 until to) {
        enter(s"""@Test def `${size1}-tuple+Unit`(): Unit = {""")("}") {
          println(s"""val tuple = ${tupleValue(size1, 100)}""")
          println(s"""assertEquals("composed should match", tuple, TupleComposition.compose(tuple, (): Unit))""")
          if (scala3) {
            println(s"""assertEquals("decomposed should match", (tuple, unit), $summon[Decompose[${tupleType(size1)}, Unit]].decompose(tuple))""")
            println(s"""assertEquals("decomposed should match", (tuple, unit), $summon[Composition[${tupleType(size1)}, Unit]].decompose(tuple))""")
          }
        }
        println()
      }

      for (size1 <- 1 until to) {
        enter(s"""@Test def `${size1}-Unit+tuple`(): Unit = {""")("}") {
          println(s"""val tuple = ${tupleValue(size1, 100)}""")
          println(s"""assertEquals("composed should match", tuple, TupleComposition.compose((): Unit, tuple))""")
          if (scala3) {
            println(s"""assertEquals("decomposed should match", (unit, tuple), $summon[Decompose[Unit, ${tupleType(size1)}]].decompose(tuple))""")
            println(s"""assertEquals("decomposed should match", (unit, tuple), $summon[Composition[Unit, ${tupleType(size1)}]].decompose(tuple))""")
          }
        }
        println()
      }

      for (size1 <- 1 until to) {
        enter(s"""@Test def `${size1}-tuple+scalar`(): Unit = {""")("}") {
          println(s"""val tuple = ${tupleValue(size1, 100)}""")
          println(s"""val expected = (${tupleElements(size1, 100)}, 201)""")
          println(s"""assertEquals("composed should match", expected, TupleComposition.compose(tuple, 201))""")
          if (scala3) {
            println(s"""assertEquals("decomposed should match", (tuple, 201), $summon[Decompose[${tupleType(size1)}, Int]].decompose(expected))""")
            println(s"""assertEquals("decomposed should match", (tuple, 201), $summon[Composition[${tupleType(size1)}, Int]].decompose(expected))""")
          }
        }
        println()
      }

      if (testPrepends) {
        for (size1 <- 1 until to) {
          enter(s"""@Test def `scalar+${size1}-tuple`(): Unit = {""")("}") {
            println(s"""val tuple = ${tupleValue(size1, 100)}""")
            println(s"""val expected = (201, ${tupleElements(size1, 100)})""")
            println(s"""assertEquals("composed should match", expected, TupleComposition.compose(201, tuple))""")
            if (scala3) {
              println(s"""assertEquals("decomposed should match", (201, tuple), $summon[Decompose[Int, ${tupleType(size1)}]].decompose(expected))""")
              println(s"""assertEquals("decomposed should match", (201, tuple), $summon[Composition[Int, ${tupleType(size1)}]].decompose(expected))""")
            }
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
              println(s"""val expected = (${tupleElements(size1, 100)}, ${tupleElements(size2, 200)})""")
              println(s"""assertEquals("composed should match", expected, TupleComposition.compose(tuple1, tuple2))""")
              if (scala3) {
                println(s"""assertEquals("decomposed should match", (tuple1, tuple2), $summon[Decompose[${tupleType(size1)}, ${tupleType(size2)}]].decompose(expected))""")
                println(s"""assertEquals("decomposed should match", (tuple1, tuple2), $summon[Composition[${tupleType(size1)}, ${tupleType(size2)}]].decompose(expected))""")
              }
            }
            println()
          }
        }
      }

    }
  }

}
