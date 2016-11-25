package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{ClassModel, ConstantModel}

class ConstantDecoder {

  final val CONSTANT_Class: Byte = 7
  final val CONSTANT_FieldRef: Byte = 9
  final val CONSTANT_MethodRef: Byte = 10
  final val CONSTANT_InterfaceMethodRef: Byte = 11
  final val CONSTANT_String: Byte = 8
  final val CONSTANT_Integer: Byte = 3
  final val CONSTANT_Float: Byte = 4
  final val CONSTANT_Long: Byte = 5
  final val CONSTANT_Double: Byte = 6
  final val CONSTANT_NameAndType: Byte = 12
  final val CONSTANT_Utf8: Byte = 1
  final val CONSTANT_MethodHandle: Byte = 15
  final val CONSTANT_MethodType: Byte = 16
  final val CONSTANT_InvokeDynamic: Byte = 18

  def decode(classStream: ClassInputStream): ConstantModel = {
    val tag = classStream.readByte()

    tag match {
      case CONSTANT_Class =>
      case CONSTANT_FieldRef =>
      case CONSTANT_MethodRef =>
      case CONSTANT_InterfaceMethodRef =>
      case CONSTANT_String =>
      case CONSTANT_Integer =>
      case CONSTANT_Float =>
      case CONSTANT_Long =>
      case CONSTANT_Double =>
      case CONSTANT_NameAndType =>
      case CONSTANT_Utf8 =>
      case CONSTANT_MethodHandle =>
      case CONSTANT_MethodType =>
      case CONSTANT_InvokeDynamic =>
      case _ => null
    }
  }
}
