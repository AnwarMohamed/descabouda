package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.models.BaseInterface

class InterfacesDecoder {
  def decode(classStream: ClassInputStream): BaseInterface = {
    val interface = new BaseInterface()
    interface.poolIndex = classStream.readUnsignedShort()
    interface
  }
}
