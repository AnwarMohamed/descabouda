package com.descabouda.generator

import com.descabouda.model.{BaseClass, OutputClass}


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

    generateClass(baseClass, outputClass)
    generateFields(baseClass, outputClass)
    generateMethods(baseClass, outputClass)

    outputClass
  }

  def generateClass(baseClass: BaseClass, outputClass: OutputClass): Unit = {
    if ((baseClass.accessFlags & ACC_PUBLIC) == ACC_PUBLIC) {

    }

    if ((baseClass.accessFlags & ACC_FINAL) == ACC_FINAL) {

    }

    if ((baseClass.accessFlags & ACC_SUPER) == ACC_SUPER) {

    }

    if ((baseClass.accessFlags & ACC_INTERFACE) == ACC_INTERFACE) {

    }

    if ((baseClass.accessFlags & ACC_SYNTHETIC) == ACC_SYNTHETIC) {

    }

    if ((baseClass.accessFlags & ACC_ANNOTATION) == ACC_ANNOTATION) {

    }

    if ((baseClass.accessFlags & ACC_ENUM) == ACC_ENUM) {

    }
  }

  def generateFields(baseClass: BaseClass, outputClass: OutputClass): Unit = {

  }

  def generateMethods(baseClass: BaseClass, outputClass: OutputClass): Unit = {

  }
}
