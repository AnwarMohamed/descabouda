package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseAttribute, BaseInterface}

class AttributesDecoder {
  def decode(classStream: ClassInputStream): BaseAttribute = {
    val attribute = new BaseAttribute()
    attribute.attribute_name_index = classStream.readUnsignedShort()
    attribute.attribute_length = classStream.readInt()
    attribute.info = new Array[Byte](attribute.attribute_length)

    classStream.read(attribute.info)
    attribute
  }
}
