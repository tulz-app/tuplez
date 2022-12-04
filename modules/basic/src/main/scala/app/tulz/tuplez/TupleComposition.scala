package app.tulz.tuplez

object TupleComposition {

  def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)
  def unapply[L, R, C](c: C)(implicit composition: Composition.Aux[L, R, C]): (L, R)           = composition.unapply(c)

}

abstract class Composition[L, R] {
  type Composed
  def compose(a: L, b: R): Composed
  def unapply(c: Composed): (L, R)
}

trait Composition_Pri0 {
  implicit def `***`[A, B]: Composition.Aux[A, B, Tuple2[A, B]] = new Composition[A, B] {

    override type Composed = Tuple2[A, B]

    def compose(l: A, r: B): Tuple2[A, B] =
      Tuple2(l, r)
    
    def unapply(c: Tuple2[A, B]): (A, B) =
      c
    
  }
}

trait Composition_Pri5 extends Composition_Pri0{
  implicit def `T1+R`[L, R]: Composition.Aux[Tuple1[L], R, Tuple2[L, R]] = new Composition[Tuple1[L], R] {

    override type Composed = Tuple2[L, R]

    def compose(l: Tuple1[L], r: R): Tuple2[L, R] =
      Tuple2(l._1, r)
    
    def unapply(c: Tuple2[L, R]): (Tuple1[L], R) =
      Tuple2(Tuple1(c._1), c._2)
    
  }
  implicit def `L+T1`[L, R]: Composition.Aux[L, Tuple1[R], Tuple2[L, R]] = new Composition[L, Tuple1[R]] {

    override type Composed = Tuple2[L, R]

    def compose(l: L, r: Tuple1[R]): Tuple2[L, R] =
      Tuple2(l, r._1)
    
    def unapply(c: Tuple2[L, R]): (L, Tuple1[R]) =
      Tuple2(c._1, Tuple1(c._2))
    
  }
}

trait Composition_Pri7 extends Composition_Pri5 {

  implicit def `T2+scalar`[T1, T2, R]: Composition.Aux[(T1, T2), R, (T1, T2, R)] = new Composition[(T1, T2), R] {

    override type Composed = (T1, T2, R)

    def compose(l: (T1, T2), r: R): (T1, T2, R) =
      (l._1, l._2, r)
    
    def unapply(c: (T1, T2, R)): ((T1, T2), R) =
      ((c._1, c._2), c._3)
    
  }
  implicit def `T3+scalar`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), R, (T1, T2, T3, R)] = new Composition[(T1, T2, T3), R] {

    override type Composed = (T1, T2, T3, R)

    def compose(l: (T1, T2, T3), r: R): (T1, T2, T3, R) =
      (l._1, l._2, l._3, r)
    
    def unapply(c: (T1, T2, T3, R)): ((T1, T2, T3), R) =
      ((c._1, c._2, c._3), c._4)
    
  }
  implicit def `T4+scalar`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)] = new Composition[(T1, T2, T3, T4), R] {

    override type Composed = (T1, T2, T3, T4, R)

    def compose(l: (T1, T2, T3, T4), r: R): (T1, T2, T3, T4, R) =
      (l._1, l._2, l._3, l._4, r)
    
    def unapply(c: (T1, T2, T3, T4, R)): ((T1, T2, T3, T4), R) =
      ((c._1, c._2, c._3, c._4), c._5)
    
  }
  implicit def `T5+scalar`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)] = new Composition[(T1, T2, T3, T4, T5), R] {

    override type Composed = (T1, T2, T3, T4, T5, R)

    def compose(l: (T1, T2, T3, T4, T5), r: R): (T1, T2, T3, T4, T5, R) =
      (l._1, l._2, l._3, l._4, l._5, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, R)): ((T1, T2, T3, T4, T5), R) =
      ((c._1, c._2, c._3, c._4, c._5), c._6)
    
  }
  implicit def `T6+scalar`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)] = new Composition[(T1, T2, T3, T4, T5, T6), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, R)

    def compose(l: (T1, T2, T3, T4, T5, T6), r: R): (T1, T2, T3, T4, T5, T6, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, R)): ((T1, T2, T3, T4, T5, T6), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), c._7)
    
  }
  implicit def `T7+scalar`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7), r: R): (T1, T2, T3, T4, T5, T6, T7, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, R)): ((T1, T2, T3, T4, T5, T6, T7), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), c._8)
    
  }
  implicit def `T8+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, R)): ((T1, T2, T3, T4, T5, T6, T7, T8), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), c._9)
    
  }
  implicit def `T9+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), c._10)
    
  }
  implicit def `T10+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), c._11)
    
  }
  implicit def `T11+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), c._12)
    
  }
  implicit def `T12+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), c._13)
    
  }
  implicit def `T13+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), c._14)
    
  }
  implicit def `T14+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), c._15)
    
  }
  implicit def `T15+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), c._16)
    
  }
  implicit def `T16+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), c._17)
    
  }
  implicit def `T17+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), c._18)
    
  }
  implicit def `T18+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), c._19)
    
  }
  implicit def `T19+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19), c._20)
    
  }
  implicit def `T20+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20), c._21)
    
  }
  implicit def `T21+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), r: R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21), c._22)
    
  }
}

