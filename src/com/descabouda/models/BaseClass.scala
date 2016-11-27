package com.descabouda.models

import java.util

import com.descabouda.models.constants.{ClassConstant, Utf8Constant}

class BaseClass {
  var minorVersion: Int = 0
  var majorVersion: Int = 0
  var accessFlags: Int = 0
  var thisClass: Int = 0
  var superClass: Int = 0

  val constants = new util.ArrayList[BaseConstant]()
  val interfaces = new util.ArrayList[BaseInterface]()
  val fields = new util.ArrayList[BaseField]()
  val methods = new util.ArrayList[BaseMethod]()
  val attributes = new util.ArrayList[BaseAttribute]()

  def getConstant(index: Int): BaseConstant = {
    if (index > 0 && index < constants.size())
      constants.get(index)
    null
  }

  def getClass(index: Int): ClassConstant = {
    constants.get(index).asInstanceOf[ClassConstant]
  }

  def getClassName(index: Int): String = {
    getUtf8(getClass(index).nameIndex - 1)
  }

  def getUtf8(index: Int): String = {
    new String(constants.get(index).asInstanceOf[Utf8Constant].bytes)
  }
}
