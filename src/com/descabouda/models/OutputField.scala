package com.descabouda.models

import java.util

class OutputField {
  var publicFlag: Boolean = false
  var privateFlag: Boolean = false
  var protectedFlag: Boolean = false
  var staticFlag: Boolean = false
  var finalFlag: Boolean = false
  var volatileFlag: Boolean = false
  var transientFlag: Boolean = false
  var syntheticFlag: Boolean = false
  var enumFlag: Boolean = false

  var name: String = null
  var descriptor: String = null
  var returnType: String = null

  var attributes = Map[String, OutputAttribute]()
}
