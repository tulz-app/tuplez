package app.tulz.tuplez

object TupleComposition {

  def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)
  def decompose[L, R, C](c: C)(implicit composition: Composition.Aux[L, R, C]): (L, R)         = composition.decompose(c)

}

abstract class Composition[L, R] {
  type Composed
  val compose: (L, R) => Composed
  def decompose(c: Composed): (L, R)
}

trait Composition_Pri0 {
  implicit def `***`[A, B]: Composition.Aux[A, B, Tuple2[A, B]] = new Composition[A, B] {

    override type Composed = Tuple2[A, B]

    val compose: (A, B) => Tuple2[A, B] = (l, r) =>
      Tuple2(l, r)
    
    def decompose(c: Tuple2[A, B]): (A, B) =
      c
    
  }
}

trait Composition_Pri5 extends Composition_Pri0{
  implicit def `T1+R`[L, R]: Composition.Aux[Tuple1[L], R, Tuple2[L, R]] = new Composition[Tuple1[L], R] {

    override type Composed = Tuple2[L, R]

    val compose: (Tuple1[L], R) => Tuple2[L, R] = (l, r) =>
      Tuple2(l._1, r)
    
    def decompose(c: Tuple2[L, R]): (Tuple1[L], R) =
      Tuple2(Tuple1(c._1), c._2)
    
  }
  implicit def `L+T1`[L, R]: Composition.Aux[L, Tuple1[R], Tuple2[L, R]] = new Composition[L, Tuple1[R]] {

    override type Composed = Tuple2[L, R]

    val compose: (L, Tuple1[R]) => Tuple2[L, R] = (l, r) =>
      Tuple2(l, r._1)
    
    def decompose(c: Tuple2[L, R]): (L, Tuple1[R]) =
      Tuple2(c._1, Tuple1(c._2))
    
  }
}

trait Composition_Pri7 extends Composition_Pri5 {

