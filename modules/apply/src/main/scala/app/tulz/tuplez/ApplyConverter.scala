package app.tulz.tuplez

abstract class ApplyConverter[L, O] {
  type In
  def apply(f: In): L => O
}

trait ApplyConverters[O] extends ApplyConverterInstances[O]
