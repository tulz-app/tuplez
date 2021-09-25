package app.tulz.tuplez

object TupleComposition {

  def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)

}

abstract class Composition[-A, -B] {
  type Composed
  val compose: (A, B) => Composed
}

trait Composition_Pri0 {
  implicit def ***[A, B]: Composition.Aux[A, B, (A, B)] = Composition[A, B, (A, B)]((_, _))
}

trait Composition_Pri5 extends Composition_Pri0 {
  implicit def `T1+R`[L, R]: Composition.Aux[Tuple1[L], R, (L, R)] = Composition[Tuple1[L], R, (L, R)]((l, r) => (l._1, r))
  implicit def `L+T1`[L, R]: Composition.Aux[L, Tuple1[R], (L, R)] = Composition[L, Tuple1[R], (L, R)]((l, r) => (l, r._1))
}

trait Composition_Pri7 extends Composition_Pri5 {

  implicit def `T2+scalar`[T1, T2, R]: Composition.Aux[(T1, T2), R, (T1, T2, R)] =
    Composition[(T1, T2), R, (T1, T2, R)]((l, r) => (l._1, l._2, r))

  implicit def `scalar+T2`[L, T1, T2]: Composition.Aux[L, (T1, T2), (L, T1, T2)] =
    Composition[L, (T1, T2), (L, T1, T2)]((l, r) => (l, r._1, r._2))

  implicit def `T3+scalar`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), R, (T1, T2, T3, R)] =
    Composition[(T1, T2, T3), R, (T1, T2, T3, R)]((l, r) => (l._1, l._2, l._3, r))

  implicit def `scalar+T3`[L, T1, T2, T3]: Composition.Aux[L, (T1, T2, T3), (L, T1, T2, T3)] =
    Composition[L, (T1, T2, T3), (L, T1, T2, T3)]((l, r) => (l, r._1, r._2, r._3))

  implicit def `T4+scalar`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)] =
    Composition[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)]((l, r) => (l._1, l._2, l._3, l._4, r))

  implicit def `scalar+T4`[L, T1, T2, T3, T4]: Composition.Aux[L, (T1, T2, T3, T4), (L, T1, T2, T3, T4)] =
    Composition[L, (T1, T2, T3, T4), (L, T1, T2, T3, T4)]((l, r) => (l, r._1, r._2, r._3, r._4))

  implicit def `T5+scalar`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)] =
    Composition[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r))

  implicit def `scalar+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[L, (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] =
    Composition[L, (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)]((l, r) => (l, r._1, r._2, r._3, r._4, r._5))

  implicit def `T6+scalar`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)] =
    Composition[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r))

  implicit def `scalar+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] =
    Composition[L, (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T7+scalar`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r))

  implicit def `scalar+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T8+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r))

  implicit def `scalar+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8))

  implicit def `T9+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r))

  implicit def `scalar+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9))

  implicit def `T10+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r)
    )

  implicit def `scalar+T10`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T11+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r)
    )

  implicit def `scalar+T11`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T12+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r)
    )

  implicit def `scalar+T12`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T13+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r)
    )

  implicit def `scalar+T13`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    )

  implicit def `T14+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r)
    )

  implicit def `scalar+T14`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    )

  implicit def `T15+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r)
    )

  implicit def `scalar+T15`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    )

  implicit def `T16+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r)
    )

  implicit def `scalar+T16`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]
    : Composition.Aux[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)]((l, r) =>
      (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    )

  implicit def `T17+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r)
    )

  implicit def `scalar+T17`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]
    : Composition.Aux[L,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)
    ] =
    Composition[L, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)](
      (l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17)
    )

  implicit def `T18+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r))

  implicit def `scalar+T18`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]
    : Composition.Aux[L,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)
    ] =
    Composition[L,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)
    ]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18))

  implicit def `T19+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r))

  implicit def `scalar+T19`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]
    : Composition.Aux[L,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)
    ] =
    Composition[L,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)
    ]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19))

  implicit def `T20+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r))

  implicit def `scalar+T20`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]
    : Composition.Aux[L,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)
    ] =
    Composition[L,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)
    ]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20))

  implicit def `T21+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r))

  implicit def `scalar+T21`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]
    : Composition.Aux[L,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)
    ] =
    Composition[L,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)
    ]((l, r) => (l, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20, r._21))

}

