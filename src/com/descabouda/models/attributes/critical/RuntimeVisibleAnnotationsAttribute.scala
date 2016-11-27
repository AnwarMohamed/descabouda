package com.descabouda.models.attributes.critical

import java.util

import com.descabouda.models.OutputAttribute
import com.descabouda.models.annotations.Annotation

class RuntimeVisibleAnnotationsAttribute extends OutputAttribute {
  name = "RuntimeVisibleAnnotations"

  var numAnnotations: Int = 0
  var annotations = new util.ArrayList[Annotation]()
}
