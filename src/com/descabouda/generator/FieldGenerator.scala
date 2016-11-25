package com.descabouda.generator

import com.descabouda.model._

class FieldGenerator {
  final val ACC_PUBLIC: Short = 0x0001	  // Declared public; may be accessed from outside its package.
  final val ACC_PRIVATE: Short = 0x0002	  // Declared private; usable only within the defining class.
  final val ACC_PROTECTED: Short = 0x0004	// Declared protected; may be accessed within subclasses.
  final val ACC_STATIC: Short = 0x0008	  // Declared static.
  final val ACC_FINAL: Short = 0x0010	    // Declared final; never directly assigned to after object construction..
  final val ACC_VOLATILE: Short = 0x0040	// Declared volatile; cannot be cached.
  final val ACC_TRANSIENT: Short = 0x0080	// Declared transient; not written or read by a persistent object manager.
  final val ACC_SYNTHETIC: Short = 0x1000	// Declared synthetic; not present in the source code.
  final val ACC_ENUM: Short = 	0x4000	  // Declared as an element of an enum.

  def generate(baseClass: BaseClass, field: BaseField): OutputField = {
    val outputField = new OutputField()

    outputField.publicFlag = (field.accessFlags & ACC_PUBLIC) == ACC_PUBLIC
    outputField.privateFlag = (field.accessFlags & ACC_PRIVATE) == ACC_PRIVATE
    outputField.protectedFlag = (field.accessFlags & ACC_PROTECTED) == ACC_PROTECTED
    outputField.staticFlag = (field.accessFlags & ACC_STATIC) == ACC_STATIC
    outputField.finalFlag = (field.accessFlags & ACC_FINAL) == ACC_FINAL
    outputField.volatileFlag = (field.accessFlags & ACC_VOLATILE) == ACC_VOLATILE
    outputField.transientFlag = (field.accessFlags & ACC_TRANSIENT) == ACC_TRANSIENT
    outputField.syntheticFlag = (field.accessFlags & ACC_SYNTHETIC) == ACC_SYNTHETIC
    outputField.enumFlag = (field.accessFlags & ACC_ENUM) == ACC_ENUM

    if (field.nameIndex > 0)
      outputField.name = baseClass.getUtf8(field.nameIndex - 1)

    generateAttributes(baseClass, field, outputField)
    outputField
  }

  def generateAttributes(baseClass: BaseClass, baseField: BaseField, field: OutputField): Unit = {
    val attributeGenerator = new AttributeGenerator()
    baseField.attributes.forEach((attribute) => {
      val outputAttribute = attributeGenerator.generate(baseClass, attribute)
      field.attributes += outputAttribute.name -> outputAttribute
    })
  }
}
