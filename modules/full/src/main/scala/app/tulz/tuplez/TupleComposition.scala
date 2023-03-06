package app.tulz.tuplez

object TupleComposition {

  def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)
  def decompose[L, R, C](c: C)(implicit composition: Composition.Aux[L, R, C]): (L, R)         = composition.decompose(c)

}

abstract class Composition[L, R] {
  type Composed
  def compose(a: L, b: R): Composed
  def decompose(c: Composed): (L, R)
}

trait Composition_Pri0 {
  implicit def `***`[A, B]: Composition.Aux[A, B, Tuple2[A, B]] = new Composition[A, B] {

    override type Composed = Tuple2[A, B]

    def compose(l: A, r: B): Tuple2[A, B] =
      Tuple2(l, r)
    
    def decompose(c: Tuple2[A, B]): (A, B) =
      c
    
  }
}

trait Composition_Pri5 extends Composition_Pri0{
  implicit def `T1+R`[L, R]: Composition.Aux[Tuple1[L], R, Tuple2[L, R]] = new Composition[Tuple1[L], R] {

    override type Composed = Tuple2[L, R]

    def compose(l: Tuple1[L], r: R): Tuple2[L, R] =
      Tuple2(l._1, r)
    
    def decompose(c: Tuple2[L, R]): (Tuple1[L], R) =
      Tuple2(Tuple1(c._1), c._2)
    
  }
  implicit def `L+T1`[L, R]: Composition.Aux[L, Tuple1[R], Tuple2[L, R]] = new Composition[L, Tuple1[R]] {

    override type Composed = Tuple2[L, R]

    def compose(l: L, r: Tuple1[R]): Tuple2[L, R] =
      Tuple2(l, r._1)
    
    def decompose(c: Tuple2[L, R]): (L, Tuple1[R]) =
      Tuple2(c._1, Tuple1(c._2))
    
  }
}

trait Composition_Pri7 extends Composition_Pri5 {

