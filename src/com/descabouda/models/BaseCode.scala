package com.descabouda.models

import java.util

class BaseCode {
  var opCode: Byte = 0
  var opCodeString: String = null
  val operands = new util.ArrayList[Byte]()
}
