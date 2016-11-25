package com.descabouda.decoder

import java.io.DataInputStream

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseAttribute, BaseInterface}

class AttributesDecoder {
  def decode(classStream: DataInputStream): BaseAttribute = {
    val attribute = new BaseAttribute()
    attribute.attributeNameIndex = classStream.readUnsignedShort()
    attribute.attributeLength = classStream.readInt()
    attribute.info = new Array[Byte](attribute.attributeLength)

    classStream.read(attribute.info)
    attribute
  }
}
