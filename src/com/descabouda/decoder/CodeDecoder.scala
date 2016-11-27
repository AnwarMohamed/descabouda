package com.descabouda.decoder

import java.io.DataInputStream

import com.descabouda.input.ClassInputStream
import com.descabouda.model.BaseField
import com.descabouda.model.constants.BaseCode

class CodeDecoder {
  final val OPCODE_AALOAD = 0x32

  def decode(classStream: DataInputStream, length: Int): BaseCode = {
    val code = new BaseCode()

    code
  }
}
