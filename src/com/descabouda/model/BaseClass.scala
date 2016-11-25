package com.descabouda.model

import java.util

class BaseClass {
  var minor_version: Integer = null
  var major_version: Integer = null
  var access_flags: Integer = null
  var this_class: Integer = null
  var super_class: Integer = null

  val constants = new util.LinkedList[BaseConstant]()
  val interfaces = new util.LinkedList[BaseInterface]()
  val fields = new util.LinkedList[BaseField]()
  val methods = new util.LinkedList[BaseMethod]()
  val attributes = new util.LinkedList[BaseAttribute]()
}
