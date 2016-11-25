package com.descabouda.decoder

import com.descabouda.input.ClassInputStream
import com.descabouda.model.{BaseClass, BaseConstant}

class ClassDecoder {

  final val ACC_PUBLIC: Short = 0x0001	    // Declared public; may be accessed from outside its package.
  final val ACC_FINAL: Short = 0x0010	      // Declared final; no subclasses allowed.
  final val ACC_SUPER: Short = 0x0020	      // Treat superclass methods specially when invoked by the
                                                    // invoke special instruction.
  final val ACC_INTERFACE: Short = 0x0200	  // Is an interface, not a class.
  final val ACC_ABSTRACT: Short = 0x0400	  // Declared abstract; must not be instantiated.
  final val ACC_SYNTHETIC: Short = 0x1000	  // Declared synthetic; not present in the source code.
  final val ACC_ANNOTATION: Short = 0x2000	// Declared as an annotation type.
  final val ACC_ENUM: Short = 0x4000	      // Declared as an enum type.


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
    classModel.minor_version = classStream.readShort()
    classModel.major_version = classStream.readShort()
  }

  def decodeClassMetaData(classStream: ClassInputStream, classModel: BaseClass) = {
    classModel.access_flags = classStream.readShort()
    classModel.this_class = classStream.readShort()
    classModel.super_class = classStream.readShort()
  }

  def decodeConstantPool(classStream: ClassInputStream, classModel: BaseClass) = {
    val constantsCount = classStream.readShort()
    val constantDecoder = new ConstantsDecoder()

    for (i <- 0 until constantsCount) {
      classModel.constants.add(constantDecoder.decode(classStream))
    }
  }

  def decodeInterfaces(classStream: ClassInputStream, classModel: BaseClass) = {
    val interfacesCount = classStream.readShort()
    val interfacesDecoder = new InterfacesDecoder()

    for (i <- 0 to interfacesCount) {
      classModel.interfaces.add(interfacesDecoder.decode(classStream))
    }
  }

  def decodeFields(classStream: ClassInputStream, classModel: BaseClass) = {
    val fieldsCount = classStream.readShort()
    val fieldsDecoder = new FieldsDecoder()

    for (i <- 0 to fieldsCount) {
      classModel.fields.add(fieldsDecoder.decode(classStream))
    }
  }

  def decodeMethods(classStream: ClassInputStream, classModel: BaseClass) = {
    val methodsCount = classStream.readShort()
    val methodsDecoder = new MethodsDecoder()

    for (i <- 0 to methodsCount) {
      classModel.methods.add(methodsDecoder.decode(classStream))
    }
  }

  def decodeAttributes(classStream: ClassInputStream, classModel: BaseClass) = {
    val attributesCount = classStream.readShort()
    val attributesDecoder = new AttributesDecoder()

    for (i <- 0 to attributesCount) {
      classModel.attributes.add(attributesDecoder.decode(classStream))
    }
  }
}