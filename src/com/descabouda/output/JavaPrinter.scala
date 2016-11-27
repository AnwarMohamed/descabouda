package com.descabouda.output

import com.descabouda.models.attributes.critical.CodeAttribute
import com.descabouda.models.{OutputClass, OutputField, OutputMethod}

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
    println(" {")

    if (method.attributes.contains("Code")) {
      val codeAttribute = method.attributes("Code").asInstanceOf[CodeAttribute]

      codeAttribute.code.forEach((code) => {
        print(" " * 4)
        print(code.mnemonicString)
        print(" ")
        println(code.operandsString)
      })
    }

    println(" " * 2 + "}")
    println()
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

    if (method.finalFlag)
      print("final ")

    if (method.staticFlag)
      print("static ")

    print(method.returnType + " " + method.name)

    print("(")
    print(method.parametersType.toArray.mkString(", "))
    print(")")
  }

  def printFields(): Unit =
    inputClass.fields.forEach((field) => printField(field))

  def printField(field: OutputField): Unit = {
    print(" " * 2)

    if (field.publicFlag)
      print("public ")
    else if (field.privateFlag)
      print("private ")
    else if (field.protectedFlag)
      print("protected ")

    if (field.finalFlag)
      print("final ")

    if (field.staticFlag)
      print("static ")

    println(field.returnType + " " + field.name + ";")
  }

  def printClass(): Unit = {
    printClassHeader()
    println(" {")
    printFields()
    println()
    printMethods()
    println("}")
  }
}
