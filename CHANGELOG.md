# Changelog

## 0.3.3

Publishing for Scala 3.0.0-M3 and 3.0.0-RC1(nightly).

## 0.3.1

#### `ApplyConverter`

Refactoring + `ApplyConverterInstancesPriLow` with an "identity" transformation for unary functions (with a scalar param).

#### `tuplez-*`

No changes.

#### `tuplez-tuple`

No longer exists.

## 0.3.0

Now publishing multiple interchangeable modules:

#### `tuplez-full`
tupleN + scalar, scalar + tupleN, tupleN + tupleM, up to `Tuple22`

#### `tuplez-full-light`
tupleN + scalar, scalar + tupleN, tupleN + tupleM, up to `Tuple10`

#### `tuplez-basic`
tupleN + scalar, up to `Tuple22`

#### `tuplez-basic-light`
tupleN + scalar, up to `Tuple10`

## 0.2.0

`tuplez-apply` – utilities to build API's that allow using a `FunctionN[A, B, C, ... Out]` instead of `Function1[TupleN[A, B, C, ...], Out]`  

## 0.1.0

* initial release
