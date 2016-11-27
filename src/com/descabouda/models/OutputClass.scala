package com.descabouda.models

import java.util

class OutputClass {
  val fields = new util.LinkedList[OutputField]()
  val methods = new util.LinkedList[OutputMethod]()
  val interfaces = new util.LinkedList[String]()
  var attributes = Map[String, OutputAttribute]()

  var publicFlag: Boolean = false
  var finalFlag: Boolean = false
  var interfaceFlag: Boolean = false
  var superFlag: Boolean = false
  var abstractFlag: Boolean = false
  var syntheticFlag: Boolean = false
  var annotationFlag: Boolean = false
  var enumFlag: Boolean = false

  var name: String = null
  var superName: String = null
  var raw: BaseClass = null
}
