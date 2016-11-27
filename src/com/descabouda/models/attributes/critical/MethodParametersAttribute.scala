package com.descabouda.models.attributes.critical

import java.util

import com.descabouda.models.{BaseAttribute, BaseClass, OutputAttribute}

class MethodParametersAttribute extends OutputAttribute {
  name = "MethodParameters"

  final val ACC_FINAL: Short = 0x0010
  final val ACC_SYNTHETIC: Short = 0x1000
  final val ACC_MANDATED: Int = 0x8000

  var parametersCount: Byte = 0
  var parameters = new util.ArrayList[MethodParameter]()

  override def fromStream(baseClass: BaseClass, baseAttribute: BaseAttribute): OutputAttribute = {
    val infoStream = baseAttribute.getStream

    parametersCount = infoStream.readByte()

    for (i <- 0 until this.parametersCount) {
      val methodParameter = new MethodParameter()

      methodParameter.nameIndex = infoStream.readUnsignedShort()
      methodParameter.nameString = baseClass.getUtf8(methodParameter.nameIndex - 1)
      methodParameter.accessFlags = infoStream.readUnsignedShort()

      methodParameter.finalFlag = (methodParameter.accessFlags & ACC_FINAL) == ACC_FINAL
      methodParameter.syntheticFlag = (methodParameter.accessFlags & ACC_SYNTHETIC) == ACC_SYNTHETIC
      methodParameter.mandatedFlag = (methodParameter.accessFlags & ACC_MANDATED) == ACC_MANDATED

      this.parameters.add(methodParameter)
    }

    this
  }
}

 class MethodParameter {
   var nameIndex: Int = 0
   var nameString: String = null
   var accessFlags: Int = 0

   var finalFlag: Boolean = false
   var syntheticFlag: Boolean = false
   var mandatedFlag: Boolean = false
 }