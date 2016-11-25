package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseClass, BaseConstant}

class ClassDecoder {
  def decode(classStream: ClassInputStream): BaseClass = {
    val classModel = new BaseClass()

    decodeMagic(classStream, classModel)
    decodeVersion(classStream, classModel)

    decodeConstantPool(classStream, classModel)
    decodeMetaData(classStream, classModel)

    decodeInterfaces(classStream, classModel)
    decodeFields(classStream, classModel)
    decodeMethods(classStream, classModel)
    decodeAttributes(classStream, classModel)

    classModel
  }

  def decodeMagic(classStream: ClassInputStream, classModel: BaseClass) = {
    if (classStream.readInt() != 0xCAFEBABE)
      throw new ClassDecoderException("Invalid class magic")
  }

  def decodeVersion(classStream: ClassInputStream, classModel: BaseClass) = {
    classModel.minorVersion = classStream.readUnsignedShort()
    classModel.majorVersion = classStream.readUnsignedShort()
  }

  def decodeMetaData(classStream: ClassInputStream, classModel: BaseClass) = {
    classModel.accessFlags = classStream.readUnsignedShort()
    classModel.thisClass = classStream.readUnsignedShort()
    classModel.superClass = classStream.readUnsignedShort()
  }

  def decodeConstantPool(classStream: ClassInputStream, classModel: BaseClass) = {
    val constantsCount = classStream.readUnsignedShort()
    val constantDecoder = new ConstantsDecoder()

    for (i <- 0 until constantsCount - 1) {
      classModel.constants.add(constantDecoder.decode(classStream))
    }
  }

  def decodeInterfaces(classStream: ClassInputStream, classModel: BaseClass) = {
    val interfacesCount = classStream.readUnsignedShort()
    val interfacesDecoder = new InterfacesDecoder()

    for (i <- 0 until interfacesCount) {
      classModel.interfaces.add(interfacesDecoder.decode(classStream))
    }
  }

  def decodeFields(classStream: ClassInputStream, classModel: BaseClass) = {
    val fieldsCount = classStream.readUnsignedShort()
    val fieldsDecoder = new FieldsDecoder()

    for (i <- 0 until fieldsCount) {
      classModel.fields.add(fieldsDecoder.decode(classStream))
    }
  }

  def decodeMethods(classStream: ClassInputStream, classModel: BaseClass) = {
    val methodsCount = classStream.readUnsignedShort()
    val methodsDecoder = new MethodsDecoder()

    for (i <- 0 until methodsCount) {
      classModel.methods.add(methodsDecoder.decode(classStream))
    }
  }

  def decodeAttributes(classStream: ClassInputStream, classModel: BaseClass) = {
    val attributesCount = classStream.readUnsignedShort()
    val attributesDecoder = new AttributesDecoder()

    for (i <- 0 until attributesCount) {
      classModel.attributes.add(attributesDecoder.decode(classStream))
    }
  }
}