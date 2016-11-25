package com.descabouda.model

import java.io.{ByteArrayInputStream, DataInputStream}

class BaseAttribute {
  var attributeNameIndex: Int = Int.MinValue
  var attributeLength: Int = Int.MinValue
  var info: Array[Byte] = null

  def getStream: DataInputStream = {
    new DataInputStream(new ByteArrayInputStream(info))
  }
}
