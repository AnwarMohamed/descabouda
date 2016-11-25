package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseField, BaseInterface}

class FieldsDecoder {
  def decode(classStream: ClassInputStream): BaseField = {
    val field = new BaseField()
    field.access_flags = classStream.readUnsignedShort()
    field.name_index = classStream.readUnsignedShort()
    field.descriptor_index = classStream.readUnsignedShort()
    field.attributes_count = classStream.readUnsignedShort()

    decodeAttributes(classStream, field)
  }

  def decodeAttributes(classStream: ClassInputStream, field: BaseField): BaseField = {
    val attributeDecoder = new AttributesDecoder()

    for (i <- 0 until field.attributes_count) {
      field.attributes.add(attributeDecoder.decode(classStream))
    }

    field
  }
}
