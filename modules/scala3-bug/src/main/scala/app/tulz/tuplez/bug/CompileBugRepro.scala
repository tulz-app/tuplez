package app.tulz.tuplez.bug

import app.tulz.tuplez.Compose

/** Compile-only reproduction of a Scala 3.8+ pattern-match reachability (SpaceEngine)
  * false positive that is triggered by tuplez's match-typed `Compose#Composed`.
  *
  * This module is NOT published and is NOT part of the root aggregate, so it never
  * affects normal `compile`/`test`/`publish`. Its whole purpose is that
  * `sbt tuplezScala3Bug/Compile/compile` must succeed. It is a regression
  * guard: with the match-typed `Compose#Composed` (see below) it FAILED on Scala 3.8+,
  * because the pattern matches below raised spurious warnings that `-Werror` turned
  * into errors:
  *
  *   [E030] Match case Unreachable Warning     (on a genuinely reachable case)
  *   [E121] Unreachable case except for null    (on a trailing `case _`)
  *
  * It now compiles clean, because tuplez's Scala 3 `Compose` uses concrete `TupleN`
  * `Composed` types (the universal Scala 2/3 codegen implementation) rather than match
  * types. If a match-typed `Composed` is ever reintroduced, this module goes red again.
  *
  * Why it needs to be its own module: the bug only manifests when `Compose` is
  * consumed across a COMPILATION BOUNDARY (tuplez compiled to TASTy, then this module
  * compiled against it). In that situation the composed element type reaches the
  * pattern match as an existentially-skolemized abstract member `?1.Composed` backed
  * concrete `TupleN`. Compiling the same code in the same unit as `Compose` reduces
  * fine and does not reproduce the bug, so `dependsOn(tuplez-full)` is essential.
  *
  * `Src` mirrors the shape of Airstream's `EventStream#withCurrentValueOf`: a
  * combinator on a holder of `A` that returns a holder of `c.Composed` where `c` is a
  * `using` parameter that goes out of scope on return.
  *
  * Outcome: FAILED to compile on the match-typed `Compose` (Scala 3.8+); COMPILES
  * CLEAN once `Compose#Composed` is a concrete `TupleN` (as now, via the universal
  * codegen impl) or any other non-match type the SpaceEngine can reduce (e.g.
  * structural `*:` cons types).
  */
final class Src[A](val value: A) {

  def map[B](f: A => B): Src[B] = new Src(f(value))

  def collect[B](pf: PartialFunction[A, B]): Src[B] = new Src(pf(value))

  /** Scalar source + 3 sampled values -> flat 4-tuple (Airstream `Scalar+T`). */
  def withCurrentValueOf[T1, T2, T3](t1: T1, t2: T2, t3: T3)(using
      c: Compose[A, (T1, T2, T3)]
  ): Src[c.Composed] =
    new Src(c.compose(value, (t1, t2, t3)))

  /** Scalar source + 4 sampled values -> flat 5-tuple (Airstream `Scalar+T`). */
  def withCurrentValueOf[T1, T2, T3, T4](t1: T1, t2: T2, t3: T3, t4: T4)(using
      c: Compose[A, (T1, T2, T3, T4)]
  ): Src[c.Composed] =
    new Src(c.compose(value, (t1, t2, t3, t4)))
}

object CompileBugRepro {

  private val src: Src[Int] = new Src(1)

  // Airstream DatePan/DateZoom shape: `.map` with `Some`/`Some` plus a trailing `case _`.
  // Triggers [E030] on the real case and [E121] on the `case _`.
  val mapped: Src[String] =
    src
      .withCurrentValueOf("preset", Option("a"), Option(1L))
      .map {
        case (n, preset, Some(a), Some(b)) => s"$n-$preset-$a-$b"
        case _                             => "none"
      }

  // Airstream NavigatorPan shape: `.collect` across a 5-tuple. Triggers [E030].
  val collected: Src[(Int, String, String, String, String)] =
    src
      .withCurrentValueOf(Option("x"), Option("y"), "lup", Option("z"))
      .collect { case (ev, Some(x), Some(y), l, Some(z)) => (ev, x, y, l, z) }
}
