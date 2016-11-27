package com.descabouda.model.constants

import java.util

class BaseCode {
  var opCode: Byte = null
  var opCodeString: String = null
  val operands = new util.ArrayList[Byte]()
}
