package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.BaseInterface

class InterfacesDecoder {
  def decode(classStream: ClassInputStream): BaseInterface = {
    val interface = new BaseInterface()
    interface.pool_index = classStream.readShort()
    interface
  }
}
