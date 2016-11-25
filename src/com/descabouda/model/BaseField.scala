package com.descabouda.model

import java.util

class BaseField {
  var access_flags: Short = null
  var name_index: Short = null
  var descriptor_index: Short = null
  var attributes_count: Short = null

  val attributes = new util.LinkedList[BaseAttribute]()
}
