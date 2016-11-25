package com.descabouda.model

import java.util

class BaseClass {
  val constants = new util.LinkedList[BaseConstant]()
  val interfaces = new util.LinkedList[BaseInterface]()
  val fields = new util.LinkedList[BaseField]()
  val methods = new util.LinkedList[BaseMethod]()
  val attributes = new util.LinkedList[BaseAttribute]()

  var minor_version: Short = -1
  var major_version: Short = -1
}