  implicit def `T2+scalar`[T1, T2, R]: Composition.Aux[(T1, T2), R, (T1, T2, R)] = new Composition[(T1, T2), R] {

    override type Composed = (T1, T2, R)

    val compose: ((T1, T2), R) => (T1, T2, R) = (l, r) =>
      (l._1, l._2, r)
    
    def decompose(c: (T1, T2, R)): ((T1, T2), R) =
      ((c._1, c._2), c._3)
    
  }
  implicit def `scalar+T2`[L, T1, T2]: Composition.Aux[L, (T1, T2), (L, T1, T2)] = new Composition[L, (T1, T2)] {

    override type Composed = (L, T1, T2)

    val compose: (L, (T1, T2)) => (L, T1, T2) = (l, r) =>
      (l, r._1, r._2)
    
    def decompose(c: (L, T1, T2)): (L, (T1, T2)) =
      (c._1, (c._2, c._3))
    
  }
  implicit def `T3+scalar`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), R, (T1, T2, T3, R)] = new Composition[(T1, T2, T3), R] {

    override type Composed = (T1, T2, T3, R)

    val compose: ((T1, T2, T3), R) => (T1, T2, T3, R) = (l, r) =>
      (l._1, l._2, l._3, r)
    
    def decompose(c: (T1, T2, T3, R)): ((T1, T2, T3), R) =
      ((c._1, c._2, c._3), c._4)
    
  }
  implicit def `scalar+T3`[L, T1, T2, T3]: Composition.Aux[L, (T1, T2, T3), (L, T1, T2, T3)] = new Composition[L, (T1, T2, T3)] {

    override type Composed = (L, T1, T2, T3)

    val compose: (L, (T1, T2, T3)) => (L, T1, T2, T3) = (l, r) =>
      (l, r._1, r._2, r._3)
    
    def decompose(c: (L, T1, T2, T3)): (L, (T1, T2, T3)) =
      (c._1, (c._2, c._3, c._4))
    
  }
  implicit def `T4+scalar`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)] = new Composition[(T1, T2, T3, T4), R] {

    override type Composed = (T1, T2, T3, T4, R)

    val compose: ((T1, T2, T3, T4), R) => (T1, T2, T3, T4, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, r)
    
    def decompose(c: (T1, T2, T3, T4, R)): ((T1, T2, T3, T4), R) =
      ((c._1, c._2, c._3, c._4), c._5)
    
  }
  implicit def `scalar+T4`[L, T1, T2, T3, T4]: Composition.Aux[L, (T1, T2, T3, T4), (L, T1, T2, T3, T4)] = new Composition[L, (T1, T2, T3, T4)] {

    override type Composed = (L, T1, T2, T3, T4)

    val compose: (L, (T1, T2, T3, T4)) => (L, T1, T2, T3, T4) = (l, r) =>
      (l, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L, T1, T2, T3, T4)): (L, (T1, T2, T3, T4)) =
      (c._1, (c._2, c._3, c._4, c._5))
    
  }
  implicit def `T5+scalar`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)] = new Composition[(T1, T2, T3, T4, T5), R] {

    override type Composed = (T1, T2, T3, T4, T5, R)

    val compose: ((T1, T2, T3, T4, T5), R) => (T1, T2, T3, T4, T5, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, R)): ((T1, T2, T3, T4, T5), R) =
      ((c._1, c._2, c._3, c._4, c._5), c._6)
    
  }
  implicit def `scalar+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[L, (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] = new Composition[L, (T1, T2, T3, T4, T5)] {

    override type Composed = (L, T1, T2, T3, T4, T5)

    val compose: (L, (T1, T2, T3, T4, T5)) => (L, T1, T2, T3, T4, T5) = (l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L, T1, T2, T3, T4, T5)): (L, (T1, T2, T3, T4, T5)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6))
    
  }
  implicit def `T6+scalar`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)] = new Composition[(T1, T2, T3, T4, T5, T6), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, R)

    val compose: ((T1, T2, T3, T4, T5, T6), R) => (T1, T2, T3, T4, T5, T6, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, R)): ((T1, T2, T3, T4, T5, T6), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), c._7)
    
  }
  implicit def `scalar+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] = new Composition[L, (T1, T2, T3, T4, T5, T6)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6)

    val compose: (L, (T1, T2, T3, T4, T5, T6)) => (L, T1, T2, T3, T4, T5, T6) = (l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6)): (L, (T1, T2, T3, T4, T5, T6)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T7+scalar`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, R)

    val compose: ((T1, T2, T3, T4, T5, T6, T7), R) => (T1, T2, T3, T4, T5, T6, T7, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, R)): ((T1, T2, T3, T4, T5, T6, T7), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), c._8)
    
  }
  implicit def `scalar+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7)

    val compose: (L, (T1, T2, T3, T4, T5, T6, T7)) => (L, T1, T2, T3, T4, T5, T6, T7) = (l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7)): (L, (T1, T2, T3, T4, T5, T6, T7)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T8+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, R)

    val compose: ((T1, T2, T3, T4, T5, T6, T7, T8), R) => (T1, T2, T3, T4, T5, T6, T7, T8, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, R)): ((T1, T2, T3, T4, T5, T6, T7, T8), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), c._9)
    
  }
  implicit def `scalar+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8)

    val compose: (L, (T1, T2, T3, T4, T5, T6, T7, T8)) => (L, T1, T2, T3, T4, T5, T6, T7, T8) = (l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8)): (L, (T1, T2, T3, T4, T5, T6, T7, T8)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T9+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)

    val compose: ((T1, T2, T3, T4, T5, T6, T7, T8, T9), R) => (T1, T2, T3, T4, T5, T6, T7, T8, T9, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), c._10)
    
  }
  implicit def `scalar+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)

    val compose: (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9)) => (L, T1, T2, T3, T4, T5, T6, T7, T8, T9) = (l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
}

