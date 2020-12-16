![Maven Central](https://img.shields.io/maven-central/v/app.tulz/tuplez_sjs1_2.13.svg)

### app.tulz.tuplez

A tiny library for tuple composition.

```scala
"app.tulz" %%% "tuplez" % "0.1.0" 
```

### Tuple marker traits

* `app.tulz.tuplez.Tuple[T]` -- instances exist for `Tuple1` .. `Tuple22` (a utility, not actually used by this library)

* `app.tulz.tuplez.NonTuple[T]` -- conflicting instances exist for `Tuple1` .. `Tuple22` (used to disambiguate tuples from scalars in composition implicits)


### Composition

`app.tulz.tuplez.TupleComposition`

```scala
abstract class Composition[-A, -B] {
  type Composed
  val apply: (A, B) => Composed
}
```

Implicit values are provided for composing tuples with tuples, and tuples with scalars (both prepending and appending). 

Implicits are defined by the generated code.

### TupleComposition

`app.tulz.tuplez.TupleComposition`

Provides a single utility function to compose two tuples (or a tuple and a scalar)

```scala
object TupleComposition {

  def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)

}

```

Example:

```scala
import app.tulz.tuplez.TupleComposition

TupleComposition.compose( (1), (2) ) // (1, 2)
TupleComposition.compose( (1, 2, 3, 4), (5, 6) ) // (1, 2, 3, 4, 5, 6)
TupleComposition.compose( (1, 2, 3), 4 ) // (1, 2, 3, 4)
TupleComposition.compose( 1,  (2, 3, 4) ) // (1, 2, 3, 4)
TupleComposition.compose( (1, 2, 3), () ) // (1, 2, 3)
TupleComposition.compose( (),  (1, 2, 3) ) // (1, 2, 3)
```

### Intended usage

Simple example:

```scala
import app.tulz.tuplez._

case class MyStructure[T](
  data: T
) {

  def appendScalar[U: NonTuple](value: U)(implicit composition: Composition[T, U]): MyStructure[composition.Composed] = 
    copy(data = composition.compose(data, value)) // or 
  // copy(data = TupleComposition.compose(data, value))

}
```
