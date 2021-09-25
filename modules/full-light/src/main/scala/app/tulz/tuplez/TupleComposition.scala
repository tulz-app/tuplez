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

  implicit def `T5+T2`[L1, L2, L3, L4, L5, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2), (L1, L2, L3, L4, L5, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2), (L1, L2, L3, L4, L5, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2))

  implicit def `T5+T3`[L1, L2, L3, L4, L5, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3), (L1, L2, L3, L4, L5, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3), (L1, L2, L3, L4, L5, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3))

  implicit def `T5+T4`[L1, L2, L3, L4, L5, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, R1, R2, R3, R4)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4))

  implicit def `T5+T5`[L1, L2, L3, L4, L5, R1, R2, R3, R4, R5]: Composition.Aux[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)] =
    Composition[(L1, L2, L3, L4, L5), (R1, R2, R3, R4, R5), (L1, L2, L3, L4, L5, R1, R2, R3, R4, R5)]((l, r) => (l._1, l._2, l._3, l._4, l._5, r._1, r._2, r._3, r._4, r._5))

  implicit def `T6+T2`[L1, L2, L3, L4, L5, L6, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2), (L1, L2, L3, L4, L5, L6, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2), (L1, L2, L3, L4, L5, L6, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2))

  implicit def `T6+T3`[L1, L2, L3, L4, L5, L6, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3))

  implicit def `T6+T4`[L1, L2, L3, L4, L5, L6, R1, R2, R3, R4]: Composition.Aux[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)] =
    Composition[(L1, L2, L3, L4, L5, L6), (R1, R2, R3, R4), (L1, L2, L3, L4, L5, L6, R1, R2, R3, R4)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, r._1, r._2, r._3, r._4))

  implicit def `T7+T2`[L1, L2, L3, L4, L5, L6, L7, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2))

  implicit def `T7+T3`[L1, L2, L3, L4, L5, L6, L7, R1, R2, R3]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7), (R1, R2, R3), (L1, L2, L3, L4, L5, L6, L7, R1, R2, R3)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, r._1, r._2, r._3))

  implicit def `T8+T2`[L1, L2, L3, L4, L5, L6, L7, L8, R1, R2]: Composition.Aux[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)] =
    Composition[(L1, L2, L3, L4, L5, L6, L7, L8), (R1, R2), (L1, L2, L3, L4, L5, L6, L7, L8, R1, R2)]((l, r) => (l._1, l._2, l._3, l._4, l._5, l._6, l._7, l._8, r._1, r._2))

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
