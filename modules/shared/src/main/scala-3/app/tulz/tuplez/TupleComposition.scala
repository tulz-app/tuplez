package app.tulz.tuplez

import scala.util.NotGiven

object TupleComposition {

  def compose[L, R](l: L, r: R)(using composition: Compose[L, R]): composition.Composed = composition.compose(l, r)
  def decompose[L, R, C](c: C)(using composition: Decompose.Aux[L, R, C]): (L, R)       = composition.decompose(c)

}

trait Compose[-L, -R] {
  type Composed
  def compose(a: L, b: R): Composed
}


trait Decompose[L, R] {
  type Composed
  def decompose(c: Composed): (L, R)
}

abstract class Composition[L, R] extends Compose[L, R], Decompose[L, R] {
  type Composed
}

object Composition {

  type Aux[A, B, O] = Composition[A, B] { type Composed = O }

  given implied[A, B, O](using c: Compose.Aux[A, B, O], d: Decompose.Aux[A, B, O]): Composition.Aux[A, B, O] =
    new Composition[A, B] {
      override type Composed = O

      def compose(l: A, r: B): O = c.compose(l, r)
      def decompose(c: O): (A, B) = d.decompose(c)
    }

}

// ---- compose givens

trait Compose_Pri0 {
  given `***`[A, B]: Compose.Aux[A, B, Tuple2[A, B]] = new Compose[A, B] {

    override type Composed = Tuple2[A, B]

    def compose(l: A, r: B): Tuple2[A, B] =
      Tuple2(l, r)

  }
}

trait Compose_Pri10 extends Compose_Pri0 {

  given `T+Scalar`[T1 <: Tuple, T2]: Compose.Aux[T1, T2, Tuple.Append[T1, T2]] = new Compose[T1, T2] {

    override type Composed = Tuple.Append[T1, T2]

    def compose(l: T1, r: T2): Tuple.Append[T1, T2] =
      l :* r

  }

  given `Scalar+T`[T1, T2 <: Tuple]: Compose.Aux[T1, T2, Tuple.Concat[Tuple1[T1], T2]] = new Compose[T1, T2] {

    override type Composed = Tuple.Concat[Tuple1[T1], T2]

    def compose(l: T1, r: T2): Tuple.Concat[Tuple1[T1], T2] =
      l *: r

  }

}

object Compose extends Compose_Pri10 {

  type Aux[A, B, O] = Compose[A, B] { type Composed = O }

  given `unit+unit`: Compose.Aux[Unit, Unit, Unit] = new Compose[Unit, Unit] {

    override type Composed = Unit

    def compose(l: Unit, r: Unit): Unit =
      ()

  }

  given `unit+A`[A]: Compose.Aux[Unit, A, A] = new Compose[Unit, A] {

    override type Composed = A

    def compose(l: Unit, r: A): A =
      r

  }

  given `A+unit`[A]: Compose.Aux[A, Unit, A] = new Compose[A, Unit] {

    override type Composed = A

    def compose(l: A, r: Unit): A =
      l

  }

  given `T+T`[T1 <: Tuple, T2 <: Tuple]: Compose.Aux[T1, T2, Tuple.Concat[T1, T2]] = new Compose[T1, T2] {

    override type Composed = Tuple.Concat[T1, T2]

    def compose(l: T1, r: T2): Tuple.Concat[T1, T2] =
      l ++ r

  }

}

// ---- decompose givens

trait Decompose_Pri0 {
  given `***`[A, B]: Decompose.Aux[A, B, Tuple2[A, B]] = new Decompose[A, B] {

    override type Composed = Tuple2[A, B]

    def decompose(c: Tuple2[A, B]): (A, B) =
      c

  }
}

trait Decompose_Pri10 extends Decompose_Pri0 {


  given `T+Scalar`[T1 <: Tuple, T2](using NotGiven[T2 <:< Tuple]): Decompose.Aux[T1, T2, Tuple.Append[T1, T2]] = new Decompose[T1, T2] {

    override type Composed = Tuple.Append[T1, T2]

    def decompose(c: Tuple.Append[T1, T2]): (T1, T2) = {
      val left = c.init.asInstanceOf[T1]
      val right = c.last.asInstanceOf[T2] // c.drop(size1).productElement(0).asInstanceOf[T2] // Get the single element
      (left, right)
    }

  }

  given `Scalar+T`[T1, T2 <: Tuple](using NotGiven[T1 <:< Tuple]): Decompose.Aux[T1, T2, Tuple.Concat[Tuple1[T1], T2]] = new Decompose[T1, T2] {

    override type Composed = Tuple.Concat[Tuple1[T1], T2]

    def decompose(c: Tuple.Concat[Tuple1[T1], T2]): (T1, T2) = {
      val left = c.head
      val right = c.tail
      (left, right)
    }

  }

  given `T+T`[T1 <: Tuple, T2 <: Tuple](using ValueOf[Tuple.Size[T1]]): Decompose.Aux[T1, T2, Tuple.Concat[T1, T2]] = new Decompose[T1, T2] {

    override type Composed = Tuple.Concat[T1, T2]

    def decompose(c: Tuple.Concat[T1, T2]): (T1, T2) = {
      val size1 = valueOf[Tuple.Size[T1]]
      val (left, right) = c.splitAt(size1)
      (left.asInstanceOf[T1], right.asInstanceOf[T2])
    }

  }

}

object Decompose extends Decompose_Pri10 {

  type Aux[A, B, O] = Decompose[A, B] { type Composed = O }

  given `unit+unit`: Decompose.Aux[Unit, Unit, Unit] = new Decompose[Unit, Unit] {

    override type Composed = Unit

    def decompose(c: Unit): (Unit, Unit) =
      ((), ())

  }

  given `unit+A`[A]: Decompose.Aux[Unit, A, A] = new Decompose[Unit, A] {

    override type Composed = A

    def decompose(c: A): (Unit, A) =
      ((), c)

  }

  given `A+unit`[A]: Decompose.Aux[A, Unit, A] = new Decompose[A, Unit] {

    override type Composed = A

    def decompose(c: A): (A, Unit) =
      (c, ())

  }

}
