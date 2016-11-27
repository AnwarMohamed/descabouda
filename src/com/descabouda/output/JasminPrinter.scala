package com.descabouda.output

import com.descabouda.models.{OutputClass, OutputMethod}
import com.descabouda.models.attributes.SourceFileAttribute
import com.descabouda.models.attributes.critical.RuntimeVisibleAnnotationsAttribute
import com.descabouda.models.constants._

class JasminPrinter(input: OutputClass) {
  val inputClass: OutputClass = input

  def printClassHeader(): Unit = {
    if (inputClass.publicFlag)
      print("public ")

    if (inputClass.interfaceFlag)
      print("interface ")
    else
      print("class ")

    println(inputClass.name.replaceAll("/", "."))
  }

  def printClassMeta(): Unit = {
    if (inputClass.attributes.contains("SourceFile")) {
      val attribute = inputClass.attributes.get("SourceFile")
        .get.asInstanceOf[SourceFileAttribute]

      println("  SourceFile: \"" + attribute.string + "\"")
    }

    if (inputClass.attributes.contains("RuntimeVisibleAnnotations")) {
      val attribute = inputClass.attributes.get("RuntimeVisibleAnnotations")
        .get.asInstanceOf[RuntimeVisibleAnnotationsAttribute]

      println("  RuntimeVisibleAnnotations:")
    }

    println("  minor version: " + inputClass.raw.minorVersion)
    println("  major version: " + inputClass.raw.majorVersion)
    println("  flags: ")
  }

  def printConstantPool(): Unit = {
    println("Constant pool:")

    var constantCounter = 1
    var indexColumn: String = null
    var titleColumn: String = null
    var descColumn: String = null

    inputClass.raw.constants.forEach((constant) => {
      indexColumn = "#" + constantCounter.toString

      constant match {
        case _: ClassConstant =>
          val polyConstant = constant.asInstanceOf[ClassConstant]

          titleColumn = "Class"
          descColumn = "#" + polyConstant.nameIndex + ";"
          descColumn += " " * (14 - descColumn.length)
          descColumn += "//  " + polyConstant.nameString

        case _: Utf8Constant =>
          titleColumn = "Utf8"
          descColumn = constant.asInstanceOf[Utf8Constant].string + ";"

        case _: NameAndTypeConstant =>
          val polyConstant = constant.asInstanceOf[NameAndTypeConstant]

          titleColumn = "NameAndType"
          descColumn = "#" + polyConstant.nameIndex + ":#" + polyConstant.descriptorIndex + ";"
          descColumn += " " * (14 - descColumn.length)
          descColumn += "//  " + polyConstant.nameString + ":" + polyConstant.descriptorString

        case _: FieldRefConstant =>
          val polyConstant = constant.asInstanceOf[FieldRefConstant]

          titleColumn = "FieldRef"
          descColumn = "#" + polyConstant.classIndex + ".#" + polyConstant.nameAndTypeIndex + ";"
          descColumn += " " * (14 - descColumn.length)
          descColumn += "//  " + polyConstant.classString + "." + polyConstant.nameString
          descColumn += ":" + polyConstant.typeString

        case _: MethodRefConstant =>
          val polyConstant = constant.asInstanceOf[MethodRefConstant]

          titleColumn = "MethodRef"
          descColumn = "#" + polyConstant.classIndex + ".#" + polyConstant.nameAndTypeIndex + ";"
          descColumn += " " * (14 - descColumn.length)
          descColumn += "//  " + polyConstant.classString + "." + polyConstant.nameString
          descColumn += ":" + polyConstant.typeString

        case _ => titleColumn = ""
      }

      print(" " * (6 - indexColumn.length))
      print(indexColumn + " = " + titleColumn)
      print(" " * (20 - titleColumn.length))
      println(descColumn)

      constantCounter += 1
    })
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
    printClassMeta()

//    printConstantPool()

//    println("{")
//    printMethods()
//    println("}")
  }
}
