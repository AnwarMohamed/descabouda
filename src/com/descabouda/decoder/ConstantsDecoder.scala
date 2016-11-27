package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.models.{BaseClass, BaseConstant}
import com.descabouda.models.constants._

class ConstantsDecoder {

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

  def decode(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val tag = classStream.readByte()

    tag match {
      case CONSTANT_Class => decodeClass(classStream, baseClass)
      case CONSTANT_FieldRef => decodeFieldRef(classStream, baseClass)
      case CONSTANT_MethodRef => decodeMethodRef(classStream, baseClass)
      case CONSTANT_InterfaceMethodRef => decodeInterfaceMethodRef(classStream, baseClass)
      case CONSTANT_String => decodeString(classStream, baseClass)
      case CONSTANT_Integer => decodeInteger(classStream, baseClass)
      case CONSTANT_Float => decodeFloat(classStream, baseClass)
      case CONSTANT_Long => decodeFloat(classStream, baseClass)
      case CONSTANT_Double => decodeDouble(classStream, baseClass)
      case CONSTANT_NameAndType => decodeNameAndType(classStream, baseClass)
      case CONSTANT_Utf8 => decodeUtf8(classStream, baseClass)
      case CONSTANT_MethodHandle => decodeMethodHandle(classStream, baseClass)
      case CONSTANT_MethodType => decodeMethodType(classStream, baseClass)
      case CONSTANT_InvokeDynamic => decodeInvokeDynamic(classStream, baseClass)
      case _ =>
        throw new ClassDecoderException("Invalid constant tag")
    }
  }

  def decodeClass(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new ClassConstant()
    constant.tag = CONSTANT_Class
    constant.nameIndex = classStream.readUnsignedShort()
    constant.nameString = baseClass.getUtf8(constant.nameIndex - 1)
    constant
  }

  def decodeFieldRef(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new FieldRefConstant()
    constant.tag = CONSTANT_FieldRef
    constant.classIndex = classStream.readUnsignedShort()
    constant.nameAndTypeIndex = classStream.readUnsignedShort()

    val ntConstant = baseClass.constants.get(
      constant.nameAndTypeIndex - 1).asInstanceOf[NameAndTypeConstant]

    constant.classString = baseClass.getClassName(constant.classIndex - 1)
    constant.nameString = ntConstant.nameString
    constant.typeString = ntConstant.descriptorString
    constant
  }

  def decodeMethodRef(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new MethodRefConstant()
    constant.tag = CONSTANT_MethodRef
    constant.classIndex = classStream.readUnsignedShort()
    constant.nameAndTypeIndex = classStream.readUnsignedShort()

    val ntConstant = baseClass.constants.get(
      constant.nameAndTypeIndex - 1).asInstanceOf[NameAndTypeConstant]

    constant.classString = baseClass.getClassName(constant.classIndex - 1)
    constant.nameString = ntConstant.nameString
    constant.typeString = ntConstant.descriptorString
    constant
  }

  def decodeInterfaceMethodRef(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new InterfaceMethodRefConstant()
    constant.tag = CONSTANT_InterfaceMethodRef
    constant.classIndex = classStream.readUnsignedShort()
    constant.nameAndTypeIndex = classStream.readUnsignedShort()
    constant
  }

  def decodeString(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new StringConstant()
    constant.tag = CONSTANT_String
    constant.stringIndex = classStream.readUnsignedShort()
    constant
  }

  def decodeInteger(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new IntegerConstant()
    constant.tag = CONSTANT_Integer
    constant.bytes = classStream.readInt()
    constant
  }

  def decodeFloat(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new FloatConstant()
    constant.tag = CONSTANT_Float
    constant.bytes = classStream.readInt()
    constant
  }

  def decodeLong(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new LongConstant()
    constant.tag = CONSTANT_Long
    constant.highBytes = classStream.readInt()
    constant.lowBytes = classStream.readInt()
    constant
  }

  def decodeDouble(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new DoubleConstant()
    constant.tag = CONSTANT_Double
    constant.highBytes = classStream.readInt()
    constant.lowBytes = classStream.readInt()
    constant
  }

  def decodeNameAndType(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new NameAndTypeConstant()
    constant.tag = CONSTANT_NameAndType
    constant.nameIndex = classStream.readUnsignedShort()
    constant.descriptorIndex = classStream.readUnsignedShort()

    constant.nameString = baseClass.getUtf8(constant.nameIndex - 1)
    constant.descriptorString = baseClass.getUtf8(constant.descriptorIndex - 1)
    constant
  }

  def decodeUtf8(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new Utf8Constant()
    constant.tag = CONSTANT_Utf8
    constant.length = classStream.readUnsignedShort()
    constant.bytes = new Array[Byte](constant.length)

    classStream.read(constant.bytes)
    constant.string = new String(constant.bytes)
    constant
  }

  def decodeMethodHandle(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new MethodHandleConstant()
    constant.tag = CONSTANT_MethodHandle
    constant.referenceKind = classStream.readByte()
    constant.referenceIndex = classStream.readUnsignedShort()
    constant
  }

  def decodeMethodType(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new MethodTypeConstant()
    constant.tag = CONSTANT_MethodType
    constant.descriptorIndex = classStream.readUnsignedShort()
    constant
  }

  def decodeInvokeDynamic(classStream: ClassInputStream, baseClass: BaseClass): BaseConstant = {
    val constant = new InvokeDynamicConstant()
    constant.tag = CONSTANT_InvokeDynamic
    constant.bootstrapMethodAttrIndex = classStream.readUnsignedShort()
    constant.nameAndTypeIndex = classStream.readUnsignedShort()
    constant
  }
}
