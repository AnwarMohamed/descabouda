package com.descabouda.model

import java.util

class BaseMethod {
  var accessFlags: Integer = null
  var nameIndex: Integer = null
  var descriptorIndex: Integer = null
  var attributesCount: Integer = null

  val attributes = new util.LinkedList[BaseAttribute]()
}
