package com.descabouda.model.attributes.critical

import java.util

import com.descabouda.decoder.AttributesDecoder
import com.descabouda.generator.AttributeGenerator
import com.descabouda.model.{BaseAttribute, BaseClass, OutputAttribute}

class CodeAttribute extends OutputAttribute {
  name = "Code"

  var maxStack: Int = 0
  var maxLocals: Int = 0

  var codeLength: Int = 0
  var code: Array[Byte] = null

  var exceptionTableLength: Int = 0
  var exceptionTable = new util.ArrayList[CodeExceptionTable]()

  var attributesCount: Int = 0
  var attributeInfo = new util.ArrayList[OutputAttribute]()

  override def fromStream(baseClass: BaseClass, baseAttribute: BaseAttribute): OutputAttribute = {
    val infoStream = baseAttribute.getStream

    this.maxStack = infoStream.readUnsignedShort()
    this.maxLocals = infoStream.readUnsignedShort()

    this.codeLength = infoStream.readInt()
    this.code = new Array[Byte](this.codeLength)
    infoStream.read(this.code)

    this.exceptionTableLength = infoStream.readUnsignedShort()

    for (i <- 0 until this.exceptionTableLength) {
      val exceptionTable = new CodeExceptionTable()

      exceptionTable.startPc = infoStream.readUnsignedShort()
      exceptionTable.endPc = infoStream.readUnsignedShort()
      exceptionTable.handlerPc = infoStream.readUnsignedShort()
      exceptionTable.catchType = infoStream.readUnsignedShort()

      this.exceptionTable.add(exceptionTable)
    }

    this.attributesCount = infoStream.readUnsignedShort()

    val attributesDecoder = new AttributesDecoder()
    val attributeGenerator = new AttributeGenerator()

    for (i <- 0 until this.attributesCount) {
      val attribute = attributesDecoder.decode(infoStream)
      val outAttribute = attributeGenerator.generate(baseClass, attribute)
      this.attributeInfo.add(outAttribute)
    }

    this
  }
}

class CodeExceptionTable {
  var startPc: Int = 0
  var endPc: Int = 0
  var handlerPc: Int = 0
  var catchType: Int = 0
}
