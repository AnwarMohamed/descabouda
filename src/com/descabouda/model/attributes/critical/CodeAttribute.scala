package com.descabouda.model.attributes.critical

import java.util

import com.descabouda.model.{BaseAttribute, OutputAttribute}

class CodeAttribute extends OutputAttribute {
  name = "Code"

  var maxStack: Integer = null
  var maxLocals: Integer = null

  var codeLength: Integer = null
  var code: Array[Byte] = null

  var exceptionTableLength: Integer = null
  var exceptionTable = new util.ArrayList[ExceptionTable]()

  var attributesCount: Integer = null
  var attributeInfo = new util.ArrayList[OutputAttribute]()
}

class ExceptionTable {
  var startPc: Integer = null
  var endPc: Integer = null
  var handlerPc: Integer = null
  var catchType: Integer = null
}
