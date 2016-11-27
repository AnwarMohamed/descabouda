package com.descabouda.utils

import java.io.{ByteArrayInputStream, DataInputStream}
import java.util

object DescriptorUtils {
  final val descriptorPattern = "\\((.*?)\\)(.*?)$".r
  final val descriptorMap = Map(
    "B" -> "byte", "C" -> "char", "D" -> "double",
    "F" -> "float", "I" -> "int", "J" -> "long",
    "S" -> "short", "Z" -> "boolean", "V" -> "void")

  def getParameters(descriptor: String): util.ArrayList[String] = {
    descriptorPattern.findAllMatchIn(descriptor).foreach {
      m => {
        return parse(new DataInputStream(
          new ByteArrayInputStream(m.group(1).getBytes)))
      }
    }

    new util.ArrayList[String]()
  }

  def getReturn(descriptor: String, field: Boolean): String = {
    if (field) {
      return parse(new DataInputStream(
        new ByteArrayInputStream(descriptor.getBytes))).get(0)
    } else {
      descriptorPattern.findAllMatchIn(descriptor).foreach {
        m => {
          return parse(new DataInputStream(
            new ByteArrayInputStream(m.group(2).getBytes))).get(0)
        }
      }
    }

    ""
  }

  def parse(descriptor: DataInputStream): util.ArrayList[String] = {
    val descriptors = new util.ArrayList[String]()

    while (descriptor.available() > 0) {
      val token = String.valueOf((descriptor.readByte() & 0xFF).toChar)

      if (descriptorMap.contains(token))
        descriptors.add(descriptorMap(token))
      else if (token.equals("L"))
        descriptors.add(parseClass(descriptor))
      else if (token.equals("["))
        descriptors.add(parseArray(descriptor, 1))
    }

    descriptors
  }

  def parseArray(descriptor: DataInputStream, depth: Int): String = {
    val stringBuilder = new StringBuilder()
    val token = String.valueOf((descriptor.readByte() & 0xFF).toChar)

    if (descriptorMap.contains(token))
      stringBuilder.append(descriptorMap(token))
    else if (token.equals("L"))
      stringBuilder.append(parseClass(descriptor))
    else if (token.equals("["))
      stringBuilder.append(parseArray(descriptor, depth + 1))

    for (i <- 0 until depth)
      stringBuilder.append("[]")

    stringBuilder.toString().replaceAll("/", ".")
  }

  def parseClass(descriptor: DataInputStream): String = {
    val stringBuilder = new StringBuilder()
    var letter = String.valueOf((descriptor.readByte() & 0xFF).toChar)

    while (!letter.equals(";")) {
      stringBuilder.append(letter)
      letter = String.valueOf((descriptor.readByte() & 0xFF).toChar)
    }

    stringBuilder.toString().replaceAll("/", ".")
  }
}
