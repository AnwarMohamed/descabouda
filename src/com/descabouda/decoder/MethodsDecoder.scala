package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.models.{BaseField, BaseInterface, BaseMethod}

class MethodsDecoder {
  def decode(classStream: ClassInputStream): BaseMethod = {
    val method = new BaseMethod()
    method.accessFlags = classStream.readUnsignedShort()
    method.nameIndex = classStream.readUnsignedShort()
    method.descriptorIndex = classStream.readUnsignedShort()
    method.attributesCount = classStream.readUnsignedShort()

    decodeAttributes(classStream, method)
  }

  def decodeAttributes(classStream: ClassInputStream, method: BaseMethod): BaseMethod = {
    val attributeDecoder = new AttributesDecoder()

    for (i <- 0 until method.attributesCount) {
      method.attributes.add(attributeDecoder.decode(classStream))
    }

    method
  }
}
