package com.descabouda.models.attributes

import com.descabouda.models.{BaseAttribute, BaseClass, OutputAttribute}

class SourceFileAttribute extends OutputAttribute {
  name = "SourceFile"

  var sourceFileIndex: Int = 0
  var string: String = null

  override def fromStream(baseClass: BaseClass, baseAttribute: BaseAttribute): OutputAttribute = {
    val infoStream = baseAttribute.getStream

    this.sourceFileIndex = infoStream.readUnsignedShort()
    this.string = baseClass.getUtf8(this.sourceFileIndex - 1)

    this
  }
}
