package com.descabouda.input

import java.io.{DataInputStream, FileInputStream, InputStream}

class ClassInputStream(i: InputStream) extends DataInputStream(i) {
  def this(path: String) = this(new FileInputStream(path))
}
