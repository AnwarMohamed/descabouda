package com.descabouda.models

import java.util

class BaseCode {
  var mnemonic: Int = 0
  var mnemonicString: String = null
  val operands = new util.ArrayList[Int]()
  var operandsString: String = ""
  var length: Int = 1
}
