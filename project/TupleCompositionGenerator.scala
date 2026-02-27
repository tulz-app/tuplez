import sbt._

import java.io.File

class TupleCompositionGenerator(sourceManaged: File, to: Int, splitPriorityAt: Int, generateConcats: Boolean, generatePrepends: Boolean)
    extends SourceGenerator(
      sourceManaged / "app" / "tulz" / "tuplez" / "TupleComposition.scala"
    ) {

  private def newCompose(
    name: String,
    typeParams: String,
    L: String,
    R: String,
    O: String,
    compose: String,
  ): Unit = {
    enter(s"""implicit def `$name`${if (typeParams.nonEmpty) s"[$typeParams]" else ""}: Compose.Aux[$L, $R, $O] = new Compose[$L, $R] {""")("}") {
      println()
      println(s"override type Composed = ${O}")
      println()
      enter(s"def compose(l: $L, r: $R): $O =")("") {
        println(compose)
      }
    }
  }

  private def newDecompose(
    name: String,
    typeParams: String,
    L: String,
    R: String,
    O: String,
    decompose: String,
  ): Unit = {
    enter(s"""implicit def `$name`${if (typeParams.nonEmpty) s"[$typeParams]" else ""}: Decompose.Aux[$L, $R, $O] = new Decompose[$L, $R] {""")("}") {
      println()
      println(s"override type Composed = ${O}")
      println()
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
      println("""def compose[L, R](l: L, r: R)(implicit composition: Compose[L, R]): composition.Composed = composition.compose(l, r)""")
      println("""def decompose[L, R, C](c: C)(implicit composition: Decompose.Aux[L, R, C]): (L, R)       = composition.decompose(c)""".stripMargin)
      println()
    }
    println()

    enter("""trait Compose[-L, -R] {""")("}") {
      println("""type Composed""")
      println("""def compose(a: L, b: R): Composed""")
    }

    println()

    enter("""trait Decompose[L, R] {""")("}") {
      println("""type Composed""")
      println("""def decompose(c: Composed): (L, R)""")
    }

    println()

    enter("""abstract class Composition[L, R] extends Compose[L, R] with Decompose[L, R] {""")("}") {
      println("""type Composed""")
    }

    println()

    enter("""trait Compose_Pri0 {""")("}") {
      newCompose(
        name = "***",
        typeParams = "A, B",
        L = "A",
        R = "B",
        O = "Tuple2[A, B]",
        compose = "Tuple2(l, r)",
      )
    }

    println()

    enter("""trait Decompose_Pri0 {""")("}") {
      newDecompose(
        name = "***",
        typeParams = "A, B",
        L = "A",
        R = "B",
        O = "Tuple2[A, B]",
        decompose = "c",
      )
    }

    println()

    enter("""trait Compose_Pri5 extends Compose_Pri0 {""")("}") {
      newCompose(
        name = "T1+R",
        typeParams = "L, R",
        L = "Tuple1[L]",
        R = "R",
        O = "Tuple2[L, R]",
        compose = "Tuple2(l._1, r)",
      )

      newCompose(
        name = "L+T1",
        typeParams = "L, R",
        L = "L",
        R = "Tuple1[R]",
        O = "Tuple2[L, R]",
        compose = "Tuple2(l, r._1)",
      )
    }

    println()

    enter("""trait Decompose_Pri5 extends Decompose_Pri0 {""")("}") {
      newDecompose(
        name = "T1+R",
        typeParams = "L, R",
        L = "Tuple1[L]",
        R = "R",
        O = "Tuple2[L, R]",
        decompose = "Tuple2(Tuple1(c._1), c._2)"
      )

      newDecompose(
        name = "L+T1",
        typeParams = "L, R",
        L = "L",
        R = "Tuple1[R]",
        O = "Tuple2[L, R]",
        decompose = "Tuple2(c._1, Tuple1(c._2))"
      )
    }

    println()

    generateComposePri7()

    println()

    generateDecomposePri7()

    println()

    generateComposePri10()

    println()

    generateDecomposePri10()

    println()

    enter("""object Compose extends Compose_Pri10 {""")("}") {
      println("""type Aux[A, B, O] = Compose[A, B] { type Composed = O }""")
      println()

      newCompose(
        name = "unit+unit",
        typeParams = "",
        L = "Unit",
        R = "Unit",
        O = "Unit",
        compose = "()",
      )

      println()
    }
    println()

    enter("""object Decompose extends Decompose_Pri10 {""")("}") {
      println("""type Aux[A, B, O] = Decompose[A, B] { type Composed = O }""")
      println()

      newDecompose(
        name = "unit+unit",
        typeParams = "",
        L = "Unit",
        R = "Unit",
        O = "Unit",
        decompose = "((), ())"
      )

      println()

    }

    println()

    enter("""object Composition {""")("}") {
      println("""type Aux[A, B, O] = Composition[A, B] { type Composed = O }""")
      println()
      enter("""implicit def implied[A, B, O](implicit c: Compose.Aux[A, B, O], d: Decompose.Aux[A, B, O]): Composition.Aux[A, B, O] = {""")("}") {
        enter("""new Composition[A, B] {""")("}") {
          println("""override type Composed = O""")
          println()
          println("""def compose(l: A, r: B): O = c.compose(l, r)""")
          println("""def decompose(c: O): (A, B) = d.decompose(c)""")
        }
      }
    }
  }

  def generateComposeSizeAndScalar(minArity: Int, maxArity: Int, priority: Int, extendsPriority: Int): Unit = {
    def forSizeAndScalar(size: Int): Unit = {
      val left = tupleType(size - 1)
      newCompose(
        name = s"T${size - 1}+scalar",
        typeParams = s"${left}, R",
        L = s"(${left})",
        R = s"R",
        O = s"(${left}, R)",
        compose = s"(${tupleAccess(size - 1, "l")}, r)",
      )
    }

    def forScalarAndSize(size: Int): Unit = {
      val right = tupleType(size - 1)
      newCompose(
        name = s"scalar+T${size - 1}",
        typeParams = s"L, ${right}",
        L = s"L",
        R = s"(${right})",
        O = s"(L, ${right})",
        compose = s"(l, ${tupleAccess(size - 1, "r")})",
      )
    }

    enter(s"""trait Compose_Pri${priority} extends Compose_Pri${extendsPriority} {""")("}") {
      println()
      for (size <- 3 to to) {
        if (size >= minArity && size <= maxArity) {
          forSizeAndScalar(size)
          if (generatePrepends) {
            forScalarAndSize(size)
          }
        }
      }
    }
  }

  def generateDecomposeSizeAndScalar(minArity: Int, maxArity: Int, priority: Int, extendsPriority: Int): Unit = {
    def forSizeAndScalar(size: Int): Unit = {
      val left = tupleType(size - 1)
      newDecompose(
        name = s"T${size - 1}+scalar",
        typeParams = s"${left}, R",
        L = s"(${left})",
        R = s"R",
        O = s"(${left}, R)",
        decompose = s"((${tupleAccess(size - 1, "c")}), c._${size})"
      )
    }

    def forScalarAndSize(size: Int): Unit = {
      val right = tupleType(size - 1)
      newDecompose(
        name = s"scalar+T${size - 1}",
        typeParams = s"L, ${right}",
        L = s"L",
        R = s"(${right})",
        O = s"(L, ${right})",
        decompose = s"(c._1, (${tupleAccess(2, size, "c")}))"
      )
    }

    enter(s"""trait Decompose_Pri${priority} extends Decompose_Pri${extendsPriority} {""")("}") {
      println()
      for (size <- 3 to to) {
        if (size >= minArity && size <= maxArity) {
          forSizeAndScalar(size)
          if (generatePrepends) {
            forScalarAndSize(size)
          }
        }
      }
    }
  }

  def generateComposePri7(): Unit = {
    if (splitPriorityAt < to) {
      generateComposeSizeAndScalar(minArity = splitPriorityAt + 1, maxArity = Int.MaxValue, priority = 6, extendsPriority = 5)
      println()
      generateComposeSizeAndScalar(minArity = 1, maxArity = splitPriorityAt, priority = 7, extendsPriority = 6)
    } else {
      generateComposeSizeAndScalar(minArity = 1, maxArity = Int.MaxValue, priority = 7, extendsPriority = 5)
    }
  }
  def generateDecomposePri7(): Unit = {
    if (splitPriorityAt < to) {
      generateDecomposeSizeAndScalar(minArity = splitPriorityAt + 1, maxArity = Int.MaxValue, priority = 6, extendsPriority = 5)
      println()
      generateDecomposeSizeAndScalar(minArity = 1, maxArity = splitPriorityAt, priority = 7, extendsPriority = 6)
    } else {
      generateDecomposeSizeAndScalar(minArity = 1, maxArity = Int.MaxValue, priority = 7, extendsPriority = 5)
    }
  }

  def generateComposeHighPriority(minArity: Int, maxArity: Int, priority: Int, extendsPriority: Int): Unit = {

    def forSizeAnd1(size: Int): Unit = {
      val left = tupleType(size)
      newCompose(
        name = s"T${size}+T1",
        typeParams = s"${left}, R",
        L = s"(${left})",
        R = s"Tuple1[R]",
        O = s"(${left}, R)",
        compose = s"(${tupleAccess(size, "l")}, r._1)",
      )
    }

    def for1AndSize(size: Int): Unit = {
      val right = tupleType(size)
      newCompose(
        name = s"T1+T${size}",
        typeParams = s"L, ${right}",
        L = s"Tuple1[L]",
        R = s"(${right})",
        O = s"(L, ${right})",
        compose = s"(l._1, ${tupleAccess(size, "r")})",
      )
    }

    def forSizes(size1: Int, size2: Int): Unit = {
      val left  = tupleType(size1, "L")
      val right = tupleType(size2, "R")
      newCompose(
        name = s"T${size1}+T${size2}",
        typeParams = s"${left}, ${right}",
        L = s"(${left})",
        R = s"(${right})",
        O = s"(${left}, ${right})",
        compose = s"(${tupleAccess(size1, "l")}, ${tupleAccess(size2, "r")})",
      )
    }

    enter(s"""trait Compose_Pri${priority} extends Compose_Pri${extendsPriority} {""")("}") {
      println()
      if (minArity <= 2) {
        newCompose(
          name = s"T1+T1",
          typeParams = s"L, R",
          L = s"Tuple1[L]",
          R = s"Tuple1[R]",
          O = s"Tuple2[L, R]",
          compose = s"(l._1, r._1)",
        )
        println()
      }

      for (size <- 2 until to) {
        if (size + 1 >= minArity && size + 1 <= maxArity) {
          forSizeAnd1(size)
          for1AndSize(size)
        }
      }

      if (generateConcats) {
        for (size1 <- 2 to to - 2) {
          for (size2 <- 2 to to - size1) {
            if (size1 + size2 >= minArity && size1 + size2 <= maxArity) {
              forSizes(size1, size2)
            }
          }
        }
      }

      if (minArity == 1) {
        newCompose(
          name = s"unit+A",
          typeParams = s"A",
          L = s"Unit",
          R = s"A",
          O = s"A",
          compose = s"r",
        )

        newCompose(
          name = s"A+unit",
          typeParams = s"A",
          L = s"A",
          R = s"Unit",
          O = s"A",
          compose = s"l",
        )

        println()
      }
    }
  }

  def generateDecomposeHighPriority(minArity: Int, maxArity: Int, priority: Int, extendsPriority: Int): Unit = {

    def forSizeAnd1(size: Int): Unit = {
      val left = tupleType(size)
      newDecompose(
        name = s"T${size}+T1",
        typeParams = s"${left}, R",
        L = s"(${left})",
        R = s"Tuple1[R]",
        O = s"(${left}, R)",
        decompose = s"((${tupleAccess(1, size, "c")}), Tuple1(c._${size + 1}))"
      )
    }

    def for1AndSize(size: Int): Unit = {
      val right = tupleType(size)
      newDecompose(
        name = s"T1+T${size}",
        typeParams = s"L, ${right}",
        L = s"Tuple1[L]",
        R = s"(${right})",
        O = s"(L, ${right})",
        decompose = s"(Tuple1(c._1), (${tupleAccess(2, size + 1, "c")}))"
      )
    }

    def forSizes(size1: Int, size2: Int): Unit = {
      val left  = tupleType(size1, "L")
      val right = tupleType(size2, "R")
      newDecompose(
        name = s"T${size1}+T${size2}",
        typeParams = s"${left}, ${right}",
        L = s"(${left})",
        R = s"(${right})",
        O = s"(${left}, ${right})",
        decompose = s"((${tupleAccess(1, size1, "c")}), (${tupleAccess(size1 + 1, size1 + size2, "c")}))"
      )
    }

    enter(s"""trait Decompose_Pri${priority} extends Decompose_Pri${extendsPriority} {""")("}") {
      println()
      if (minArity <= 2) {
        newDecompose(
          name = s"T1+T1",
          typeParams = s"L, R",
          L = s"Tuple1[L]",
          R = s"Tuple1[R]",
          O = s"Tuple2[L, R]",
          decompose = s"(Tuple1(c._1), Tuple1(c._2))",
        )
        println()
      }

      for (size <- 2 until to) {
        if (size + 1 >= minArity && size + 1 <= maxArity) {
          forSizeAnd1(size)
          for1AndSize(size)
        }
      }

      if (generateConcats) {
        for (size1 <- 2 to to - 2) {
          for (size2 <- 2 to to - size1) {
            if (size1 + size2 >= minArity && size1 + size2 <= maxArity) {
              forSizes(size1, size2)
            }
          }
        }
      }

      if (minArity == 1) {
        newDecompose(
          name = s"unit+A",
          typeParams = s"A",
          L = s"Unit",
          R = s"A",
          O = s"A",
          decompose = s"((), c)"
        )

        newDecompose(
          name = s"A+unit",
          typeParams = s"A",
          L = s"A",
          R = s"Unit",
          O = s"A",
          decompose = s"(c, ())"
        )

        println()
      }
    }
  }

  def generateComposePri10(): Unit = {
    if (splitPriorityAt < to) {
      generateComposeHighPriority(minArity = splitPriorityAt + 1, maxArity = Int.MaxValue, priority = 9, extendsPriority = 7)
      println()
      generateComposeHighPriority(minArity = 1, maxArity = splitPriorityAt, priority = 10, extendsPriority = 9)
    } else {
      generateComposeHighPriority(minArity = 1, maxArity = Int.MaxValue, priority = 10, extendsPriority = 7)
    }
  }

  def generateDecomposePri10(): Unit = {
    if (splitPriorityAt < to) {
      generateDecomposeHighPriority(minArity = splitPriorityAt + 1, maxArity = Int.MaxValue, priority = 9, extendsPriority = 7)
      println()
      generateDecomposeHighPriority(minArity = 1, maxArity = splitPriorityAt, priority = 10, extendsPriority = 9)
    } else {
      generateDecomposeHighPriority(minArity = 1, maxArity = Int.MaxValue, priority = 10, extendsPriority = 7)
    }
  }

}
