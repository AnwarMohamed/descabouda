package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseField, BaseInterface, BaseMethod}

class MethodsDecoder {
  def decode(classStream: ClassInputStream): BaseMethod = {
    val method = new BaseMethod()
    method.access_flags = classStream.readShort()
    method.name_index = classStream.readShort()
    method.descriptor_index = classStream.readShort()
    method.attributes_count = classStream.readShort()

    decodeAttributes(classStream, method)
  }

  def decodeAttributes(classStream: ClassInputStream, method: BaseMethod): BaseMethod = {
    val attributeDecoder = new AttributesDecoder()

    for (i <- 0 to method.attributes_count) {
      method.attributes.add(attributeDecoder.decode(classStream))
    }

    method
  }
}
