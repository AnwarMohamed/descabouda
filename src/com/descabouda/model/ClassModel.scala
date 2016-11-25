package com.descabouda.model

import java.util

class ClassModel {
  val constants = new util.LinkedList[ConstantModel]()
  val interfaces = new util.LinkedList[InterfaceModel]()
  val fields = new util.LinkedList[FieldModel]()
  val methods = new util.LinkedList[MethodModel]()
  val attributes = new util.LinkedList[AttributeModel]()

  var minor_version: Short = -1
  var major_version: Short = -1
}
