import sbt._

import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream

abstract class SourceGenerator(file: File) {

  file.getParentFile.mkdirs()
  private val printStream = new PrintStream(new FileOutputStream(file))
  private var indent      = ""

  protected def enter(s: String = "")(leave: String = "")(body: => Unit): Unit = {
    println(s)
    indent = indent + "  "
    body
    indent = indent.substring(0, indent.length - 2)
    println(leave)
  }

  protected def println(s: String): Unit = {
    printStream.print(indent)
    printStream.println(s)
  }

  protected def println(): Unit = {
    printStream.println()
  }

  protected def done(): Unit = {
    printStream.close()
  }

  protected def tupleTypeRaw(size: Int, prefix: String = "T"): Seq[String] =
    (1 to size).map(i => s"${prefix}${i}")

  protected def tupleType(size: Int, prefix: String = "T"): String =
    tupleTypeRaw(size, prefix).mkString(", ")

  protected def tupleAccessRaw(size: Int, varName: String): Seq[String] =
    (1 to size).map(i => s"${varName}._${i}")

  protected def tupleAccessRaw(from: Int, toIndex: Int, varName: String): Seq[String] =
    (from to toIndex).map(i => s"${varName}._${i}")

  protected def tupleAccess(size: Int, varName: String): String =
    tupleAccessRaw(size, varName).mkString(", ")

  protected def tupleAccess(from: Int, to: Int, varName: String): String =
    tupleAccessRaw(from, to, varName).mkString(", ")

  final def generate(): Seq[File] = {
    doGenerate()
    Seq(file)
  }

  protected def doGenerate(): Unit

}
