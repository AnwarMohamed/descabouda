package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseField, BaseInterface, BaseMethod}

class MethodsDecoder {
  def decode(classStream: ClassInputStream): BaseMethod = {
    val method = new BaseMethod()
    method.access_flags = classStream.readUnsignedShort()
    method.name_index = classStream.readUnsignedShort()
    method.descriptor_index = classStream.readUnsignedShort()
    method.attributes_count = classStream.readUnsignedShort()

    decodeAttributes(classStream, method)
  }

  def decodeAttributes(classStream: ClassInputStream, method: BaseMethod): BaseMethod = {
    val attributeDecoder = new AttributesDecoder()

    for (i <- 0 until method.attributes_count) {
      method.attributes.add(attributeDecoder.decode(classStream))
    }

    method
  }
}