trait Composition_Pri10 extends Composition_Pri7 {

  implicit def `T1+T1`[L, R]: Composition.Aux[Tuple1[L], Tuple1[R], Tuple2[L, R]] = new Composition[Tuple1[L], Tuple1[R]] {

    override type Composed = Tuple2[L, R]

    def compose(l: Tuple1[L], r: Tuple1[R]): Tuple2[L, R] =
      (l._1, r._1)
    
    def unapply(c: Tuple2[L, R]): (Tuple1[L], Tuple1[R]) =
      (Tuple1(c._1), Tuple1(c._2))
    
  }

  implicit def `T2+T1`[T1, T2, R]: Composition.Aux[(T1, T2), Tuple1[R], (T1, T2, R)] = new Composition[(T1, T2), Tuple1[R]] {

    override type Composed = (T1, T2, R)

    def compose(l: (T1, T2), r: Tuple1[R]): (T1, T2, R) =
      (l._1, l._2, r._1)
    
    def unapply(c: (T1, T2, R)): ((T1, T2), Tuple1[R]) =
      ((c._1, c._2), Tuple1(c._3))
    
  }
  implicit def `T1+T2`[L, T1, T2]: Composition.Aux[Tuple1[L], (T1, T2), (L, T1, T2)] = new Composition[Tuple1[L], (T1, T2)] {

    override type Composed = (L, T1, T2)

    def compose(l: Tuple1[L], r: (T1, T2)): (L, T1, T2) =
      (l._1, r._1, r._2)
    
    def unapply(c: (L, T1, T2)): (Tuple1[L], (T1, T2)) =
      (Tuple1(c._1), (c._2, c._3))
    
  }
  implicit def `T3+T1`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), Tuple1[R], (T1, T2, T3, R)] = new Composition[(T1, T2, T3), Tuple1[R]] {

    override type Composed = (T1, T2, T3, R)

    def compose(l: (T1, T2, T3), r: Tuple1[R]): (T1, T2, T3, R) =
      (l._1, l._2, l._3, r._1)
    
    def unapply(c: (T1, T2, T3, R)): ((T1, T2, T3), Tuple1[R]) =
      ((c._1, c._2, c._3), Tuple1(c._4))
    
  }
  implicit def `T1+T3`[L, T1, T2, T3]: Composition.Aux[Tuple1[L], (T1, T2, T3), (L, T1, T2, T3)] = new Composition[Tuple1[L], (T1, T2, T3)] {

    override type Composed = (L, T1, T2, T3)

    def compose(l: Tuple1[L], r: (T1, T2, T3)): (L, T1, T2, T3) =
      (l._1, r._1, r._2, r._3)
    
    def unapply(c: (L, T1, T2, T3)): (Tuple1[L], (T1, T2, T3)) =
      (Tuple1(c._1), (c._2, c._3, c._4))
    
  }
  implicit def `T4+T1`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), Tuple1[R], (T1, T2, T3, T4, R)] = new Composition[(T1, T2, T3, T4), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, R)

    def compose(l: (T1, T2, T3, T4), r: Tuple1[R]): (T1, T2, T3, T4, R) =
      (l._1, l._2, l._3, l._4, r._1)
    
    def unapply(c: (T1, T2, T3, T4, R)): ((T1, T2, T3, T4), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4), Tuple1(c._5))
    
  }
  implicit def `T1+T4`[L, T1, T2, T3, T4]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4), (L, T1, T2, T3, T4)] = new Composition[Tuple1[L], (T1, T2, T3, T4)] {

    override type Composed = (L, T1, T2, T3, T4)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4)): (L, T1, T2, T3, T4) =
      (l._1, r._1, r._2, r._3, r._4)
    
    def unapply(c: (L, T1, T2, T3, T4)): (Tuple1[L], (T1, T2, T3, T4)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5))
    
  }
  implicit def `T5+T1`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), Tuple1[R], (T1, T2, T3, T4, T5, R)] = new Composition[(T1, T2, T3, T4, T5), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, R)

    def compose(l: (T1, T2, T3, T4, T5), r: Tuple1[R]): (T1, T2, T3, T4, T5, R) =
      (l._1, l._2, l._3, l._4, l._5, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, R)): ((T1, T2, T3, T4, T5), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5), Tuple1(c._6))
    
  }
  implicit def `T1+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5)] {

    override type Composed = (L, T1, T2, T3, T4, T5)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5)): (L, T1, T2, T3, T4, T5) =
      (l._1, r._1, r._2, r._3, r._4, r._5)
    
    def unapply(c: (L, T1, T2, T3, T4, T5)): (Tuple1[L], (T1, T2, T3, T4, T5)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6))
    
  }
  implicit def `T6+T1`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), Tuple1[R], (T1, T2, T3, T4, T5, T6, R)] = new Composition[(T1, T2, T3, T4, T5, T6), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, R)

    def compose(l: (T1, T2, T3, T4, T5, T6), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, R)): ((T1, T2, T3, T4, T5, T6), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6), Tuple1(c._7))
    
  }
  implicit def `T1+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6)): (L, T1, T2, T3, T4, T5, T6) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6)): (Tuple1[L], (T1, T2, T3, T4, T5, T6)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7))
    
  }
  implicit def `T7+T1`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, R)): ((T1, T2, T3, T4, T5, T6, T7), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7), Tuple1(c._8))
    
  }
  implicit def `T1+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7)): (L, T1, T2, T3, T4, T5, T6, T7) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8))
    
  }
  implicit def `T8+T1`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, R)): ((T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8), Tuple1(c._9))
    
  }
  implicit def `T1+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8)): (L, T1, T2, T3, T4, T5, T6, T7, T8) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9))
    
  }
  implicit def `T9+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9), Tuple1(c._10))
    
  }
  implicit def `T1+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10))
    
  }
  implicit def `T10+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10), Tuple1(c._11))
    
  }
  implicit def `T1+T10`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11))
    
  }
  implicit def `T11+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11), Tuple1(c._12))
    
  }
  implicit def `T1+T11`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12))
    
  }
  implicit def `T12+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12), Tuple1(c._13))
    
  }
  implicit def `T1+T12`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13))
    
  }
  implicit def `T13+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13), Tuple1(c._14))
    
  }
  implicit def `T1+T13`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14))
    
  }
  implicit def `T14+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14), Tuple1(c._15))
    
  }
  implicit def `T1+T14`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15))
    
  }
  implicit def `T15+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15), Tuple1(c._16))
    
  }
  implicit def `T1+T15`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16))
    
  }
  implicit def `T16+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16), Tuple1(c._17))
    
  }
  implicit def `T1+T16`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17))
    
  }
  implicit def `T17+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17), Tuple1(c._18))
    
  }
  implicit def `T1+T17`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18))
    
  }
  implicit def `T18+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18), Tuple1(c._19))
    
  }
  implicit def `T1+T18`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19))
    
  }
  implicit def `T19+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19), Tuple1(c._20))
    
  }
  implicit def `T1+T19`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20))
    
  }
  implicit def `T20+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20), Tuple1(c._21))
    
  }
  implicit def `T1+T20`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21))
    
  }
  implicit def `T21+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)] = new Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[R]] {

    override type Composed = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)

    def compose(l: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), r: Tuple1[R]): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R) =
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r._1)
    
    def unapply(c: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), Tuple1[R]) =
      ((c._1, c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21), Tuple1(c._22))
    
  }
  implicit def `T1+T21`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] = new Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] {

    override type Composed = (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)

    def compose(l: Tuple1[L], r: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) =
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20, r._21)
    
    def unapply(c: (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): (Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)) =
      (Tuple1(c._1), (c._2, c._3, c._4, c._5, c._6, c._7, c._8, c._9, c._10, c._11, c._12, c._13, c._14, c._15, c._16, c._17, c._18, c._19, c._20, c._21, c._22))
    
  }
  implicit def `unit+A`[A]: Composition.Aux[Unit, A, A] = new Composition[Unit, A] {

    override type Composed = A

    def compose(l: Unit, r: A): A =
      r
    
    def unapply(c: A): (Unit, A) =
      ((), c)
    
  }
  implicit def `A+unit`[A]: Composition.Aux[A, Unit, A] = new Composition[A, Unit] {

    override type Composed = A

    def compose(l: A, r: Unit): A =
      l
    
    def unapply(c: A): (A, Unit) =
      (c, ())
    
  }

}

object Composition extends Composition_Pri10 {
  type Aux[A, B, O] = Composition[A, B] { type Composed = O }

  implicit def `unit+unit`: Composition.Aux[Unit, Unit, Unit] = new Composition[Unit, Unit] {

    override type Composed = Unit

    def compose(l: Unit, r: Unit): Unit =
      ()
    
    def unapply(c: Unit): (Unit, Unit) =
      ((), ())
    
  }

}
