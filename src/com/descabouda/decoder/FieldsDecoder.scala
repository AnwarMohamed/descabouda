package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseField, BaseInterface}

class FieldsDecoder {
  def decode(classStream: ClassInputStream): BaseField = {
    val field = new BaseField()
    field.accessFlags = classStream.readUnsignedShort()
    field.nameIndex = classStream.readUnsignedShort()
    field.descriptorIndex = classStream.readUnsignedShort()
    field.attributesCount = classStream.readUnsignedShort()

    decodeAttributes(classStream, field)
  }

  def decodeAttributes(classStream: ClassInputStream, field: BaseField): BaseField = {
    val attributeDecoder = new AttributesDecoder()

    for (i <- 0 until field.attributesCount) {
      field.attributes.add(attributeDecoder.decode(classStream))
    }

    field
  }
}