  implicit def `T2+scalar`[T1, T2, R]: Composition.Aux[(T1, T2), R, (T1, T2, R)] = new Composition[(T1, T2), R] {

    override type Composed = (T1, T2, R)

    def compose(l: (T1, T2), r: R): (T1, T2, R) =
      (l._1, l._2, r)
    
    def decompose(c: (T1, T2, R)): ((T1, T2), R) =
      ((c._1, c._2), c._3)
    
  }
  implicit def `scalar+T2`[L, T1, T2]: Composition.Aux[L, (T1, T2), (L, T1, T2)] = new Composition[L, (T1, T2)] {

    override type Composed = (L, T1, T2)

    def compose(l: L, r: (T1, T2)): (L, T1, T2) =
      (l, r._1, r._2)
    
    def decompose(c: (L, T1, T2)): (L, (T1, T2)) =
      (c._1, (c._2, c._3))
    
  }
  implicit def `T3+scalar`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), R, (T1, T2, T3, R)] = new Composition[(T1, T2, T3), R] {

    override type Composed = (T1, T2, T3, R)

    def compose(l: (T1, T2, T3), r: R): (T1, T2, T3, R) =
      (l._1, l._2, l._3, r)
    
    def decompose(c: (T1, T2, T3, R)): ((T1, T2, T3), R) =
      ((c._1, c._2, c._3), c._4)
    
  }
  implicit def `scalar+T3`[L, T1, T2, T3]: Composition.Aux[L, (T1, T2, T3), (L, T1, T2, T3)] = new Composition[L, (T1, T2, T3)] {

    override type Composed = (L, T1, T2, T3)

    def compose(l: L, r: (T1, T2, T3)): (L, T1, T2, T3) =
      (l, r._1, r._2, r._3)
    
    def decompose(c: (L, T1, T2, T3)): (L, (T1, T2, T3)) =
      (c._1, (c._2, c._3, c._4))
    
  }
  implicit def `T4+scalar`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)] = new Composition[(T1, T2, T3, T4), R] {

    override type Composed = (T1, T2, T3, T4, R)

    def compose(l: (T1, T2, T3, T4), r: R): (T1, T2, T3, T4, R) =
      (l._1, l._2, l._3, l._4, r)
    
    def decompose(c: (T1, T2, T3, T4, R)): ((T1, T2, T3, T4), R) =
      ((c._1, c._2, c._3, c._4), c._5)
    
  }
  implicit def `scalar+T4`[L, T1, T2, T3, T4]: Composition.Aux[L, (T1, T2, T3, T4), (L, T1, T2, T3, T4)] = new Composition[L, (T1, T2, T3, T4)] {

    override type Composed = (L, T1, T2, T3, T4)

    def compose(l: L, r: (T1, T2, T3, T4)): (L, T1, T2, T3, T4) =
      (l, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L, T1, T2, T3, T4)): (L, (T1, T2, T3, T4)) =
      (c._1, (c._2, c._3, c._4, c._5))
    
  }
  implicit def `T5+scalar`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)] = new Composition[(T1, T2, T3, T4, T5), R] {

    override type Composed = (T1, T2, T3, T4, T5, R)

    def compose(l: (T1, T2, T3, T4, T5), r: R): (T1, T2, T3, T4, T5, R) =
      (l._1, l._2, l._3, l._4, l._5, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, R)): ((T1, T2, T3, T4, T5), R) =
      ((c._1, c._2, c._3, c._4, c._5), c._6)
    
  }
  implicit def `scalar+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[L, (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] = new Composition[L, (T1, T2, T3, T4, T5)] {

    override type Composed = (L, T1, T2, T3, T4, T5)

    def compose(l: L, r: (T1, T2, T3, T4, T5)): (L, T1, T2, T3, T4, T5) =
      (l, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L, T1, T2, T3, T4, T5)): (L, (T1, T2, T3, T4, T5)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6))
    
  }
  implicit def `T6+scalar`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)] = new Composition[(T1, T2, T3, T4, T5, T6), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, R)

    def compose(l: (T1, T2, T3, T4, T5, T6), r: R): (T1, T2, T3, T4, T5, T6, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, R)): ((T1, T2, T3, T4, T5, T6), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), c._7)
    
  }
  implicit def `scalar+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] = new Composition[L, (T1, T2, T3, T4, T5, T6)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6)): (L, T1, T2, T3, T4, T5, T6) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6)): (L, (T1, T2, T3, T4, T5, T6)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T7+scalar`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7), r: R): (T1, T2, T3, T4, T5, T6, T7, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, R)): ((T1, T2, T3, T4, T5, T6, T7), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), c._8)
    
  }
  implicit def `scalar+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7)): (L, T1, T2, T3, T4, T5, T6, T7) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7)): (L, (T1, T2, T3, T4, T5, T6, T7)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T8+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, R)): ((T1, T2, T3, T4, T5, T6, T7, T8), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), c._9)
    
  }
  implicit def `scalar+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8)): (L, T1, T2, T3, T4, T5, T6, T7, T8) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8)): (L, (T1, T2, T3, T4, T5, T6, T7, T8)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T9+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), c._10)
    
  }
  implicit def `scalar+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T10+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), c._11)
    
  }
  implicit def `scalar+T10`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T11+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), c._12)
    
  }
  implicit def `scalar+T11`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T12+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), c._13)
    
  }
  implicit def `scalar+T12`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T13+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), c._14)
    
  }
  implicit def `scalar+T13`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T14+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), c._15)
    
  }
  implicit def `scalar+T14`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T15+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), c._16)
    
  }
  implicit def `scalar+T15`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T16+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), c._17)
    
  }
  implicit def `scalar+T16`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T17+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), c._18)
    
  }
  implicit def `scalar+T17`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T18+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), c._19)
    
  }
  implicit def `scalar+T18`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T19+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19), c._20)
    
  }
  implicit def `scalar+T19`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T20+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20), c._21)
    
  }
  implicit def `scalar+T20`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T21+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21), c._22)
    
  }
  implicit def `scalar+T21`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] = new Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)

    def compose(l: L, r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) =
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20, r._21)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): (L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)) =
      (c._1, (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
}

trait Composition_Pri10 extends Composition_Pri7 {

  implicit def `T1+T1`[L, R]: Composition.Aux[Tuple1[L], Tuple1[R], Tuple2[L, R]] = new Composition[Tuple1[L], Tuple1[R]] {

    override type Composed = Tuple2[L, R]

    def compose(l: Tuple1[L], r: Tuple1[R]): Tuple2[L, R] =
      (l._1, r._1)
    
    def decompose(c: Tuple2[L, R]): (Tuple1[L], Tuple1[R]) =
      (Tuple1(c._1), Tuple1(c._2))
    
  }

  implicit def `T2+T1`[T1, T2, R]: Composition.Aux[(T1, T2), Tuple1[R], (T1, T2, R)] = new Composition[(T1, T2), Tuple1[R]] {

    override type Composed = (T1, T2, R)

    def compose(l: (T1, T2), r: Tuple1[R]): (T1, T2, R) =
      (l._1, l._2, r._1)
    
    def decompose(c: (T1, T2, R)): ((T1, T2), Tuple1[R]) =
      ((c._1, c._2), Tuple1(c._3))
    
  }
  implicit def `T1+T2`[L, T1, T2]: Composition.Aux[Tuple1[L], (T1, T2), (L, T1, T2)] = new Composition[Tuple1[L], (T1, T2)] {

    override type Composed = (L, T1, T2)

    def compose(l: Tuple1[L], r: (T1, T2)): (L, T1, T2) =
      (l._1, r._1, r._2)
    
    def decompose(c: (L, T1, T2)): (Tuple1[L], (T1, T2)) =
      (Tuple1(c._1), (c._2, c._3))
    
  }
  implicit def `T3+T1`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), Tuple1[R], (T1, T2, T3, R)] = new Composition[(T1, T2, T3), Tuple1[R]] {

    override type Composed = (T1, T2, T3, R)

    def compose(l: (T1, T2, T3), r: Tuple1[R]): (T1, T2, T3, R) =
      (l._1, l._2, l._3, r._1)
    
    def decompose(c: (T1, T2, T3, R)): ((T1, T2, T3), Tuple1[R]) =
      ((c._1, c._2, c._3), Tuple1(c._4))
    
  }
  implicit def `T1+T3`[L, T1, T2, T3]: Composition.Aux[Tuple1[L], (T1, T2, T3), (L, T1, T2, T3)] = new Composition[Tuple1[L], (T1, T2, T3)] {

    override type Composed = (L, T1, T2, T3)

    def compose(l: Tuple1[L], r: (T1, T2, T3)): (L, T1, T2, T3) =
      (l._1, r._1, r._2, r._3)
    
    def decompose(c: (L, T1, T2, T3)): (Tuple1[L], (T1, T2, T3)) =
      (Tuple1(c._1), (c._2, c._3, c._4))
    
  }
  implicit def `T4+T1`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), Tuple1[R], (T1, T2, T3, T4, R)] = new Composition[(T1, T2, T3, T4), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, R)

    def compose(l: (T1, T2, T3, T4), r: Tuple1[R]): (T1, T2, T3, T4, R) =
      (l._1, l._2, l._3, l._4, r._1)
    
    def decompose(c: (T1, T2, T3, T4, R)): ((T1, T2, T3, T4), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4), Tuple1(c._5))
    
  }
  implicit def `T1+T4`[L, T1, T2, T3, T4]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4), (L, T1, T2, T3, T4)] = new Composition[Tuple1[L], (T1, T2, T3, T4)] {

    override type Composed = (L, T1, T2, T3, T4)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4)): (L, T1, T2, T3, T4) =
      (l._1, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L, T1, T2, T3, T4)): (Tuple1[L], (T1, T2, T3, T4)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5))
    
  }
  implicit def `T5+T1`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), Tuple1[R], (T1, T2, T3, T4, T5, R)] = new Composition[(T1, T2, T3, T4, T5), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, R)

    def compose(l: (T1, T2, T3, T4, T5), r: Tuple1[R]): (T1, T2, T3, T4, T5, R) =
      (l._1, l._2, l._3, l._4, l._5, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, R)): ((T1, T2, T3, T4, T5), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5), Tuple1(c._6))
    
  }
  implicit def `T1+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5)] {

    override type Composed = (L, T1, T2, T3, T4, T5)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5)): (L, T1, T2, T3, T4, T5) =
      (l._1, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L, T1, T2, T3, T4, T5)): (Tuple1[L], (T1, T2, T3, T4, T5)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6))
    
  }
  implicit def `T6+T1`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), Tuple1[R], (T1, T2, T3, T4, T5, T6, R)] = new Composition[(T1, T2, T3, T4, T5, T6), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, R)

    def compose(l: (T1, T2, T3, T4, T5, T6), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, R)): ((T1, T2, T3, T4, T5, T6), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), Tuple1(c._7))
    
  }
  implicit def `T1+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6)): (L, T1, T2, T3, T4, T5, T6) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6)): (Tuple1[L], (T1, T2, T3, T4, T5, T6)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T7+T1`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, R)): ((T1, T2, T3, T4, T5, T6, T7), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), Tuple1(c._8))
    
  }
  implicit def `T1+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7)): (L, T1, T2, T3, T4, T5, T6, T7) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T8+T1`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, R)): ((T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), Tuple1(c._9))
    
  }
  implicit def `T1+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8)): (L, T1, T2, T3, T4, T5, T6, T7, T8) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T9+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), Tuple1(c._10))
    
  }
  implicit def `T1+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T10+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), Tuple1(c._11))
    
  }
  implicit def `T1+T10`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T11+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), Tuple1(c._12))
    
  }
  implicit def `T1+T11`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T12+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), Tuple1(c._13))
    
  }
  implicit def `T1+T12`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T13+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), Tuple1(c._14))
    
  }
  implicit def `T1+T13`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T14+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), Tuple1(c._15))
    
  }
  implicit def `T1+T14`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T15+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), Tuple1(c._16))
    
  }
  implicit def `T1+T15`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T16+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), Tuple1(c._17))
    
  }
  implicit def `T1+T16`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T17+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), Tuple1(c._18))
    
  }
  implicit def `T1+T17`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T18+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), Tuple1(c._19))
    
  }
  implicit def `T1+T18`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T19+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19), Tuple1(c._20))
    
  }
  implicit def `T1+T19`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T20+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20), Tuple1(c._21))
    
  }
  implicit def `T1+T20`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T21+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r._1)
    
    def decompose(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21), Tuple1(c._22))
    
  }
  implicit def `T1+T21`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20, r._21)
    
    def decompose(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T2+T2`[L1, L2, R1, R2]: Composition.Aux[(L1, L2), (R1, R2), (L1, L2, R1, R2)] = new Composition[(L1, L2), (R1, R2)] {

    override type Composed = (L1, L2, R1, R2)

    def compose(l: (L1, L2), r: (R1, R2)): (L1, L2, R1, R2) =
      (l._1, l._2, r._1, r._2)
    
    def decompose(c: (L1, L2, R1, R2)): ((L1, L2), (R1, R2)) =
      ((c._1, c._2), (c._3, c._4))
    
  }
  implicit def `T2+T3`[L1, L2, R1, R2, R3]: Composition.Aux[(L1, L2), (R1, R2, R3), (L1, L2, R1, R2, R3)] = new Composition[(L1, L2), (R1, R2, R3)] {

    override type Composed = (L1, L2, R1, R2, R3)

    def compose(l: (L1, L2), r: (R1, R2, R3)): (L1, L2, R1, R2, R3) =
      (l._1, l._2, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, R1, R2, R3)): ((L1, L2), (R1, R2, R3)) =
      ((c._1, c._2), (c._3, c._4, c._5))
    
  }
  implicit def `T2+T4`[L1, L2, R1, R2, R3, R4]: Composition.Aux[(L1, L2), (R1, R2, R3, R4), (L1, L2, R1, R2, R3, R4)] = new Composition[(L1, L2), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, R1, R2, R3, R4)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4)): (L1, L2, R1, R2, R3, R4) =
      (l._1, l._2, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4)): ((L1, L2), (R1, R2, R3, R4)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6))
    
  }
  implicit def `T2+T5`[L1, L2, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5), (L1, L2, R1, R2, R3, R4, R5)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5)): (L1, L2, R1, R2, R3, R4, R5) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5)): ((L1, L2), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T2+T6`[L1, L2, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6), (L1, L2, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6)): ((L1, L2), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T2+T7`[L1, L2, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T2+T8`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T2+T9`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T2+T10`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T2+T11`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T2+T12`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T2+T13`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T2+T14`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T2+T15`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T2+T16`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T2+T17`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T2+T18`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T2+T19`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T2+T20`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)] = new Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)] {

    override type Composed = (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)

    def compose(l: (L1, L2), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)): (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20) =
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20)
    
    def decompose(c: (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)): ((L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)) =
      ((c._1, c._2), (c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T3+T2`[L1, L2, L3, R1, R2]: Composition.Aux[(L1, L2, L3), (R1, R2), (L1, L2, L3, R1, R2)] = new Composition[(L1, L2, L3), (R1, R2)] {

    override type Composed = (L1, L2, L3, R1, R2)

    def compose(l: (L1, L2, L3), r: (R1, R2)): (L1, L2, L3, R1, R2) =
      (l._1, l._2, l._3, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, R1, R2)): ((L1, L2, L3), (R1, R2)) =
      ((c._1, c._2, c._3), (c._4, c._5))
    
  }
  implicit def `T3+T3`[L1, L2, L3, R1, R2, R3]: Composition.Aux[(L1, L2, L3), (R1, R2, R3), (L1, L2, L3, R1, R2, R3)] = new Composition[(L1, L2, L3), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, R1, R2, R3)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3)): (L1, L2, L3, R1, R2, R3) =
      (l._1, l._2, l._3, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3)): ((L1, L2, L3), (R1, R2, R3)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6))
    
  }
  implicit def `T3+T4`[L1, L2, L3, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4), (L1, L2, L3, R1, R2, R3, R4)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4)): (L1, L2, L3, R1, R2, R3, R4) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4)): ((L1, L2, L3), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7))
    
  }
  implicit def `T3+T5`[L1, L2, L3, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5), (L1, L2, L3, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5)): ((L1, L2, L3), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T3+T6`[L1, L2, L3, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T3+T7`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T3+T8`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T3+T9`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T3+T10`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T3+T11`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T3+T12`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T3+T13`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T3+T14`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T3+T15`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T3+T16`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T3+T17`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T3+T18`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T3+T19`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)] = new Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)] {

    override type Composed = (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)

    def compose(l: (L1, L2, L3), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)): (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19) =
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19)
    
    def decompose(c: (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)): ((L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)) =
      ((c._1, c._2, c._3), (c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T4+T2`[L1, L2, L3, L4, R1, R2]: Composition.Aux[(L1, L2, L3, L4), (R1, R2), (L1, L2, L3, L4, R1, R2)] = new Composition[(L1, L2, L3, L4), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, R1, R2)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2)): (L1, L2, L3, L4, R1, R2) =
      (l._1, l._2, l._3, l._4, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2)): ((L1, L2, L3, L4), (R1, R2)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6))
    
  }
  implicit def `T4+T3`[L1, L2, L3, L4, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3), (L1, L2, L3, L4, R1, R2, R3)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3)): (L1, L2, L3, L4, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3)): ((L1, L2, L3, L4), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7))
    
  }
  implicit def `T4+T4`[L1, L2, L3, L4, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4), (L1, L2, L3, L4, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4)): ((L1, L2, L3, L4), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8))
    
  }
  implicit def `T4+T5`[L1, L2, L3, L4, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T4+T6`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T4+T7`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T4+T8`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T4+T9`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T4+T10`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T4+T11`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T4+T12`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T4+T13`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T4+T14`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T4+T15`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T4+T16`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T4+T17`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T4+T18`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)] = new Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)] {

    override type Composed = (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)

    def compose(l: (L1, L2, L3, L4), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)): (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18) =
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18)
    
    def decompose(c: (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)): ((L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)) =
      ((c._1, c._2, c._3, c._4), (c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T5+T2`[L1, L2, L3, L4, L5, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2), (L1, L2, L3, L4, L5, R1, R2)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2)): (L1, L2, L3, L4, L5, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2)): ((L1, L2, L3, L4, L5), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7))
    
  }
  implicit def `T5+T3`[L1, L2, L3, L4, L5, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3), (L1, L2, L3, L4, L5, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3)): ((L1, L2, L3, L4, L5), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8))
    
  }
  implicit def `T5+T4`[L1, L2, L3, L4, L5, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9))
    
  }
  implicit def `T5+T5`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T5+T6`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T5+T7`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T5+T8`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T5+T9`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T5+T10`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T5+T11`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T5+T12`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T5+T13`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T5+T14`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T5+T15`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T5+T16`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T5+T17`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] = new Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)] {

    override type Composed = (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)

    def compose(l: (L1, L2, L3, L4, L5), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17) =
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def decompose(c: (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)): ((L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)) =
      ((c._1, c._2, c._3, c._4, c._5), (c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T6+T2`[L1, L2, L3, L4, L5, L6, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2), (L1, L2, L3, L4, L5, L6, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2)): ((L1, L2, L3, L4, L5, L6), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8))
    
  }
  implicit def `T6+T3`[L1, L2, L3, L4, L5, L6, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9))
    
  }
  implicit def `T6+T4`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10))
    
  }
  implicit def `T6+T5`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T6+T6`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T6+T7`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T6+T8`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T6+T9`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T6+T10`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T6+T11`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T6+T12`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T6+T13`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T6+T14`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T6+T15`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T6+T16`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] = new Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)

    def compose(l: (L1, L2, L3, L4, L5, L6), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)): ((L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), (c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T7+T2`[L1, L2, L3, L4, L5, L6, L7, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9))
    
  }
  implicit def `T7+T3`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10))
    
  }
  implicit def `T7+T4`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11))
    
  }
  implicit def `T7+T5`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T7+T6`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T7+T7`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T7+T8`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T7+T9`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T7+T10`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T7+T11`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T7+T12`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T7+T13`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T7+T14`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T7+T15`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] = new Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)): ((L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), (c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T8+T2`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10))
    
  }
  implicit def `T8+T3`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11))
    
  }
  implicit def `T8+T4`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12))
    
  }
  implicit def `T8+T5`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T8+T6`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T8+T7`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T8+T8`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T8+T9`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T8+T10`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T8+T11`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T8+T12`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T8+T13`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T8+T14`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)): ((L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), (c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T9+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11))
    
  }
  implicit def `T9+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12))
    
  }
  implicit def `T9+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13))
    
  }
  implicit def `T9+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T9+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T9+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T9+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T9+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T9+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T9+T11`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T9+T12`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T9+T13`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), (c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T10+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12))
    
  }
  implicit def `T10+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13))
    
  }
  implicit def `T10+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14))
    
  }
  implicit def `T10+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T10+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T10+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T10+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T10+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T10+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T10+T11`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T10+T12`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), (c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T11+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13))
    
  }
  implicit def `T11+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14))
    
  }
  implicit def `T11+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15))
    
  }
  implicit def `T11+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T11+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T11+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T11+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T11+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T11+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T11+T11`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), (c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T12+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14))
    
  }
  implicit def `T12+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15))
    
  }
  implicit def `T12+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16))
    
  }
  implicit def `T12+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T12+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T12+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T12+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T12+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T12+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), (c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T13+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15))
    
  }
  implicit def `T13+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16))
    
  }
  implicit def `T13+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16, c._17))
    
  }
  implicit def `T13+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T13+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T13+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T13+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T13+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7, R8, R9)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), r: (R1, R2, R3, R4, R5, R6, R7, R8, R9)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5, R6, R7, R8, R9)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), (c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T14+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16))
    
  }
  implicit def `T14+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16, c._17))
    
  }
  implicit def `T14+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16, c._17, c._18))
    
  }
  implicit def `T14+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T14+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T14+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T14+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6, R7, R8)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), r: (R1, R2, R3, R4, R5, R6, R7, R8)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4, R5, R6, R7, R8)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), (c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T15+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), (c._16, c._17))
    
  }
  implicit def `T15+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), (c._16, c._17, c._18))
    
  }
  implicit def `T15+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), (c._16, c._17, c._18, c._19))
    
  }
  implicit def `T15+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), (c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T15+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), (c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T15+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5, R6, R7)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), r: (R1, R2, R3, R4, R5, R6, R7)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3, R4, R5, R6, R7)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), (c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T16+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), (c._17, c._18))
    
  }
  implicit def `T16+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), (c._17, c._18, c._19))
    
  }
  implicit def `T16+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), (c._17, c._18, c._19, c._20))
    
  }
  implicit def `T16+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), (c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T16+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4, R5, R6)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), r: (R1, R2, R3, R4, R5, R6)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2, R3, R4, R5, R6)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), (c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T17+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), (c._18, c._19))
    
  }
  implicit def `T17+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), (c._18, c._19, c._20))
    
  }
  implicit def `T17+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), (c._18, c._19, c._20, c._21))
    
  }
  implicit def `T17+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3, R4, R5)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), r: (R1, R2, R3, R4, R5)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2, r._3, r._4, r._5)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17), (R1, R2, R3, R4, R5)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), (c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `T18+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), (c._19, c._20))
    
  }
  implicit def `T18+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), (c._19, c._20, c._21))
    
  }
  implicit def `T18+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2, R3, R4)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), r: (R1, R2, R3, R4)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1, r._2, r._3, r._4)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18), (R1, R2, R3, R4)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), (c._19, c._20, c._21, c._22))
    
  }
  implicit def `T19+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19), (c._20, c._21))
    
  }
  implicit def `T19+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), (R1, R2, R3)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), r: (R1, R2, R3)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1, r._2, r._3)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19), (R1, R2, R3)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19), (c._20, c._21, c._22))
    
  }
  implicit def `T20+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2)] = new Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20), (R1, R2)] {

    override type Composed = (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2)

    def compose(l: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20), r: (R1, R2)): (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r._1, r._2)
    
    def decompose(c: (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2)): ((L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20), (R1, R2)) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20), (c._21, c._22))
    
  }
  implicit def `unit+A`[A]: Composition.Aux[Unit, A, A] = new Composition[Unit, A] {

    override type Composed = A

    def compose(l: Unit, r: A): A =
      r
    
    def decompose(c: A): (Unit, A) =
      ((), c)
    
  }
  implicit def `A+unit`[A]: Composition.Aux[A, Unit, A] = new Composition[A, Unit] {

    override type Composed = A

    def compose(l: A, r: Unit): A =
      l
    
    def decompose(c: A): (A, Unit) =
      (c, ())
    
  }

}

object Composition extends Composition_Pri10 {
  type Aux[A, B, O] = Composition[A, B] { type Composed = O }

  implicit def `unit+unit`: Composition.Aux[Unit, Unit, Unit] = new Composition[Unit, Unit] {

    override type Composed = Unit

    def compose(l: Unit, r: Unit): Unit =
      ()
    
    def decompose(c: Unit): (Unit, Unit) =
      ((), ())
    
  }

}
