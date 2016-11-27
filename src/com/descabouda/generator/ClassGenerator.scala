package com.descabouda.generator

import com.descabouda.models.constants.{ClassConstant, Utf8Constant}
import com.descabouda.models._


class ClassGenerator {
  final val ACC_PUBLIC: Short = 0x0001	    // Declared public; may be accessed from outside its package.
  final val ACC_FINAL: Short = 0x0010	      // Declared final; no subclasses allowed.
  final val ACC_SUPER: Short = 0x0020	      // Treat superclass methods specially when invoked by the
                                            // invoke special instruction.
  final val ACC_INTERFACE: Short = 0x0200	  // Is an interface, not a class.
  final val ACC_ABSTRACT: Short = 0x0400	  // Declared abstract; must not be instantiated.
  final val ACC_SYNTHETIC: Short = 0x1000	  // Declared synthetic; not present in the source code.
  final val ACC_ANNOTATION: Short = 0x2000	// Declared as an annotation type.
  final val ACC_ENUM: Short = 0x4000	      // Declared as an enum type.

  def generate(baseClass: BaseClass): OutputClass = {
    val outputClass = new OutputClass()
    outputClass.raw = baseClass

    generateClass(baseClass, outputClass)
    generateInterfaces(baseClass, outputClass)
    generateFields(baseClass, outputClass)
    generateMethods(baseClass, outputClass)
    generateAttributes(baseClass, outputClass)

    outputClass
  }

  def generateClass(baseClass: BaseClass, outputClass: OutputClass): Unit = {
    outputClass.publicFlag = (baseClass.accessFlags & ACC_PUBLIC) == ACC_PUBLIC
    outputClass.finalFlag = (baseClass.accessFlags & ACC_FINAL) == ACC_FINAL
    outputClass.superFlag = (baseClass.accessFlags & ACC_SUPER) == ACC_SUPER
    outputClass.interfaceFlag = (baseClass.accessFlags & ACC_INTERFACE) == ACC_INTERFACE
    outputClass.abstractFlag = (baseClass.accessFlags & ACC_ABSTRACT) == ACC_ABSTRACT
    outputClass.syntheticFlag = (baseClass.accessFlags & ACC_SYNTHETIC) == ACC_SYNTHETIC
    outputClass.annotationFlag = (baseClass.accessFlags & ACC_ANNOTATION) == ACC_ANNOTATION
    outputClass.enumFlag = (baseClass.accessFlags & ACC_ENUM) == ACC_ENUM

    if (baseClass.thisClass > 0)
      outputClass.name = baseClass.getClassName(baseClass.thisClass - 1)

    if (baseClass.superClass > 0)
      outputClass.superName = baseClass.getClassName(baseClass.superClass - 1)
  }

  def generateInterfaces(baseClass: BaseClass, outputClass: OutputClass): Unit = {
    val interfacesIt = baseClass.interfaces.iterator
    while(interfacesIt.hasNext) {
      outputClass.interfaces.add(baseClass.getClassName(
        interfacesIt.asInstanceOf[BaseInterface].poolIndex - 1))
    }
  }

  def generateFields(baseClass: BaseClass, outputClass: OutputClass): Unit = {
    val fieldGenerator = new FieldGenerator()
    baseClass.fields.forEach((field) => {
      outputClass.fields.add(fieldGenerator.generate(baseClass, field))
    })
  }

  def generateMethods(baseClass: BaseClass, outputClass: OutputClass): Unit = {
    val methodGenerator = new MethodGenerator()
    baseClass.methods.forEach((method) => {
      outputClass.methods.add(methodGenerator.generate(baseClass, method))
    })
  }

  def generateAttributes(baseClass: BaseClass, outputClass: OutputClass): Unit = {
    val attributeGenerator = new AttributeGenerator()
    baseClass.attributes.forEach((attribute) => {
      val outputAttribute = attributeGenerator.generate(baseClass, attribute)
      outputClass.attributes += outputAttribute.name -> outputAttribute
    })
  }
}
