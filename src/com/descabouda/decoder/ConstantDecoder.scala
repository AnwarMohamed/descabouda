package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.BaseConstant
import com.descabouda.model.constants._

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

  def decode(classStream: ClassInputStream): BaseConstant = {
    val tag = classStream.readByte()

    tag match {
      case CONSTANT_Class => decodeClass(classStream)
      case CONSTANT_FieldRef => decodeFieldRef(classStream)
      case CONSTANT_MethodRef => decodeMethodRef(classStream)
      case CONSTANT_InterfaceMethodRef => decodeInterfaceMethodRef(classStream)
      case CONSTANT_String => decodeString(classStream)
      case CONSTANT_Integer => decodeInteger(classStream)
      case CONSTANT_Float => decodeFloat(classStream)
      case CONSTANT_Long => decodeFloat(classStream)
      case CONSTANT_Double => decodeDouble(classStream)
      case CONSTANT_NameAndType => decodeNameAndType(classStream)
      case CONSTANT_Utf8 => decodeUtf8(classStream)
      case CONSTANT_MethodHandle => decodeMethodHandle(classStream)
      case CONSTANT_MethodType => decodeMethodType(classStream)
      case CONSTANT_InvokeDynamic => decodeInvokeDynamic(classStream)
      case _ =>
        throw new ClassDecoderException("Invalid constant tag")
    }
  }

  def decodeClass(classStream: ClassInputStream): BaseConstant = {
    val constant = new ClassConstant()
    constant.tag = CONSTANT_Class
    constant.name_index = classStream.readShort()
    constant
  }

  def decodeFieldRef(classStream: ClassInputStream): BaseConstant = {
    val constant = new FieldRefConstant()
    constant.tag = CONSTANT_FieldRef
    constant.class_index = classStream.readShort()
    constant.name_and_type_index = classStream.readShort()
    constant
  }

  def decodeMethodRef(classStream: ClassInputStream): BaseConstant = {
    val constant = new MethodRefConstant()
    constant.tag = CONSTANT_MethodRef
    constant.class_index = classStream.readShort()
    constant.name_and_type_index = classStream.readShort()
    constant
  }

  def decodeInterfaceMethodRef(classStream: ClassInputStream): BaseConstant = {
    val constant = new InterfaceMethodRefConstant()
    constant.tag = CONSTANT_InterfaceMethodRef
    constant.class_index = classStream.readShort()
    constant.name_and_type_index = classStream.readShort()
    constant
  }

  def decodeString(classStream: ClassInputStream): BaseConstant = {
    val constant = new StringConstant()
    constant.tag = CONSTANT_String
    constant.string_index = classStream.readShort()
    constant
  }

  def decodeInteger(classStream: ClassInputStream): BaseConstant = {
    val constant = new IntegerConstant()
    constant.tag = CONSTANT_Integer
    constant.bytes = classStream.readInt()
    constant
  }

  def decodeFloat(classStream: ClassInputStream): BaseConstant = {
    val constant = new FloatConstant()
    constant.tag = CONSTANT_Float
    constant.bytes = classStream.readInt()
    constant
  }

  def decodeLong(classStream: ClassInputStream): BaseConstant = {
    val constant = new LongConstant()
    constant.tag = CONSTANT_Long
    constant.high_bytes = classStream.readInt()
    constant.low_bytes = classStream.readInt()
    constant
  }

  def decodeDouble(classStream: ClassInputStream): BaseConstant = {
    val constant = new DoubleConstant()
    constant.tag = CONSTANT_Double
    constant.high_bytes = classStream.readInt()
    constant.low_bytes = classStream.readInt()
    constant
  }

  def decodeNameAndType(classStream: ClassInputStream): BaseConstant = {
    val constant = new NameAndTypeConstant()
    constant.tag = CONSTANT_NameAndType
    constant.name_index = classStream.readShort()
    constant.descriptor_index = classStream.readShort()
    constant
  }

  def decodeUtf8(classStream: ClassInputStream): BaseConstant = {
    val constant = new Utf8Constant()
    constant.tag = CONSTANT_Utf8
    constant.length = classStream.readShort()
    constant.bytes = new Array[Byte](constant.length)

    classStream.read(constant.bytes)
    constant
  }

  def decodeMethodHandle(classStream: ClassInputStream): BaseConstant = {
    val constant = new MethodHandleConstant()
    constant.tag = CONSTANT_MethodHandle
    constant.reference_kind = classStream.readByte()
    constant.reference_index = classStream.readShort()
    constant
  }

  def decodeMethodType(classStream: ClassInputStream): BaseConstant = {
    val constant = new MethodTypeConstant()
    constant.tag = CONSTANT_MethodType
    constant.descriptor_index = classStream.readShort()
    constant
  }

  def decodeInvokeDynamic(classStream: ClassInputStream): BaseConstant = {
    val constant = new InvokeDynamicConstant()
    constant.tag = CONSTANT_InvokeDynamic
    constant.bootstrap_method_attr_index = classStream.readShort()
    constant.name_and_type_index = classStream.readShort()
    constant
  }
}
