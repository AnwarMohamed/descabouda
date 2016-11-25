package com.descabouda.model

import java.util

class OutputClass {
  val fields = new util.LinkedList[OutputField]()
  val methods = new util.LinkedList[OutputMethod]()

  var public_flag
}