trait Composition_Pri10 extends Composition_Pri7 {

  implicit def `T1+T1`[L, R]: Composition.Aux[Tuple1[L], Tuple1[R], Tuple2[L, R]] = new Composition[Tuple1[L], Tuple1[R]] {

    override type Composed = Tuple2[L, R]

    val compose: (Tuple1[L], Tuple1[R]) => Tuple2[L, R] = (l, r) =>
      (l._1, r._1)
    
    def decompose(c: Tuple2[L, R]): (Tuple1[L], Tuple1[R]) =
      (Tuple1(c._1), Tuple1(c._2))
    
  }

  implicit def `T2+T1`[T1, T2, R]: Composition.Aux[(T1, T2), Tuple1[R], (T1, T2, R)] = new Composition[(T1, T2), Tuple1[R]] {

    override type Composed = (T1, T2, R)

    val compose: ((T1, T2), Tuple1[R]) => (T1, T2, R) = (l, r) =>
      (l._1, l._2, r._1)
    
    def decompose(c: (T1, T2, R)): ((T1, T2), Tuple1[R]) =
      ((c._1, c._2), Tuple1(c._3))
    
  }
  implicit def `T1+T2`[L, T1, T2]: Composition.Aux[Tuple1[L], (T1, T2), (L, T1, T2)] = new Composition[Tuple1[L], (T1, T2)] {

    override type Composed = (L, T1, T2)

    val compose: (Tuple1[L], (T1, T2)) => (L, T1, T2) = (l, r) =>
      (l._1, r._1, r._2)
    
    def decompose(c: (L, T1, T2)): (Tuple1[L], (T1, T2)) =
      (Tuple1(c._1), (c._2, c._3))
    
  }
  implicit def `T3+T1`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), Tuple1[R], (T1, T2, T3, R)] = new Composition[(T1, T2, T3), Tuple1[R]] {

    override type Composed = (T1, T2, T3, R)

    val compose: ((T1, T2, T3), Tuple1[R]) => (T1, T2, T3, R) = (l, r) =>
      (l._1, l._2, l._3, r._1)
    
    def decompose(c: (T1, T2, T3, R)): ((T1, T2, T3), Tuple1[R]) =
      ((c._1, c._2, c._3), Tuple1(c._4))
    
  }
  implicit def `T1+T3`[L, T1, T2, T3]: Composition.Aux[Tuple1[L], (T1, T2, T3), (L, T1, T2, T3)] = new Composition[Tuple1[L], (T1, T2, T3)] {

    override type Composed = (L, T1, T2, T3)

    val compose: (Tuple1[L], (T1, T2, T3)) => (L, T1, T2, T3) = (l, r) =>
      (l._1, r._1, r._2, r._3)
    
    def decompose(c: (L, T1, T2, T3)): (Tuple1[L], (T1, T2, T3)) =
      (Tuple1(c._1), (c._2, c._3, c._4))
    
  }
  implicit def `T4+T1`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), Tuple1[R], (T1, T2, T3, T4, R)] = new Composition[(T1, T2, T3, T4), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, R)

    val compose: ((T1, T2, T3, T4), Tuple1[R]) => (T1, T2, T3, T4, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, r._1)
    
    def decompose(c: (T1, T2, T3, T4, R)): ((T1, T2, T3, T4), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4), Tuple1(c._5))
    
  }
  implicit def `T1+T4`[L, T1, T2, T3, T4]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4), (L, T1, T2, T3, T4)] = new Composition[Tuple1[L], (T1, T2, T3, T4)] {

    override type Composed = (L, T1, T2, T3, T4)

    val compose: (Tuple1[L], (T1, T2, T3, T4)) => (L, T1, T2, T3, T4) = (l, r) =>
      (l._1, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L, T1, T2, T3, T4)): (Tuple1[L], (T1, T2, T3, T4)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5))
    
  }
  implicit def `T5+T1`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), Tuple1[R], (T1, T2, T3, T4, T5, R)] = new Composition[(T1, T2, T3, T4, T5), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, R)

    val compose: ((T1, T2, T3, T4, T5), Tuple1[R]) => (T1, T2, T3, T4, T5, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, R)): ((T1, T2, T3, T4, T5), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5), Tuple1(c._6))
    
  }
  implicit def `T1+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5)] {

    override type Composed = (L, T1, T2, T3, T4, T5)

    val compose: (Tuple1[L], (T1, T2, T3, T4, T5)) => (L, T1, T2, T3, T4, T5) = (l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L, T1, T2, T3, T4, T5)): (Tuple1[L], (T1, T2, T3, T4, T5)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6))
    
  }
  implicit def `T6+T1`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), Tuple1[R], (T1, T2, T3, T4, T5, T6, R)] = new Composition[(T1, T2, T3, T4, T5, T6), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, R)

    val compose: ((T1, T2, T3, T4, T5, T6), Tuple1[R]) => (T1, T2, T3, T4, T5, T6, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, R)): ((T1, T2, T3, T4, T5, T6), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), Tuple1(c._7))
    
  }
  implicit def `T1+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6)

    val compose: (Tuple1[L], (T1, T2, T3, T4, T5, T6)) => (L, T1, T2, T3, T4, T5, T6) = (l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6)): (Tuple1[L], (T1, T2, T3, T4, T5, T6)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T7+T1`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, R)

    val compose: ((T1, T2, T3, T4, T5, T6, T7), Tuple1[R]) => (T1, T2, T3, T4, T5, T6, T7, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, R)): ((T1, T2, T3, T4, T5, T6, T7), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), Tuple1(c._8))
    
  }
  implicit def `T1+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7)

    val compose: (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)) => (L, T1, T2, T3, T4, T5, T6, T7) = (l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T8+T1`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, R)

    val compose: ((T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]) => (T1, T2, T3, T4, T5, T6, T7, T8, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, R)): ((T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), Tuple1(c._9))
    
  }
  implicit def `T1+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8)

    val compose: (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)) => (L, T1, T2, T3, T4, T5, T6, T7, T8) = (l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T9+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)

    val compose: ((T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]) => (T1, T2, T3, T4, T5, T6, T7, T8, T9, R) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), Tuple1(c._10))
    
  }
  implicit def `T1+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)

    val compose: (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)) => (L, T1, T2, T3, T4, T5, T6, T7, T8, T9) = (l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T2+T2`[L1, L2, R1, R2]: Composition.Aux[(L1, L2), (R1, R2), (L1, L2, R1, R2)] = new Composition[(L1, L2), (R1, R2)] {

    override type Composed = (L1, L2, R1, R2)

    val compose: ((L1, L2), (R1, R2)) => (L1, L2, R1, R2) = (l, r) =>
      (l._1, l._2, r._1, r._2)
    
    def decompose(c: (L1, L2, R1, R2)): ((L1, L2), (R1, R2)) =
      ((c._1, c._2), (c._3, c._4))
    
  }
  implicit def `T2+T3`[L1, L2, R1, R2, R3]: Composition.Aux[(L1, L2), (R1, R2, R3), (L1, L2, R1, R2, R3)] = new Composition[(L1, L2), (R1, R2, R3)] {

    override type Composed = (L1, L2, R1, R2, R3)

    val compose: ((L1, L2), (R1, R2, R3)) => (L1, L2, R1, R2, R3) = (l, r) =>
      (l._1, l._2, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, R1, R2, R3)): ((L1, L2), (R1, R2, R3)) =
      ((c._1, c._2), (c._3, c._4, c._5))
    
  }
  implicit def `T2+T4`[L1, L2, R1, R2, R3, R4]: Composition.Aux[(L1, L2), (R1, R2, R3, R4), (L1, L2, R1, R2, R3, R4)] = new Composition[(L1, L2), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, R1, R2, R3, R4)

    val compose: ((L1, L2), (R1, R2, R3, R4)) => (L1, L2, R1, R2, R3, R4) = (l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4)): ((L1, L2), (R1, R2, R3, R4)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6))
    
  }
  implicit def `T2+T5`[L1, L2, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5), (L1, L2, R1, R2, R3, R4, R5)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5)

    val compose: ((L1, L2), (R1, R2, R3, R4, R5)) => (L1, L2, R1, R2, R3, R4, R5) = (l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5)): ((L1, L2), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T2+T6`[L1, L2, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6), (L1, L2, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6)

    val compose: ((L1, L2), (R1, R2, R3, R4, R5, R6)) => (L1, L2, R1, R2, R3, R4, R5, R6) = (l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6)): ((L1, L2), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T2+T7`[L1, L2, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7)

    val compose: ((L1, L2), (R1, R2, R3, R4, R5, R6, R7)) => (L1, L2, R1, R2, R3, R4, R5, R6, R7) = (l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T2+T8`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)

    val compose: ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8)) => (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8) = (l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T3+T2`[L1, L2, L3, R1, R2]: Composition.Aux[(L1, L2, L3), (R1, R2), (L1, L2, L3, R1, R2)] = new Composition[(L1, L2, L3), (R1, R2)] {

    override type Composed = (L1, L2, L3, R1, R2)

    val compose: ((L1, L2, L3), (R1, R2)) => (L1, L2, L3, R1, R2) = (l, r) =>
      (l._1, l._2, l._3, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, R1, R2)): ((L1, L2, L3), (R1, R2)) =
      ((c._1, c._2, c._3), (c._4, c._5))
    
  }
  implicit def `T3+T3`[L1, L2, L3, R1, R2, R3]: Composition.Aux[(L1, L2, L3), (R1, R2, R3), (L1, L2, L3, R1, R2, R3)] = new Composition[(L1, L2, L3), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, R1, R2, R3)

    val compose: ((L1, L2, L3), (R1, R2, R3)) => (L1, L2, L3, R1, R2, R3) = (l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3)): ((L1, L2, L3), (R1, R2, R3)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6))
    
  }
  implicit def `T3+T4`[L1, L2, L3, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4), (L1, L2, L3, R1, R2, R3, R4)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4)

    val compose: ((L1, L2, L3), (R1, R2, R3, R4)) => (L1, L2, L3, R1, R2, R3, R4) = (l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4)): ((L1, L2, L3), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7))
    
  }
  implicit def `T3+T5`[L1, L2, L3, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5), (L1, L2, L3, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5)

    val compose: ((L1, L2, L3), (R1, R2, R3, R4, R5)) => (L1, L2, L3, R1, R2, R3, R4, R5) = (l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5)): ((L1, L2, L3), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T3+T6`[L1, L2, L3, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6)

    val compose: ((L1, L2, L3), (R1, R2, R3, R4, R5, R6)) => (L1, L2, L3, R1, R2, R3, R4, R5, R6) = (l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T3+T7`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)

    val compose: ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7)) => (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7) = (l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T4+T2`[L1, L2, L3, L4, R1, R2]: Composition.Aux[(L1, L2, L3, L4), (R1, R2), (L1, L2, L3, L4, R1, R2)] = new Composition[(L1, L2, L3, L4), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, R1, R2)

    val compose: ((L1, L2, L3, L4), (R1, R2)) => (L1, L2, L3, L4, R1, R2) = (l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2)): ((L1, L2, L3, L4), (R1, R2)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6))
    
  }
  implicit def `T4+T3`[L1, L2, L3, L4, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3), (L1, L2, L3, L4, R1, R2, R3)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3)

    val compose: ((L1, L2, L3, L4), (R1, R2, R3)) => (L1, L2, L3, L4, R1, R2, R3) = (l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3)): ((L1, L2, L3, L4), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7))
    
  }
  implicit def `T4+T4`[L1, L2, L3, L4, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4), (L1, L2, L3, L4, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4)

    val compose: ((L1, L2, L3, L4), (R1, R2, R3, R4)) => (L1, L2, L3, L4, R1, R2, R3, R4) = (l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4)): ((L1, L2, L3, L4), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8))
    
  }
  implicit def `T4+T5`[L1, L2, L3, L4, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5)

    val compose: ((L1, L2, L3, L4), (R1, R2, R3, R4, R5)) => (L1, L2, L3, L4, R1, R2, R3, R4, R5) = (l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T4+T6`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)

    val compose: ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6)) => (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6) = (l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T5+T2`[L1, L2, L3, L4, L5, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2), (L1, L2, L3, L4, L5, R1, R2)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2)

    val compose: ((L1, L2, L3, L4, L5), (R1, R2)) => (L1, L2, L3, L4, L5, R1, R2) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2)): ((L1, L2, L3, L4, L5), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7))
    
  }
  implicit def `T5+T3`[L1, L2, L3, L4, L5, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3), (L1, L2, L3, L4, L5, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3)

    val compose: ((L1, L2, L3, L4, L5), (R1, R2, R3)) => (L1, L2, L3, L4, L5, R1, R2, R3) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3)): ((L1, L2, L3, L4, L5), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8))
    
  }
  implicit def `T5+T4`[L1, L2, L3, L4, L5, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4)

    val compose: ((L1, L2, L3, L4, L5), (R1, R2, R3, R4)) => (L1, L2, L3, L4, L5, R1, R2, R3, R4) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9))
    
  }
  implicit def `T5+T5`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)

    val compose: ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5)) => (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T6+T2`[L1, L2, L3, L4, L5, L6, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2), (L1, L2, L3, L4, L5, L6, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2)

    val compose: ((L1, L2, L3, L4, L5, L6), (R1, R2)) => (L1, L2, L3, L4, L5, L6, R1, R2) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2)): ((L1, L2, L3, L4, L5, L6), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8))
    
  }
  implicit def `T6+T3`[L1, L2, L3, L4, L5, L6, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3)

    val compose: ((L1, L2, L3, L4, L5, L6), (R1, R2, R3)) => (L1, L2, L3, L4, L5, L6, R1, R2, R3) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9))
    
  }
  implicit def `T6+T4`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)

    val compose: ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4)) => (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10))
    
  }
  implicit def `T7+T2`[L1, L2, L3, L4, L5, L6, L7, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2)

    val compose: ((L1, L2, L3, L4, L5, L6, L7), (R1, R2)) => (L1, L2, L3, L4, L5, L6, L7, R1, R2) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9))
    
  }
  implicit def `T7+T3`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)

    val compose: ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3)) => (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10))
    
  }
  implicit def `T8+T2`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)

    val compose: ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2)) => (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2) = (l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10))
    
  }
  implicit def `unit+A`[A]: Composition.Aux[Unit, A, A] = new Composition[Unit, A] {

    override type Composed = A

    val compose: (Unit, A) => A = (l, r) =>
      r
    
    def decompose(c: A): (Unit, A) =
      ((), c)
    
  }
  implicit def `A+unit`[A]: Composition.Aux[A, Unit, A] = new Composition[A, Unit] {

    override type Composed = A

    val compose: (A, Unit) => A = (l, r) =>
      l
    
    def decompose(c: A): (A, Unit) =
      (c, ())
    
  }

}

object Composition extends Composition_Pri10 {
  type Aux[A, B, O] = Composition[A, B] { type Composed = O }

  implicit def `unit+unit`: Composition.Aux[Unit, Unit, Unit] = new Composition[Unit, Unit] {

    override type Composed = Unit

    val compose: (Unit, Unit) => Unit = (l, r) =>
      ()
    
    def decompose(c: Unit): (Unit, Unit) =
      ((), ())
    
  }

}
