package com.descabouda.output

import java.io.OutputStream

import com.descabouda.models.{OutputClass, OutputMethod}
import com.descabouda.models.attributes.SourceFileAttribute
import com.descabouda.models.attributes.critical.RuntimeVisibleAnnotationsAttribute
import com.descabouda.models.constants._

class JavaPrinter(input: OutputClass) {
  val inputClass: OutputClass = input

  def printClassHeader(): Unit = {
    if (inputClass.publicFlag)
      print("public ")

    if (inputClass.interfaceFlag)
      print("interface ")
    else
      print("class ")

    print(inputClass.name.replaceAll("/", "."))
  }

  def printMethods(): Unit =
    inputClass.methods.forEach((method) => printMethod(method))

  def printMethod(method: OutputMethod): Unit = {
    printMethodHeader(method)
  }

  def printMethodHeader(method: OutputMethod): Unit = {
    print(" " * 2)

    if (method.publicFlag)
      print("public ")
    else if (method.privateFlag)
      print("private ")
    else if (method.protectedFlag)
      print("protected ")

    if (method.abstractFlag)
      print("abstract ")

    println(method.name + " " + method.descriptor)
  }

  def printClass(): Unit = {
    printClassHeader()

    println(" {")
    println("}")
  }
}
