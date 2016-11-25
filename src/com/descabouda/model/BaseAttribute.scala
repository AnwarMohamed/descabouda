package com.descabouda.model

import java.io.{ByteArrayInputStream, DataInputStream}

class BaseAttribute {
  var attributeNameIndex: Integer = null
  var attributeLength: Integer = null
  var info: Array[Byte] = null

  def getStream: DataInputStream = {
    new DataInputStream(new ByteArrayInputStream(info))
  }
}
