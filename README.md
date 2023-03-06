![Maven Central](https://img.shields.io/maven-central/v/app.tulz/tuplez-full_sjs1_2.13?versionPrefix=0.4)

### tuplez

Tuple composition in Scala and Scala.js.

```scala
// tupleN + scalar, scalar + tupleN, tupleN + tupleM, up to Tuple22
"app.tulz" %%% "tuplez-full" % "0.4.0"

// or

// tupleN + scalar, scalar + tupleN, tupleN + tupleM, up to Tuple10
"app.tulz" %%% "tuplez-full-light" % "0.4.0"

// or

// tupleN + scalar, up to Tuple22
"app.tulz" %%% "tuplez-basic" % "0.4.0"

// or

// tupleN + scalar, up to Tuple10 
"app.tulz" %%% "tuplez-basic-light" % "0.4.0" 
```

```scala
// utilities to build API's that allow using a FunctionN[A, B, C, ... Out] instead of Function1[TupleN[A, B, C, ...], Out] 
"app.tulz" %%% "tuplez-apply" % "0.4.0"
```

Published for Scala `2.12`, `2.13` and `3.2.1`, JVM and Scala.js 1.5.1+.

### Source code

Source code is 100% generated. 

## Composition

`app.tulz.tuplez.TupleComposition`

```scala
abstract class Composition[L, R] {
  type Composed
  val compose: (L, R) => Composed
  def decompose(c: Composed): (L, R)
}
```

Implicit values are provided for composing tuples with tuples, and tuples with scalars (both prepending and appending). 

Implicits are defined by the generated code.

The companion object provides utility functions to compose/decompose two tuples (or a tuple and a scalar)

```scala
object TupleComposition {

  def compose[L, R](l: L, r: R)(implicit composition: Composition[L, R]): composition.Composed = composition.compose(l, r)
  def decompose[L, R, C](c: C)(implicit composition: Composition.Aux[L, R, C]): (L, R)         = composition.decompose(c)

}

```

Examples:

```scala
import app.tulz.tuplez.TupleComposition

TupleComposition.compose( Tuple1(1), Tuple1(2) ) // (1, 2)
TupleComposition.compose( 1, 2 ) // (1, 2)
TupleComposition.compose( (1, 2, 3, 4), (5, 6) ) // (1, 2, 3, 4, 5, 6)
TupleComposition.compose( (1, 2, 3), 4 ) // (1, 2, 3, 4)
TupleComposition.compose( 1,  (2, 3, 4) ) // (1, 2, 3, 4)
TupleComposition.compose( (1, 2, 3), Tuple1(4) ) // (1, 2, 3, 4)
TupleComposition.compose( Tuple1(1),  (2, 3, 4) ) // (1, 2, 3, 4)
TupleComposition.compose( (1, 2, 3), () ) // (1, 2, 3)
TupleComposition.compose( (),  (1, 2, 3) ) // (1, 2, 3)
// etc
```

## Apply converters

`app.tulz.tuplez.ApplyConverter`

Utilities for converting `FunctionN[..., Out]` into `Function1[TupleN[...], Out]`

Example:

```scala
import app.tulz.tuplez._

object instances extends ApplyConverters[String] 
// in order to make type and implicits resolution possible, the apply converters are generated for a fixed output type
import instances._

val acceptingTupledFunc: ((Int, Int, Int, Int) => String) => String = func => func((1, 2, 3, 4))
val nonTupledFunction = (x1: Int, x2: Int, x3: Int, x4: Int) => s"I return [${x1}, ${x2}, ${x3}, ${x4}]"
assert(acceptingTupledFunc(toTupled4(nonTupledFunction)) == "I return [1, 2, 3, 4]")
```

## Intended usage

Simple example:

```scala
import app.tulz.tuplez._

case class MyStructure[T](
  data: T
) {

  def appendScalar[U](value: U)(implicit composition: Composition[T, U]): MyStructure[composition.Composed] = 
    copy(data = composition.compose(data, value)) 
 // or 
 // copy(data = TupleComposition.compose(data, value))

}
```

A more complete example: https://github.com/tulz-app/frontroute/blob/main/src/main/scala/io/frontroute/DirectiveApplyConverters.scala


## Author

Iurii Malchenko – [@yurique](https://twitter.com/yurique) / [keybase.io/yurique](https://keybase.io/yurique)


## License

`tuplez` is provided under the [MIT license](https://github.com/tulz-app/tuplez/blob/main/LICENSE.md).
