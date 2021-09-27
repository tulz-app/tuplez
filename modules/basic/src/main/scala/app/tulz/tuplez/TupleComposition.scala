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

  implicit def `T3+scalar`[T1, T2, T3, R]: Composition.Aux[(T1, T2, T3), R, (T1, T2, T3, R)] =
    Composition[(T1, T2, T3), R, (T1, T2, T3, R)]((l, r) => (l._1, l._2, l._3, r))

  implicit def `T4+scalar`[T1, T2, T3, T4, R]: Composition.Aux[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)] =
    Composition[(T1, T2, T3, T4), R, (T1, T2, T3, T4, R)]((l, r) => (l._1, l._2, l._3, l._4, r))

  implicit def `T5+scalar`[T1, T2, T3, T4, T5, R]: Composition.Aux[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)] =
    Composition[(T1, T2, T3, T4, T5), R, (T1, T2, T3, T4, T5, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r))

  implicit def `T6+scalar`[T1, T2, T3, T4, T5, T6, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)] =
    Composition[(T1, T2, T3, T4, T5, T6), R, (T1, T2, T3, T4, T5, T6, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r))

  implicit def `T7+scalar`[T1, T2, T3, T4, T5, T6, T7, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7), R, (T1, T2, T3, T4, T5, T6, T7, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r))

  implicit def `T8+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8), R, (T1, T2, T3, T4, T5, T6, T7, T8, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r))

  implicit def `T9+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]: Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, R)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, r))

  implicit def `T10+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, r)
    )

  implicit def `T11+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, r)
    )

  implicit def `T12+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, r)
    )

  implicit def `T13+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, r)
    )

  implicit def `T14+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, r)
    )

  implicit def `T15+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, r)
    )

  implicit def `T16+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R)]((l, r) =>
      (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, r)
    )

  implicit def `T17+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R)](
      (l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, r)
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

  implicit def `T19+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, r))

  implicit def `T20+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, r))

  implicit def `T21+scalar`[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]
    : Composition.Aux[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                      R,
                      (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)
    ] =
    Composition[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21),
                R,
                (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R)
    ]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, l._9, l._10, l._11, l._12, l._13, l._14, l._15, l._16, l._17, l._18, l._19, l._20, l._21, r))

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
