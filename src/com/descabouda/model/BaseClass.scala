package com.descabouda.model

import java.util

import com.descabouda.model.constants.{ClassConstant, Utf8Constant}

class BaseClass {
  var minorVersion: Integer = null
  var majorVersion: Integer = null
  var accessFlags: Integer = null
  var thisClass: Integer = null
  var superClass: Integer = null

  val constants = new util.ArrayList[BaseConstant]()
  val interfaces = new util.ArrayList[BaseInterface]()
  val fields = new util.ArrayList[BaseField]()
  val methods = new util.ArrayList[BaseMethod]()
  val attributes = new util.ArrayList[BaseAttribute]()

  def getConstant(index: Integer): BaseConstant = {
    if (index > 0 && index < constants.size()) {
      constants.get(index)
    }

    null
  }

  def getClass(index: Integer): ClassConstant = {
    constants.get(index).asInstanceOf[ClassConstant]
  }

  def getClassName(index: Integer): String = {
    getUtf8(getClass(index).nameIndex - 1)
  }

  def getUtf8(index: Integer): String = {
    new String(constants.get(index).asInstanceOf[Utf8Constant].bytes)
  }
}
