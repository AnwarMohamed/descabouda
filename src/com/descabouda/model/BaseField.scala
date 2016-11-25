package com.descabouda.model

import java.util

class BaseField {
  var accessFlags: Int = 0
  var nameIndex: Int = 0
  var descriptorIndex: Int = 0
  var attributesCount: Int = 0

  val attributes = new util.LinkedList[BaseAttribute]()
}
