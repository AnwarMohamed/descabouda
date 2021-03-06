package com.descabouda.models

import java.util

class OutputMethod {
  var publicFlag: Boolean = false
  var privateFlag: Boolean = false
  var protectedFlag: Boolean = false
  var staticFlag: Boolean = false
  var finalFlag: Boolean = false
  var synchronizedFlag: Boolean = false
  var bridgeFlag: Boolean = false
  var varArgsFlag: Boolean = false
  var nativeFlag: Boolean = false
  var abstractFlag: Boolean = false
  var strictFlag: Boolean = false
  var syntheticFlag: Boolean = false

  var name: String = null
  var descriptor: String = null
  var returnType: String = null
  var parametersType: util.ArrayList[String] = null

  var attributes = Map[String, OutputAttribute]()
  var raw: BaseMethod = null
}
