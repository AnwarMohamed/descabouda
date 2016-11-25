package com.descabouda.model

import java.util

class BaseField {
  var access_flags: Integer = null
  var name_index: Integer = null
  var descriptor_index: Integer = null
  var attributes_count: Integer = null

  val attributes = new util.LinkedList[BaseAttribute]()
}
