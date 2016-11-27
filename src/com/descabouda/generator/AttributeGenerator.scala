package com.descabouda.generator

import com.descabouda.models._
import com.descabouda.models.attributes._
import com.descabouda.models.attributes.critical._

class AttributeGenerator {
  def generate(baseClass: BaseClass, attribute: BaseAttribute): OutputAttribute = {
    val name = baseClass.getUtf8(attribute.attributeNameIndex - 1)

    name match {
      case "ConstantValue"    => new ConstantValueAttribute().fromStream(baseClass, attribute)
      case "Code"             => new CodeAttribute().fromStream(baseClass, attribute)
      case "StackMapTable"    => new StackMapTableAttribute().fromStream(baseClass, attribute)
      case "Exceptions"       => new ExceptionsAttribute().fromStream(baseClass, attribute)
      case "BootstrapMethods" => new BootstrapMethodsAttribute().fromStream(baseClass, attribute)

      case "InnerClasses"     => new InnerClassesAttribute().fromStream(baseClass, attribute)
      case "EnclosingMethod"  => new EnclosingMethodAttribute().fromStream(baseClass, attribute)
      case "Synthetic"        => new SyntheticAttribute().fromStream(baseClass, attribute)
      case "Signature"        => new SignatureAttribute().fromStream(baseClass, attribute)

      case "RuntimeVisibleAnnotations"
      => new RuntimeVisibleAnnotationsAttribute().fromStream(baseClass, attribute)
      case "RuntimeInvisibleAnnotations"
      => new RuntimeInvisibleAnnotationsAttribute().fromStream(baseClass, attribute)
      case "RuntimeVisibleParameterAnnotations"
      => new RuntimeVisibleParameterAnnotationsAttribute().fromStream(baseClass, attribute)
      case "RuntimeInvisibleParameterAnnotations"
      => new RuntimeInvisibleParameterAnnotationsAttribute().fromStream(baseClass, attribute)
      case "RuntimeVisibleTypeAnnotations"
      => new RuntimeVisibleTypeAnnotationsAttribute().fromStream(baseClass, attribute)
      case "RuntimeInvisibleTypeAnnotations"
      => new RuntimeInvisibleTypeAnnotationsAttribute().fromStream(baseClass, attribute)

      case "AnnotationDefault"                    => new AnnotationDefaultAttribute().fromStream(baseClass, attribute)
      case "MethodParameters"                     => new MethodParametersAttribute().fromStream(baseClass, attribute)

      case "SourceFile"               => new SourceFileAttribute().fromStream(baseClass, attribute)
      case "SourceDebugExtension"     => new SourceDebugExtensionAttribute().fromStream(baseClass, attribute)
      case "LineNumberTable"          => new LineNumberTableAttribute().fromStream(baseClass, attribute)
      case "LocalVariableTable"       => new LocalVariableTableAttribute().fromStream(baseClass, attribute)
      case "LocalVariableTypeTable"   => new LocalVariableTypeTableAttribute().fromStream(baseClass, attribute)
      case "Deprecated"               => new DeprecatedAttribute().fromStream(baseClass, attribute)

      case _ =>
//        println("Unimplemented attribute: " + name)
        new OutputAttribute()
    }
  }
}
