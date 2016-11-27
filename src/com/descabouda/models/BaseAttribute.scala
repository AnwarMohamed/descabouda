package com.descabouda.models

import java.io.{ByteArrayInputStream, DataInputStream}

class BaseAttribute {
  var attributeNameIndex: Int = 0
  var attributeLength: Int = 0
  var info: Array[Byte] = null

  def getStream: DataInputStream = {
    new DataInputStream(new ByteArrayInputStream(info))
  }
}
