import sbt._

import java.io.File

class TupleCompositionGenerator(sourceManaged: File, to: Int, generateConcats: Boolean, generatePrepends: Boolean)
    extends SourceGenerator(
      sourceManaged / "app" / "tulz" / "tuplez" / "TupleComposition.scala"
    ) {

  private def newComposition(
    name: String,
    typeParams: String,
    L: String,
    R: String,
    O: String,
    compose: String,
    decompose: String,
  ): Unit = {
    enter(s"""implicit def `$name`${if (typeParams.nonEmpty) s"[$typeParams]" else ""}: Composition.Aux[$L, $R, $O] = new Composition[$L, $R] {""")("}") {
      println()
      println(s"override type Composed = ${O}")
      println()
      enter(s"def compose(l: $L, r: $R): $O =")("") {
        println(compose)
      }
      enter(s"def decompose(c: $O): ($L, $R) =")("") {
        println(decompose)
      }
    }
  }

  def doGenerate(): Unit = {
    println("""package app.tulz.tuplez""")
    println()
    enter("""object TupleComposition {""")("}") {
      println()
      println("""def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)""")
      println("""def decompose[L, R, C](c: C)(implicit composition: Composition.Aux[L, R, C]): (L, R)         = composition.decompose(c)""".stripMargin)
      println()
    }
    println()
    enter("""abstract class Composition[L, R] {""")("}") {
      println("""type Composed""")
      println("""def compose(a: L, b: R): Composed""")
      println("""def decompose(c: Composed): (L, R)""")
    }
    println()
    enter("""trait Composition_Pri0 {""")("}") {
      newComposition(
        name = "***",
        typeParams = "A, B",
        L = "A",
        R = "B",
        O = "Tuple2[A, B]",
        compose = "Tuple2(l, r)",
        decompose = "c"
      )
    }
    println()

    enter("""trait Composition_Pri5 extends Composition_Pri0{""")("}") {
      newComposition(
        name = "T1+R",
        typeParams = "L, R",
        L = "Tuple1[L]",
        R = "R",
        O = "Tuple2[L, R]",
        compose = "Tuple2(l._1, r)",
        decompose = "Tuple2(Tuple1(c._1), c._2)"
      )

      newComposition(
        name = "L+T1",
        typeParams = "L, R",
        L = "L",
        R = "Tuple1[R]",
        O = "Tuple2[L, R]",
        compose = "Tuple2(l, r._1)",
        decompose = "Tuple2(c._1, Tuple1(c._2))"
      )
    }

    println()

    generatePri7(to, generatePrepends)

    println()

    generatePri10(to, generateConcats)

    println()

    enter("""object Composition extends Composition_Pri10 {""")("}") {
      println("""type Aux[A, B, O] = Composition[A, B] { type Composed = O }""")
      println()

      newComposition(
        name = "unit+unit",
        typeParams = "",
        L = "Unit",
        R = "Unit",
        O = "Unit",
        compose = "()",
        decompose = "((), ())"
      )

      println()
    }
  }

  def generatePri7(to: Int, generatePrepends: Boolean): Unit = {
    def forSizeAndScalar(size: Int): Unit = {
      val left = tupleType(size - 1)
      newComposition(
        name = s"T${size - 1}+scalar",
        typeParams = s"${left}, R",
        L = s"(${left})",
        R = s"R",
        O = s"(${left}, R)",
        compose = s"(${tupleAccess(size - 1, "l")}, r)",
        decompose = s"((${tupleAccess(size - 1, "c")}), c._${size})"
      )
    }

    def forScalarAndSize(size: Int): Unit = {
      val right = tupleType(size - 1)
      newComposition(
        name = s"scalar+T${size - 1}",
        typeParams = s"L, ${right}",
        L = s"L",
        R = s"(${right})",
        O = s"(L, ${right})",
        compose = s"(l, ${tupleAccess(size - 1, "r")})",
        decompose = s"(c._1, (${tupleAccess(2, size, "c")}))"
      )
    }

    enter("""trait Composition_Pri7 extends Composition_Pri5 {""")("}") {
      println()
      for (size <- 3 to to) {
        forSizeAndScalar(size)
        if (generatePrepends) {
          forScalarAndSize(size)
        }
      }
    }
  }

  def generatePri10(to: Int, generateConcats: Boolean): Unit = {

    def forSizeAnd1(size: Int): Unit = {
      val left = tupleType(size)
      newComposition(
        name = s"T${size}+T1",
        typeParams = s"${left}, R",
        L = s"(${left})",
        R = s"Tuple1[R]",
        O = s"(${left}, R)",
        compose = s"(${tupleAccess(size, "l")}, r._1)",
        decompose = s"((${tupleAccess(1, size, "c")}), Tuple1(c._${size + 1}))"
      )
    }

    def for1AndSize(size: Int): Unit = {
      val right = tupleType(size)
      newComposition(
        name = s"T1+T${size}",
        typeParams = s"L, ${right}",
        L = s"Tuple1[L]",
        R = s"(${right})",
        O = s"(L, ${right})",
        compose = s"(l._1, ${tupleAccess(size, "r")})",
        decompose = s"(Tuple1(c._1), (${tupleAccess(2, size + 1, "c")}))"
      )
    }

    def forSizes(size1: Int, size2: Int): Unit = {
      val left  = tupleType(size1, "L")
      val right = tupleType(size2, "R")
      newComposition(
        name = s"T${size1}+T${size2}",
        typeParams = s"${left}, ${right}",
        L = s"(${left})",
        R = s"(${right})",
        O = s"(${left}, ${right})",
        compose = s"(${tupleAccess(size1, "l")}, ${tupleAccess(size2, "r")})",
        decompose = s"((${tupleAccess(1, size1, "c")}), (${tupleAccess(size1 + 1, size1 + size2, "c")}))"
      )
    }

    enter("""trait Composition_Pri10 extends Composition_Pri7 {""")("}") {
      println()
      newComposition(
        name = s"T1+T1",
        typeParams = s"L, R",
        L = s"Tuple1[L]",
        R = s"Tuple1[R]",
        O = s"Tuple2[L, R]",
        compose = s"(l._1, r._1)",
        decompose = s"(Tuple1(c._1), Tuple1(c._2))",
      )
      println()

      for (size <- 2 until to) {
        forSizeAnd1(size)
        for1AndSize(size)
      }

      if (generateConcats) {
        for (size1 <- 2 to to - 2) {
          for (size2 <- 2 to to - size1) {
            forSizes(size1, size2)
          }
        }
      }

      newComposition(
        name = s"unit+A",
        typeParams = s"A",
        L = s"Unit",
        R = s"A",
        O = s"A",
        compose = s"r",
        decompose = s"((), c)"
      )

      newComposition(
        name = s"A+unit",
        typeParams = s"A",
        L = s"A",
        R = s"Unit",
        O = s"A",
        compose = s"l",
        decompose = s"(c, ())"
      )

      println()
    }
  }

}
