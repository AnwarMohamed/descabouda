package com.descabouda.generator

import java.io.{ByteArrayInputStream, DataInputStream}

import com.descabouda.decoder.AttributesDecoder
import com.descabouda.model._
import com.descabouda.model.attributes.critical._
import com.descabouda.model.attributes._

class AttributeGenerator {
  def generate(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val name = baseClass.getUtf8(attribute.attributeNameIndex - 1)

    name match {
      case "ConstantValue" => generateConstantValue(baseClass, attribute)
      case "Code" => generateCode(baseClass, attribute)
      case "StackMapTable" => generateStackMapTable(baseClass, attribute)
      case "Exceptions" => generateExceptions(baseClass, attribute)
      case "BootstrapMethods" => generateBootstrapMethods(baseClass, attribute)

      case "InnerClasses" => generateInnerClasses(baseClass, attribute)
      case "EnclosingMethod" => generateEnclosingMethod(baseClass, attribute)
      case "Synthetic" => generateSynthetic(baseClass, attribute)
      case "Signature" => generateSignature(baseClass, attribute)
      case "RuntimeVisibleAnnotations" => generateRuntimeVisibleAnnotations(baseClass, attribute)
      case "RuntimeInvisibleAnnotations" => generateRuntimeInvisibleAnnotations(baseClass, attribute)
      case "RuntimeVisibleParameterAnnotations" => generateRuntimeVisibleParameterAnnotations(baseClass, attribute)
      case "RuntimeInvisibleParameterAnnotations" => generateRuntimeInvisibleParameterAnnotations(baseClass, attribute)
      case "RuntimeVisibleTypeAnnotations" => generateRuntimeVisibleTypeAnnotations(baseClass, attribute)
      case "RuntimeInvisibleTypeAnnotations" => generateRuntimeInvisibleTypeAnnotations(baseClass, attribute)
      case "AnnotationDefault" => generateAnnotationDefault(baseClass, attribute)
      case "MethodParameters" => generateMethodParameters(baseClass, attribute)

      case "SourceFile" => generateSourceFile(baseClass, attribute)
      case "SourceDebugExtension" => generateSourceDebugExtension(baseClass, attribute)
      case "LineNumberTable" => generateLineNumberTable(baseClass, attribute)
      case "LocalVariableTable" => generateLocalVariableTable(baseClass, attribute)
      case "LocalVariableTypeTable" => generateLocalVariableTypeTable(baseClass, attribute)
      case "Deprecated" => generateDeprecated(baseClass, attribute)

      case _ =>
        new OutputAttribute()
    }
  }

  def generateDeprecated(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new DeprecatedAttribute()

    outputAttribute
  }

  def generateLocalVariableTypeTable(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new LocalVariableTypeTableAttribute()

    outputAttribute
  }

  def generateSourceDebugExtension(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new SourceDebugExtensionAttribute()

    outputAttribute
  }

  def generateAnnotationDefault(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new AnnotationDefaultAttribute()

    outputAttribute
  }

  def generateRuntimeInvisibleTypeAnnotations(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new RuntimeInvisibleTypeAnnotationsAttribute()

    outputAttribute
  }

  def generateRuntimeVisibleTypeAnnotations(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new RuntimeVisibleTypeAnnotationsAttribute()

    outputAttribute
  }

  def generateRuntimeInvisibleParameterAnnotations(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new RuntimeInvisibleParameterAnnotationsAttribute()

    outputAttribute
  }

  def generateRuntimeVisibleParameterAnnotations(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new RuntimeVisibleParameterAnnotationsAttribute()

    outputAttribute
  }

  def generateRuntimeInvisibleAnnotations(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new RuntimeInvisibleAnnotationsAttribute()

    outputAttribute
  }

  def generateRuntimeVisibleAnnotations(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new RuntimeVisibleAnnotationsAttribute()

    outputAttribute
  }

  def generateSignature(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new SignatureAttribute()

    outputAttribute
  }

  def generateSynthetic(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new SyntheticAttribute()

    outputAttribute
  }

  def generateEnclosingMethod(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new EnclosingMethodAttribute()

    outputAttribute
  }

  def generateExceptions(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new ExceptionsAttribute()

    outputAttribute
  }

  def generateConstantValue(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new ConstantValueAttribute()

    outputAttribute
  }


  def generateInnerClasses(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new InnerClassesAttribute()

    outputAttribute
  }

  def generateSourceFile(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new SourceFileAttribute()

    outputAttribute
  }


  def generateBootstrapMethods(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new BootstrapMethodsAttribute()

    outputAttribute
  }

  def generateStackMapTable(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new StackMapTableAttribute()

    outputAttribute
  }

  def generateLineNumberTable(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new LineNumberTableAttribute()

    outputAttribute
  }

  def generateLocalVariableTable(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new LocalVariableTableAttribute()

    outputAttribute
  }

  def generateMethodParameters(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new MethodParametersAttribute()

    outputAttribute
  }

  def generateCode(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val infoStream = new DataInputStream(new ByteArrayInputStream(attribute.info))
    val outputAttribute = new CodeAttribute()

    outputAttribute.maxStack = infoStream.readUnsignedShort()
    outputAttribute.maxLocals = infoStream.readUnsignedShort()

    outputAttribute.codeLength = infoStream.readInt()
    outputAttribute.code = new Array[Byte](outputAttribute.codeLength)
    infoStream.read(outputAttribute.code)

    outputAttribute.exceptionTableLength = infoStream.readUnsignedShort()

    for (i <- 0 until outputAttribute.exceptionTableLength) {
      val exceptionTable = new ExceptionTable()

      exceptionTable.startPc = infoStream.readUnsignedShort()
      exceptionTable.endPc = infoStream.readUnsignedShort()
      exceptionTable.handlerPc = infoStream.readUnsignedShort()
      exceptionTable.catchType = infoStream.readUnsignedShort()

      outputAttribute.exceptionTable.add(exceptionTable)
    }

    outputAttribute.attributesCount = infoStream.readUnsignedShort()

    val attributesDecoder = new AttributesDecoder()
    val attributeGenerator = new AttributeGenerator()

    for (i <- 0 until outputAttribute.attributesCount) {
      val attribute = attributesDecoder.decode(infoStream)
      val outAttribute = attributeGenerator.generate(baseClass, attribute)
      outputAttribute.attributeInfo.add(outAttribute)
    }

    outputAttribute
  }
}
