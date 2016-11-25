package com.descabouda

import com.descabouda.decoder.ClassDecoder
import com.descabouda.generator.ClassGenerator
import com.descabouda.input.ClassInputStream
import com.sun.org.apache.bcel.internal.generic.ClassGen

object Descabouda {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Usage: ./descabouda [classfile]")
      System.exit(0)
    }

    val classStream = new ClassInputStream(args(0))
    val classDecoder = new ClassDecoder()
    val classGenerator = new ClassGenerator()

    val baseClass = classDecoder.decode(classStream)
    val outputClass = classGenerator.generate(baseClass)

    println(outputClass.name)
  }
}
