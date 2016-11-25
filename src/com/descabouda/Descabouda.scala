package com.descabouda

import com.descabouda.decoder.ClassDecoder
import com.descabouda.input.ClassInputStream

object Descabouda {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Usage: ./descabouda [classfile]")
      System.exit(0)
    }

    val classStream = new ClassInputStream(args(0))
    val classDecoder = new ClassDecoder()
    classDecoder.decode(classStream)
  }
}