trait Composition_Pri10 extends Composition_Pri7 {

  implicit def `T1+T1`[L, R]: Composition.Aux[Tuple1[L], Tuple1[R], (L, R)] = Composition[Tuple1[L], Tuple1[R], (L, R)]((l, r) => (l._1, r._1))

  implicit def `T2+T1`[T1, T2, R]: Composition.Aux[(T1, T2), Tuple1[R], (T1, T2, R)] =
    Composition[(T1, T2), Tuple1[R], (T1, T2, R)]((l, r) => (l._1, l._2, r._1))

  implicit def `T1+T2`[L, T1, T2]: Composition.Aux[Tuple1[L], (T1, T2), (L, T1, T2)] =
    Composition[Tuple1[L], (T1, T2), (L, T1, T2)]((l, r) => (l._1, r._1, r._2))

  implicit def `T3+T1`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), Tuple1[R], (T1, T2, T3, R)] =
    Composition[(T1, T2, T3), Tuple1[R], (T1, T2, T3, R)]((l, r) => (l._1, l._2, l._3, r._1))

  implicit def `T1+T3`[L, T1, T2, T3]: Composition.Aux[Tuple1[L], (T1, T2, T3), (L, T1, T2, T3)] =
    Composition[Tuple1[L], (T1, T2, T3), (L, T1, T2, T3)]((l, r) => (l._1, r._1, r._2, r._3))

  implicit def `T4+T1`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), Tuple1[R], (T1, T2, T3, T4, R)] =
    Composition[(T1, T2, T3, T4), Tuple1[R], (T1, T2, T3, T4, R)]((l, r) => (l._1, l._2, l._3, l._4, r._1))

  implicit def `T1+T4`[L, T1, T2, T3, T4]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4), (L, T1, T2, T3, T4)] =
    Composition[Tuple1[L], (T1, T2, T3, T4), (L, T1, T2, T3, T4)]((l, r) => (l._1, r._1, r._2, r._3, r._4))

  implicit def `T5+T1`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), Tuple1[R], (T1, T2, T3, T4, T5, R)] =
    Composition[(T1, T2, T3, T4, T5), Tuple1[R], (T1, T2, T3, T4, T5, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1))

  implicit def `T1+T5`[L, T1, T2, T3, T4, T5]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5), (L, T1, T2, T3, T4, T5)]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5))

  implicit def `T6+T1`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), Tuple1[R], (T1, T2, T3, T4, T5, T6, R)] =
    Composition[(T1, T2, T3, T4, T5, T6), Tuple1[R], (T1, T2, T3, T4, T5, T6, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1))

  implicit def `T1+T6`[L, T1, T2, T3, T4, T5, T6]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6), (L, T1, T2, T3, T4, T5, T6)]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T7+T1`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1))

  implicit def `T1+T7`[L, T1, T2, T3, T4, T5, T6, T7]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7), (L, T1, T2, T3, T4, T5, T6, T7)]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T8+T1`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1))

  implicit def `T1+T8`[L, T1, T2, T3, T4, T5, T6, T7, T8]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8), (L, T1, T2, T3, T4, T5, T6, T7, T8)]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8))

  implicit def `T9+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1))

  implicit def `T1+T9`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9]: Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9)]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9))

  implicit def `T10+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1)
    )

  implicit def `T1+T10`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]
    : Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)]((l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T11+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1)
    )

  implicit def `T1+T11`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]
    : Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)]((l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T12+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1)
    )

  implicit def `T1+T12`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]
    : Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)]((l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T13+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1)
    )

  implicit def `T1+T13`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]
    : Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)]((l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    )

  implicit def `T14+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1)
    )

  implicit def `T1+T14`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]
    : Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)]((l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    )

  implicit def `T15+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1)
    )

  implicit def `T1+T15`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]
    : Composition.Aux[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)]((l, r) =>
      (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    )

  implicit def `T16+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16),
                      Tuple1[R],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), Tuple1[R], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1)
    )

  implicit def `T1+T16`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]
    : Composition.Aux[Tuple1[L],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)
    ] =
    Composition[Tuple1[L], (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)](
      (l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    )

  implicit def `T17+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                      Tuple1[R],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                Tuple1[R],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1))

  implicit def `T1+T17`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]
    : Composition.Aux[Tuple1[L],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)
    ] =
    Composition[Tuple1[L],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)
    ]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17))

  implicit def `T18+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                      Tuple1[R],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                Tuple1[R],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1))

  implicit def `T1+T18`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]
    : Composition.Aux[Tuple1[L],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)
    ] =
    Composition[Tuple1[L],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)
    ]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18))

  implicit def `T19+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                      Tuple1[R],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                Tuple1[R],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1))

  implicit def `T1+T19`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]
    : Composition.Aux[Tuple1[L],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)
    ] =
    Composition[Tuple1[L],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)
    ]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19))

  implicit def `T20+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                      Tuple1[R],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                Tuple1[R],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r._1))

  implicit def `T1+T20`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]
    : Composition.Aux[Tuple1[L],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)
    ] =
    Composition[Tuple1[L],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)
    ]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20))

  implicit def `T21+T1`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                      Tuple1[R],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                Tuple1[R],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r._1))

  implicit def `T1+T21`[L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]
    : Composition.Aux[Tuple1[L],
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                      (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)
    ] =
    Composition[Tuple1[L],
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                (L, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)
    ]((l, r) => (l._1, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20, r._21))

  implicit def `T2+T2`[L1, L2, R1, R2]: Composition.Aux[(L1, L2), (R1, R2), (L1, L2, R1, R2)] =
    Composition[(L1, L2), (R1, R2), (L1, L2, R1, R2)]((l, r) => (l._1, l._2, r._1, r._2))

  implicit def `T2+T3`[L1, L2, R1, R2, R3]: Composition.Aux[(L1, L2), (R1, R2, R3), (L1, L2, R1, R2, R3)] =
    Composition[(L1, L2), (R1, R2, R3), (L1, L2, R1, R2, R3)]((l, r) => (l._1, l._2, r._1, r._2, r._3))

  implicit def `T2+T4`[L1, L2, R1, R2, R3, R4]: Composition.Aux[(L1, L2), (R1, R2, R3, R4), (L1, L2, R1, R2, R3, R4)] =
    Composition[(L1, L2), (R1, R2, R3, R4), (L1, L2, R1, R2, R3, R4)]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4))

  implicit def `T2+T5`[L1, L2, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5), (L1, L2, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5), (L1, L2, R1, R2, R3, R4, R5)]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5))

  implicit def `T2+T6`[L1, L2, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6), (L1, L2, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6), (L1, L2, R1, R2, R3, R4, R5, R6)]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T2+T7`[L1, L2, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, R1, R2, R3, R4, R5, R6, R7)]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T2+T8`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8))

  implicit def `T2+T9`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9]: Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T2+T10`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T2+T11`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T2+T12`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T2+T13`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    )

  implicit def `T2+T14`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    )

  implicit def `T2+T15`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]
    : Composition.Aux[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)]((l, r) =>
      (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    )

  implicit def `T2+T16`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]
    : Composition.Aux[(L1, L2),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                      (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ] =
    Composition[(L1, L2), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16), (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)](
      (l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16)
    )

  implicit def `T2+T17`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]
    : Composition.Aux[(L1, L2),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                      (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ] =
    Composition[(L1, L2),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17))

  implicit def `T2+T18`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]
    : Composition.Aux[(L1, L2),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18),
                      (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)
    ] =
    Composition[(L1, L2),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18),
                (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)
    ]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18))

  implicit def `T2+T19`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]
    : Composition.Aux[(L1, L2),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19),
                      (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)
    ] =
    Composition[(L1, L2),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19),
                (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)
    ]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19))

  implicit def `T2+T20`[L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20]
    : Composition.Aux[(L1, L2),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20),
                      (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)
    ] =
    Composition[(L1, L2),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20),
                (L1, L2, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20)
    ]((l, r) => (l._1, l._2, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19, r._20))

  implicit def `T3+T2`[L1, L2, L3, R1, R2]: Composition.Aux[(L1, L2, L3), (R1, R2), (L1, L2, L3, R1, R2)] =
    Composition[(L1, L2, L3), (R1, R2), (L1, L2, L3, R1, R2)]((l, r) => (l._1, l._2, l._3, r._1, r._2))

  implicit def `T3+T3`[L1, L2, L3, R1, R2, R3]: Composition.Aux[(L1, L2, L3), (R1, R2, R3), (L1, L2, L3, R1, R2, R3)] =
    Composition[(L1, L2, L3), (R1, R2, R3), (L1, L2, L3, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3))

  implicit def `T3+T4`[L1, L2, L3, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4), (L1, L2, L3, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4), (L1, L2, L3, R1, R2, R3, R4)]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4))

  implicit def `T3+T5`[L1, L2, L3, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5), (L1, L2, L3, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5), (L1, L2, L3, R1, R2, R3, R4, R5)]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5))

  implicit def `T3+T6`[L1, L2, L3, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, R1, R2, R3, R4, R5, R6)]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T3+T7`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7)]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T3+T8`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8]: Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T3+T9`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T3+T10`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T3+T11`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T3+T12`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T3+T13`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    )

  implicit def `T3+T14`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)]((l, r) =>
      (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    )

  implicit def `T3+T15`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]
    : Composition.Aux[(L1, L2, L3),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                      (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ] =
    Composition[(L1, L2, L3), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15), (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)](
      (l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15)
    )

  implicit def `T3+T16`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]
    : Composition.Aux[(L1, L2, L3),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                      (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ] =
    Composition[(L1, L2, L3),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16))

  implicit def `T3+T17`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]
    : Composition.Aux[(L1, L2, L3),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                      (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ] =
    Composition[(L1, L2, L3),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17))

  implicit def `T3+T18`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]
    : Composition.Aux[(L1, L2, L3),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18),
                      (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)
    ] =
    Composition[(L1, L2, L3),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18),
                (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)
    ]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18))

  implicit def `T3+T19`[L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19]
    : Composition.Aux[(L1, L2, L3),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19),
                      (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)
    ] =
    Composition[(L1, L2, L3),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19),
                (L1, L2, L3, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19)
    ]((l, r) => (l._1, l._2, l._3, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18, r._19))

  implicit def `T4+T2`[L1, L2, L3, L4, R1, R2]: Composition.Aux[(L1, L2, L3, L4), (R1, R2), (L1, L2, L3, L4, R1, R2)] =
    Composition[(L1, L2, L3, L4), (R1, R2), (L1, L2, L3, L4, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2))

  implicit def `T4+T3`[L1, L2, L3, L4, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3), (L1, L2, L3, L4, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3), (L1, L2, L3, L4, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3))

  implicit def `T4+T4`[L1, L2, L3, L4, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4), (L1, L2, L3, L4, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4), (L1, L2, L3, L4, R1, R2, R3, R4)]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4))

  implicit def `T4+T5`[L1, L2, L3, L4, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, R1, R2, R3, R4, R5)]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5))

  implicit def `T4+T6`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6)]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T4+T7`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7]: Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T4+T8`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T4+T9`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T4+T10`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T4+T11`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T4+T12`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T4+T13`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)]((l, r) =>
      (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    )

  implicit def `T4+T14`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2, L3, L4),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                      (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ] =
    Composition[(L1, L2, L3, L4), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14), (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)](
      (l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14)
    )

  implicit def `T4+T15`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]
    : Composition.Aux[(L1, L2, L3, L4),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                      (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ] =
    Composition[(L1, L2, L3, L4),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15))

  implicit def `T4+T16`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]
    : Composition.Aux[(L1, L2, L3, L4),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                      (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ] =
    Composition[(L1, L2, L3, L4),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16))

  implicit def `T4+T17`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]
    : Composition.Aux[(L1, L2, L3, L4),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                      (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ] =
    Composition[(L1, L2, L3, L4),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17))

  implicit def `T4+T18`[L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18]
    : Composition.Aux[(L1, L2, L3, L4),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18),
                      (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)
    ] =
    Composition[(L1, L2, L3, L4),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18),
                (L1, L2, L3, L4, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18)
    ]((l, r) => (l._1, l._2, l._3, l._4, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17, r._18))

  implicit def `T5+T2`[L1, L2, L3, L4, L5, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2), (L1, L2, L3, L4, L5, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2), (L1, L2, L3, L4, L5, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2))

  implicit def `T5+T3`[L1, L2, L3, L4, L5, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3), (L1, L2, L3, L4, L5, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3), (L1, L2, L3, L4, L5, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3))

  implicit def `T5+T4`[L1, L2, L3, L4, L5, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, R1, R2, R3, R4)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4))

  implicit def `T5+T5`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5))

  implicit def `T5+T6`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T5+T7`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T5+T8`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T5+T9`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T5+T10`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T5+T11`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T5+T12`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T5+T13`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3, L4, L5),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                      (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13)
    )

  implicit def `T5+T14`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2, L3, L4, L5),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                      (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ] =
    Composition[(L1, L2, L3, L4, L5),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14))

  implicit def `T5+T15`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]
    : Composition.Aux[(L1, L2, L3, L4, L5),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                      (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ] =
    Composition[(L1, L2, L3, L4, L5),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15))

  implicit def `T5+T16`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]
    : Composition.Aux[(L1, L2, L3, L4, L5),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                      (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ] =
    Composition[(L1, L2, L3, L4, L5),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16))

  implicit def `T5+T17`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17]
    : Composition.Aux[(L1, L2, L3, L4, L5),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                      (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ] =
    Composition[(L1, L2, L3, L4, L5),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17),
                (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16, r._17))

  implicit def `T6+T2`[L1, L2, L3, L4, L5, L6, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2), (L1, L2, L3, L4, L5, L6, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2), (L1, L2, L3, L4, L5, L6, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2))

  implicit def `T6+T3`[L1, L2, L3, L4, L5, L6, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3))

  implicit def `T6+T4`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4))

  implicit def `T6+T5`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T6+T6`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T6+T7`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T6+T8`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T6+T9`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T6+T10`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T6+T11`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T6+T12`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T6+T13`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                      (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13))

  implicit def `T6+T14`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                      (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14))

  implicit def `T6+T15`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                      (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15))

  implicit def `T6+T16`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                      (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16),
                (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15, r._16))

  implicit def `T7+T2`[L1, L2, L3, L4, L5, L6, L7, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2))

  implicit def `T7+T3`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3))

  implicit def `T7+T4`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4)
    )

  implicit def `T7+T5`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T7+T6`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T7+T7`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T7+T8`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T7+T9`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T7+T10`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T7+T11`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T7+T12`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                      (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12)
    )

  implicit def `T7+T13`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                      (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13))

  implicit def `T7+T14`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                      (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14))

  implicit def `T7+T15`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                      (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15),
                (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14, r._15))

  implicit def `T8+T2`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2))

  implicit def `T8+T3`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3)
    )

  implicit def `T8+T4`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4)
    )

  implicit def `T8+T5`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T8+T6`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T8+T7`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T8+T8`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T8+T9`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T8+T10`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T8+T11`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                      (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11)
    )

  implicit def `T8+T12`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                      (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12))

  implicit def `T8+T13`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                      (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13))

  implicit def `T8+T14`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                      (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14),
                (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13, r._14))

  implicit def `T9+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2)
    )

  implicit def `T9+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3)
    )

  implicit def `T9+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4)
    )

  implicit def `T9+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T9+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T9+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T9+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T9+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T9+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9), (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10), (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10)
    )

  implicit def `T9+T11`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11))

  implicit def `T9+T12`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12))

  implicit def `T9+T13`[L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12, r._13))

  implicit def `T10+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2)
    )

  implicit def `T10+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3)
    )

  implicit def `T10+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4)
    )

  implicit def `T10+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T10+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T10+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T10+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T10+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10), (R1, R2, R3, R4, R5, R6, R7, R8, R9), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9)
    )

  implicit def `T10+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10))

  implicit def `T10+T11`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11))

  implicit def `T10+T12`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11, r._12))

  implicit def `T11+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2)
    )

  implicit def `T11+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3)
    )

  implicit def `T11+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4)
    )

  implicit def `T11+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T11+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T11+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T11+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                      (R1, R2, R3, R4, R5, R6, R7, R8),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11), (R1, R2, R3, R4, R5, R6, R7, R8), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8)
    )

  implicit def `T11+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9))

  implicit def `T11+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10))

  implicit def `T11+T11`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10, r._11))

  implicit def `T12+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2)
    )

  implicit def `T12+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3)
    )

  implicit def `T12+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4)
    )

  implicit def `T12+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T12+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6)
    )

  implicit def `T12+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                      (R1, R2, R3, R4, R5, R6, R7),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12), (R1, R2, R3, R4, R5, R6, R7), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7)
    )

  implicit def `T12+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                      (R1, R2, R3, R4, R5, R6, R7, R8),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                (R1, R2, R3, R4, R5, R6, R7, R8),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8))

  implicit def `T12+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9))

  implicit def `T12+T10`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9, R10),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9, r._10))

  implicit def `T13+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2)
    )

  implicit def `T13+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3)
    )

  implicit def `T13+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4)
    )

  implicit def `T13+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                      (R1, R2, R3, R4, R5),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5)
    )

  implicit def `T13+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                      (R1, R2, R3, R4, R5, R6),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                (R1, R2, R3, R4, R5, R6),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T13+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                      (R1, R2, R3, R4, R5, R6, R7),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                (R1, R2, R3, R4, R5, R6, R7),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T13+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                      (R1, R2, R3, R4, R5, R6, R7, R8),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                (R1, R2, R3, R4, R5, R6, R7, R8),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8))

  implicit def `T13+T9`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                      (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13),
                (R1, R2, R3, R4, R5, R6, R7, R8, R9),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, R1, R2, R3, R4, R5, R6, R7, R8, R9)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8, r._9))

  implicit def `T14+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2)
    )

  implicit def `T14+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3)
    )

  implicit def `T14+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                      (R1, R2, R3, R4),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4)
    )

  implicit def `T14+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                      (R1, R2, R3, R4, R5),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                (R1, R2, R3, R4, R5),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5))

  implicit def `T14+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                      (R1, R2, R3, R4, R5, R6),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                (R1, R2, R3, R4, R5, R6),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T14+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                      (R1, R2, R3, R4, R5, R6, R7),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                (R1, R2, R3, R4, R5, R6, R7),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T14+T8`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                      (R1, R2, R3, R4, R5, R6, R7, R8),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14),
                (R1, R2, R3, R4, R5, R6, R7, R8),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, R1, R2, R3, R4, R5, R6, R7, R8)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r._1, r._2, r._3, r._4, r._5, r._6, r._7, r._8))

  implicit def `T15+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2)
    )

  implicit def `T15+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                      (R1, R2, R3),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3)
    )

  implicit def `T15+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                      (R1, R2, R3, R4),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                (R1, R2, R3, R4),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4))

  implicit def `T15+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                      (R1, R2, R3, R4, R5),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                (R1, R2, R3, R4, R5),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4, r._5))

  implicit def `T15+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                      (R1, R2, R3, R4, R5, R6),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                (R1, R2, R3, R4, R5, R6),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T15+T7`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                      (R1, R2, R3, R4, R5, R6, R7),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15),
                (R1, R2, R3, R4, R5, R6, R7),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, R1, R2, R3, R4, R5, R6, R7)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r._1, r._2, r._3, r._4, r._5, r._6, r._7))

  implicit def `T16+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                      (R1, R2),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2)
    )

  implicit def `T16+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                      (R1, R2, R3),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                (R1, R2, R3),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3))

  implicit def `T16+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                      (R1, R2, R3, R4),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                (R1, R2, R3, R4),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3, r._4))

  implicit def `T16+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                      (R1, R2, R3, R4, R5),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                (R1, R2, R3, R4, R5),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3, r._4, r._5))

  implicit def `T16+T6`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                      (R1, R2, R3, R4, R5, R6),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16),
                (R1, R2, R3, R4, R5, R6),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, R1, R2, R3, R4, R5, R6)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r._1, r._2, r._3, r._4, r._5, r._6))

  implicit def `T17+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                      (R1, R2),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                (R1, R2),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2))

  implicit def `T17+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                      (R1, R2, R3),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                (R1, R2, R3),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2, r._3))

  implicit def `T17+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                      (R1, R2, R3, R4),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                (R1, R2, R3, R4),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2, r._3, r._4))

  implicit def `T17+T5`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                      (R1, R2, R3, R4, R5),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17),
                (R1, R2, R3, R4, R5),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, R1, R2, R3, R4, R5)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r._1, r._2, r._3, r._4, r._5))

  implicit def `T18+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18),
                      (R1, R2),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18),
                (R1, R2),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1, r._2))

  implicit def `T18+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18),
                      (R1, R2, R3),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18),
                (R1, R2, R3),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1, r._2, r._3))

  implicit def `T18+T4`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18),
                      (R1, R2, R3, R4),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18),
                (R1, R2, R3, R4),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, R1, R2, R3, R4)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, r._1, r._2, r._3, r._4))

  implicit def `T19+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19),
                      (R1, R2),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19),
                (R1, R2),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1, r._2))

  implicit def `T19+T3`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19),
                      (R1, R2, R3),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19),
                (R1, R2, R3),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, R1, R2, R3)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r._1, r._2, r._3))

  implicit def `T20+T2`[L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2]
    : Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20),
                      (R1, R2),
                      (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2)
    ] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20),
                (R1, R2),
                (L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, R1, R2)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r._1, r._2))

  implicit def `unit+A`[A]: Composition.Aux[Unit, A, A] = Composition[Unit, A, A]((_, a) => a)
  implicit def `A+unit`[A]: Composition.Aux[A, Unit, A] = Composition[A, Unit, A]((a, _) => a)

}

object Composition extends Composition_Pri10 {
  implicit def `unit+unit`: Composition.Aux[Unit, Unit, Unit] = Composition[Unit, Unit, Unit]((_, _) => ())
  type Aux[A, B, O] = Composition[A, B] { type Composed = O }

  def apply[A, B, O](c: (A, B) => O): Aux[A, B, O] =
    new Composition[A, B] {
      override type Composed = O
      val compose: (A, B) => O = c
    }

}
