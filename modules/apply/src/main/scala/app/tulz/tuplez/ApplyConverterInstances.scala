package app.tulz.tuplez

trait ApplyConverterInstancesPriLow[O] {
  implicit def singleParam[T1]: ApplyConverter[T1, O] { type In = (T1) => O } = new ApplyConverter[T1, O] {
    type In = T1 => O
    def apply(fn: T1 => O): T1 => O = fn
  }
}

trait ApplyConverterInstances[O] extends ApplyConverterInstancesPriLow[O] {
  implicit def toTupled1[T1]: ApplyConverter[Tuple1[T1], O] { type In = (T1) => O } = new ApplyConverter[Tuple1[T1], O] {
    type In = (T1) => O
    def apply(fn: (T1) => O): (Tuple1[T1]) => O = t => fn(t._1)
  }
  implicit def toTupled2[T1, T2]: ApplyConverter[Tuple2[T1, T2], O] { type In = (T1, T2) => O } = new ApplyConverter[Tuple2[T1, T2], O] {
    type In = (T1, T2) => O
    def apply(fn: (T1, T2) => O): (Tuple2[T1, T2]) => O = fn.tupled
  }
  implicit def toTupled3[T1, T2, T3]: ApplyConverter[Tuple3[T1, T2, T3], O] { type In = (T1, T2, T3) => O } = new ApplyConverter[Tuple3[T1, T2, T3], O] {
    type In = (T1, T2, T3) => O
    def apply(fn: (T1, T2, T3) => O): (Tuple3[T1, T2, T3]) => O = fn.tupled
  }
  implicit def toTupled4[T1, T2, T3, T4]: ApplyConverter[Tuple4[T1, T2, T3, T4], O] { type In = (T1, T2, T3, T4) => O } = new ApplyConverter[Tuple4[T1, T2, T3, T4], O] {
    type In = (T1, T2, T3, T4) => O
    def apply(fn: (T1, T2, T3, T4) => O): (Tuple4[T1, T2, T3, T4]) => O = fn.tupled
  }
  implicit def toTupled5[T1, T2, T3, T4, T5]: ApplyConverter[Tuple5[T1, T2, T3, T4, T5], O] { type In = (T1, T2, T3, T4, T5) => O } = new ApplyConverter[Tuple5[T1, T2, T3, T4, T5], O] {
    type In = (T1, T2, T3, T4, T5) => O
    def apply(fn: (T1, T2, T3, T4, T5) => O): (Tuple5[T1, T2, T3, T4, T5]) => O = fn.tupled
  }
  implicit def toTupled6[T1, T2, T3, T4, T5, T6]: ApplyConverter[Tuple6[T1, T2, T3, T4, T5, T6], O] { type In = (T1, T2, T3, T4, T5, T6) => O } = new ApplyConverter[Tuple6[T1, T2, T3, T4, T5, T6], O] {
    type In = (T1, T2, T3, T4, T5, T6) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6) => O): (Tuple6[T1, T2, T3, T4, T5, T6]) => O = fn.tupled
  }
  implicit def toTupled7[T1, T2, T3, T4, T5, T6, T7]: ApplyConverter[Tuple7[T1, T2, T3, T4, T5, T6, T7], O] { type In = (T1, T2, T3, T4, T5, T6, T7) => O } = new ApplyConverter[Tuple7[T1, T2, T3, T4, T5, T6, T7], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7) => O): (Tuple7[T1, T2, T3, T4, T5, T6, T7]) => O = fn.tupled
  }
  implicit def toTupled8[T1, T2, T3, T4, T5, T6, T7, T8]: ApplyConverter[Tuple8[T1, T2, T3, T4, T5, T6, T7, T8], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8) => O } = new ApplyConverter[Tuple8[T1, T2, T3, T4, T5, T6, T7, T8], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8) => O): (Tuple8[T1, T2, T3, T4, T5, T6, T7, T8]) => O = fn.tupled
  }
  implicit def toTupled9[T1, T2, T3, T4, T5, T6, T7, T8, T9]: ApplyConverter[Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9) => O } = new ApplyConverter[Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => O): (Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9]) => O = fn.tupled
  }
  implicit def toTupled10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: ApplyConverter[Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => O } = new ApplyConverter[Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => O): (Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]) => O = fn.tupled
  }
  implicit def toTupled11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: ApplyConverter[Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => O } = new ApplyConverter[Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => O): (Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]) => O = fn.tupled
  }
  implicit def toTupled12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: ApplyConverter[Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => O } = new ApplyConverter[Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => O): (Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]) => O = fn.tupled
  }
  implicit def toTupled13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: ApplyConverter[Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => O } = new ApplyConverter[Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => O): (Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]) => O = fn.tupled
  }
  implicit def toTupled14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: ApplyConverter[Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => O } = new ApplyConverter[Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => O): (Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]) => O = fn.tupled
  }
  implicit def toTupled15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: ApplyConverter[Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => O } = new ApplyConverter[Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => O): (Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]) => O = fn.tupled
  }
  implicit def toTupled16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: ApplyConverter[Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => O } = new ApplyConverter[Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => O): (Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]) => O = fn.tupled
  }
  implicit def toTupled17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: ApplyConverter[Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => O } = new ApplyConverter[Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => O): (Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]) => O = fn.tupled
  }
  implicit def toTupled18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: ApplyConverter[Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => O } = new ApplyConverter[Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => O): (Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]) => O = fn.tupled
  }
  implicit def toTupled19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: ApplyConverter[Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => O } = new ApplyConverter[Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => O): (Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]) => O = fn.tupled
  }
  implicit def toTupled20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: ApplyConverter[Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => O } = new ApplyConverter[Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => O): (Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]) => O = fn.tupled
  }
  implicit def toTupled21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: ApplyConverter[Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => O } = new ApplyConverter[Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => O): (Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]) => O = fn.tupled
  }
  implicit def toTupled22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]: ApplyConverter[Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], O] { type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => O } = new ApplyConverter[Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], O] {
    type In = (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => O
    def apply(fn: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => O): (Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]) => O = fn.tupled
  }
}
