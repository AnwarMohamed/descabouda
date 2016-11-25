package com.descabouda.model

import java.util

class BaseClass {
  var minor_version: Short = null
  var major_version: Short = null
  var access_flags: Short = null
  var this_class: Short = null
  var super_class: Short = null

  val constants = new util.LinkedList[BaseConstant]()
  val interfaces = new util.LinkedList[BaseInterface]()
  val fields = new util.LinkedList[BaseField]()
  val methods = new util.LinkedList[BaseMethod]()
  val attributes = new util.LinkedList[BaseAttribute]()
}
