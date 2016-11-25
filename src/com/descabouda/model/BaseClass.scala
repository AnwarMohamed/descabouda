package com.descabouda.model

import java.util

class BaseClass {
  var minorVersion: Integer = null
  var majorVersion: Integer = null
  var accessFlags: Integer = null
  var thisClass: Integer = null
  var superClass: Integer = null

  val constants = new util.LinkedList[BaseConstant]()
  val interfaces = new util.LinkedList[BaseInterface]()
  val fields = new util.LinkedList[BaseField]()
  val methods = new util.LinkedList[BaseMethod]()
  val attributes = new util.LinkedList[BaseAttribute]()
}
