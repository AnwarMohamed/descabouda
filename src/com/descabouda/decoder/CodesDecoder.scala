package com.descabouda.decoder

import java.io.DataInputStream
import java.util

import com.descabouda.input.ClassInputStream
import com.descabouda.models.{BaseCode, BaseField}

class CodesDecoder {
  final val OPCODE_AALOAD = 0x32
  final val OPCODE_AASTORE = 0x53
  final val OPCODE_ACONST_NULL = 0x01
  final val OPCODE_ALOAD = 0x19
  final val OPCODE_ALOAD_0 = 0x2a
  final val OPCODE_ALOAD_1 = 0x2b
  final val OPCODE_ALOAD_2 = 0x2c
  final val OPCODE_ALOAD_3 = 0x2d
  final val OPCODE_ANEWARRAY = 0xbd
  final val OPCODE_ARETURN = 0xb0
  final val OPCODE_ARRAYLENGTH = 0xbe
  final val OPCODE_ASTORE = 0x3a
  final val OPCODE_ASTORE_0 = 0x4b
  final val OPCODE_ASTORE_1 = 0x4c
  final val OPCODE_ASTORE_2 = 0x4d
  final val OPCODE_ASTORE_3 = 0x4e
  final val OPCODE_ATHROW = 0xbf
  final val OPCODE_BALOAD = 0x33
  final val OPCODE_BASTORE = 0x54
  final val OPCODE_BIPUSH = 0x10
  final val OPCODE_BREAKPOINT = 0xca
  final val OPCODE_CALOAD = 0x34
  final val OPCODE_CASTORE = 0x55
  final val OPCODE_CHECKCAST = 0xc0
  final val OPCODE_D2F = 0x90
  final val OPCODE_D2I = 0x8e
  final val OPCODE_D2L = 0x8f
  final val OPCODE_DADD = 0x63
  final val OPCODE_DALOAD = 0x31
  final val OPCODE_DASTORE = 0x52
  final val OPCODE_DCMPG = 0x98
  final val OPCODE_DCMPL = 0x97
  final val OPCODE_DCONST_0 = 0x0e
  final val OPCODE_DCONST_1 = 0x0f
  final val OPCODE_DDIV = 0x6f
  final val OPCODE_DLOAD = 0x18
  final val OPCODE_DLOAD_0 = 0x26
  final val OPCODE_DLOAD_1 = 0x27
  final val OPCODE_DLOAD_2 = 0x28
  final val OPCODE_DLOAD_3 = 0x29
  final val OPCODE_DMUL = 0x6b
  final val OPCODE_DNEG = 0x77
  final val OPCODE_DREM = 0x73
  final val OPCODE_DRETURN = 0xaf
  final val OPCODE_DSTORE = 0x39
  final val OPCODE_DSTORE_0 = 0x47
  final val OPCODE_DSTORE_1 = 0x48
  final val OPCODE_DSTORE_2 = 0x49
  final val OPCODE_DSTORE_3 = 0x4a
  final val OPCODE_DSUB = 0x67
  final val OPCODE_DUP = 0x59
  final val OPCODE_DUP_X1 = 0x5a
  final val OPCODE_DUP_X2 = 0x5b
  final val OPCODE_DUP2 = 0x5c
  final val OPCODE_DUP2_X1 = 0x5d
  final val OPCODE_DUP2_X2 = 0x5e
  final val OPCODE_F2D = 0x8d
  final val OPCODE_F2I = 0x8b
  final val OPCODE_F2L = 0x8c
  final val OPCODE_FADD = 0x62
  final val OPCODE_FALOAD = 0x30
  final val OPCODE_FASTORE = 0x51
  final val OPCODE_FCMPG = 0x96
  final val OPCODE_FCMPL = 0x95
  final val OPCODE_FCONST_0 = 0x0b
  final val OPCODE_FCONST_1 = 0x0c
  final val OPCODE_FCONST_2 = 0x0d
  final val OPCODE_FDIV = 0x6e
  final val OPCODE_FLOAD = 0x17
  final val OPCODE_FLOAD_0 = 0x22
  final val OPCODE_FLOAD_1 = 0x23
  final val OPCODE_FLOAD_2 = 0x24
  final val OPCODE_FLOAD_3 = 0x25
  final val OPCODE_FMUL = 0x6a
  final val OPCODE_FNEG = 0x76
  final val OPCODE_FREM = 0x72
  final val OPCODE_FRETURN = 0xae
  final val OPCODE_FSTORE = 0x38
  final val OPCODE_FSTORE_0 = 0x43
  final val OPCODE_FSTORE_1 = 0x44
  final val OPCODE_FSTORE_2 = 0x45
  final val OPCODE_FSTORE_3 = 0x46
  final val OPCODE_FSUB = 0x66
  final val OPCODE_GETFIELD = 0xb4
  final val OPCODE_GETSTATIC = 0xb2
  final val OPCODE_GOTO = 0xa7
  final val OPCODE_GOTO_W = 0xc8
  final val OPCODE_I2B = 0x91
  final val OPCODE_I2C = 0x92
  final val OPCODE_I2D = 0x87
  final val OPCODE_I2F = 0x86
  final val OPCODE_I2L = 0x85
  final val OPCODE_I2S = 0x93
  final val OPCODE_IADD = 0x60
  final val OPCODE_IALOAD = 0x2e
  final val OPCODE_IAND = 0x7e
  final val OPCODE_IASTORE = 0x4f
  final val OPCODE_ICONST_M1 = 0x02
  final val OPCODE_ICONST_0 = 0x03
  final val OPCODE_ICONST_1 = 0x04
  final val OPCODE_ICONST_2 = 0x05
  final val OPCODE_ICONST_3 = 0x06
  final val OPCODE_ICONST_4 = 0x07
  final val OPCODE_ICONST_5 = 0x08
  final val OPCODE_IDIV = 0x6c
  final val OPCODE_IF_ACMPEQ = 0xa5
  final val OPCODE_IF_ACMPNE = 0xa6
  final val OPCODE_IF_ICMPEQ = 0x9f
  final val OPCODE_IF_ICMPGE = 0xa2
  final val OPCODE_IF_ICMPGT = 0xa3
  final val OPCODE_IF_ICMPLE = 0xa4
  final val OPCODE_IF_ICMPLT = 0xa1
  final val OPCODE_IF_ICMPNE = 0xa0
  final val OPCODE_IFEQ = 0x99
  final val OPCODE_IFGE = 0x9c
  final val OPCODE_IFGT = 0x9d
  final val OPCODE_IFLE = 0x9e
  final val OPCODE_IFLT = 0x9b
  final val OPCODE_IFNE = 0x9a
  final val OPCODE_IFNONNULL = 0xc7
  final val OPCODE_IFNULL = 0xc6
  final val OPCODE_IINC = 0x84
  final val OPCODE_ILOAD = 0x15
  final val OPCODE_ILOAD_0 = 0x1a
  final val OPCODE_ILOAD_1 = 0x1b
  final val OPCODE_ILOAD_2 = 0x1c
  final val OPCODE_ILOAD_3 = 0x1d
  final val OPCODE_IMPDEP1 = 0xfe
  final val OPCODE_IMPDEP2 = 0xff
  final val OPCODE_IMUL = 0x68
  final val OPCODE_INEG = 0x74
  final val OPCODE_INSTANCEOF = 0xc1
  final val OPCODE_INVOKEDYNAMIC = 0xba
  final val OPCODE_INVOKEINTERFACE = 0xb9
  final val OPCODE_INVOKESPECIAL = 0xb7
  final val OPCODE_INVOKESTATIC = 0xb8
  final val OPCODE_INVOKEVIRTUAL = 0xb6
  final val OPCODE_IOR = 0x80
  final val OPCODE_IREM = 0x70
  final val OPCODE_IRETURN = 0xac
  final val OPCODE_ISHL = 0x78
  final val OPCODE_ISHR = 0x7a
  final val OPCODE_ISTORE = 0x36
  final val OPCODE_ISTORE_0 = 0x3b
  final val OPCODE_ISTORE_1 = 0x3c
  final val OPCODE_ISTORE_2 = 0x3d
  final val OPCODE_ISTORE_3 = 0x3e
  final val OPCODE_ISUB = 0x64
  final val OPCODE_IUSHR = 0x7c
  final val OPCODE_IXOR = 0x82
  final val OPCODE_JSR = 0xa8
  final val OPCODE_JSR_W = 0xc9
  final val OPCODE_L2D = 0x8a
  final val OPCODE_L2F = 0x89
  final val OPCODE_L2I = 0x88
  final val OPCODE_LADD = 0x61
  final val OPCODE_LALOAD = 0x2f
  final val OPCODE_LAND = 0x7f
  final val OPCODE_LASTORE = 0x50
  final val OPCODE_LCMP = 0x94
  final val OPCODE_LCONST_0 = 0x09
  final val OPCODE_LCONST_1 = 0x0a
  final val OPCODE_LDC = 0x12
  final val OPCODE_LDC_W = 0x13
  final val OPCODE_LDC2_W = 0x14
  final val OPCODE_LDIV = 0x6d
  final val OPCODE_LLOAD = 0x16
  final val OPCODE_LLOAD_0 = 0x1e
  final val OPCODE_LLOAD_1 = 0x1f
  final val OPCODE_LLOAD_2 = 0x20
  final val OPCODE_LLOAD_3 = 0x21
  final val OPCODE_LMUL = 0x69
  final val OPCODE_LNEG = 0x75
  final val OPCODE_LOOKUPSWITCH = 0xab
  final val OPCODE_LOR = 0x81
  final val OPCODE_LREM = 0x71
  final val OPCODE_LRETURN = 0xad
  final val OPCODE_LSHL = 0x79
  final val OPCODE_LSHR = 0x7b
  final val OPCODE_LSTORE = 0x37
  final val OPCODE_LSTORE_0 = 0x3f
  final val OPCODE_LSTORE_1 = 0x40
  final val OPCODE_LSTORE_2 = 0x41
  final val OPCODE_LSTORE_3 = 0x42
  final val OPCODE_LSUB = 0x65
  final val OPCODE_LUSHR = 0x7d
  final val OPCODE_LXOR = 0x83
  final val OPCODE_MONITORENTER = 0xc2
  final val OPCODE_MONITOREXIT = 0xc3
  final val OPCODE_MULTIANEWARRAY = 0xc5
  final val OPCODE_NEW = 0xbb
  final val OPCODE_NEWARRAY = 0xbc
  final val OPCODE_NOP = 0x00
  final val OPCODE_POP = 0x57
  final val OPCODE_POP2 = 0x58
  final val OPCODE_PUTFIELD = 0xb5
  final val OPCODE_PUTSTATIC = 0xb3
  final val OPCODE_RET = 0xa9
  final val OPCODE_RETURN = 0xb1
  final val OPCODE_SALOAD = 0x35
  final val OPCODE_SASTORE = 0x56
  final val OPCODE_SIPUSH = 0x11
  final val OPCODE_SWAP = 0x5f
  final val OPCODE_TABLESWITCH = 0xaa
  final val OPCODE_WIDE = 0xc4

  def decode(classStream: DataInputStream, length: Int): util.ArrayList[BaseCode] = {
    var codeLength = 0
    val codes: util.ArrayList[BaseCode] = new util.ArrayList[BaseCode]()

    while (codeLength < length) {
      val code = new BaseCode()
      code.mnemonic = classStream.readUnsignedByte()

      code.mnemonic match {
        case OPCODE_AALOAD =>
          code.mnemonicString = "aaload"

        case OPCODE_AASTORE =>
          code.mnemonicString = "aastore"

        case OPCODE_ACONST_NULL =>
          code.mnemonicString = "aconst_null"

        case OPCODE_ALOAD =>
          code.mnemonicString = "aload"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_ALOAD_0 =>
          code.mnemonicString = "aload_0"

        case OPCODE_ALOAD_1 =>
          code.mnemonicString = "aload_1"

        case OPCODE_ALOAD_2 =>
          code.mnemonicString = "aload_2"

        case OPCODE_ALOAD_3 =>
          code.mnemonicString = "aload_3"

        case OPCODE_ANEWARRAY =>
          code.mnemonicString = "anewarray"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_ARETURN =>
          code.mnemonicString = "areturn"

        case OPCODE_ARRAYLENGTH =>
          code.mnemonicString = "arraylength"

        case OPCODE_ASTORE =>
          code.mnemonicString = "astore"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_ASTORE_0 =>
          code.mnemonicString = "astore_0"

        case OPCODE_ASTORE_1 =>
          code.mnemonicString = "astore_1"

        case OPCODE_ASTORE_2 =>
          code.mnemonicString = "astore_2"

        case OPCODE_ASTORE_3 =>
          code.mnemonicString = "astore_3"

        case OPCODE_ATHROW =>
          code.mnemonicString = "athrow"

        case OPCODE_BALOAD =>
          code.mnemonicString = "baload"

        case OPCODE_BASTORE =>
          code.mnemonicString = "bastore"

        case OPCODE_BIPUSH =>
          code.mnemonicString = "bipush"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_BREAKPOINT =>
          code.mnemonicString = "breakpoint"

        case OPCODE_CALOAD =>
          code.mnemonicString = "caload"

        case OPCODE_CASTORE =>
          code.mnemonicString = "castore"

        case OPCODE_CHECKCAST =>
          code.mnemonicString = "checkcast"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_D2F =>
          code.mnemonicString = "d2f"

        case OPCODE_D2I =>
          code.mnemonicString = "d2i"

        case OPCODE_D2L =>
          code.mnemonicString = "d2l"

        case OPCODE_DADD =>
          code.mnemonicString = "dadd"

        case OPCODE_DALOAD =>
          code.mnemonicString = "daload"

        case OPCODE_DASTORE =>
          code.mnemonicString = "dastore"

        case OPCODE_DCMPG =>
          code.mnemonicString = "dcmpg"

        case OPCODE_DCMPL =>
          code.mnemonicString = "dcmpl"

        case OPCODE_DCONST_0 =>
          code.mnemonicString = "dconst_0"

        case OPCODE_DCONST_1 =>
          code.mnemonicString = "dconst_1"

        case OPCODE_DDIV =>
          code.mnemonicString = "ddiv"

        case OPCODE_DLOAD =>
          code.mnemonicString = "dload"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_DLOAD_0 =>
          code.mnemonicString = "dload_0"

        case OPCODE_DLOAD_1 =>
          code.mnemonicString = "dload_1"

        case OPCODE_DLOAD_2 =>
          code.mnemonicString = "dload_2"

        case OPCODE_DLOAD_3 =>
          code.mnemonicString = "dload_3"

        case OPCODE_DMUL =>
          code.mnemonicString = "dmul"

        case OPCODE_DNEG =>
          code.mnemonicString = "dneg"

        case OPCODE_DREM =>
          code.mnemonicString = "drem"

        case OPCODE_DRETURN =>
          code.mnemonicString = "dreturn"

        case OPCODE_DSTORE =>
          code.mnemonicString = "dstore"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_DSTORE_0 =>
          code.mnemonicString = "dstore_0"

        case OPCODE_DSTORE_1 =>
          code.mnemonicString = "dstore_1"

        case OPCODE_DSTORE_2 =>
          code.mnemonicString = "dstore_2"

        case OPCODE_DSTORE_3 =>
          code.mnemonicString = "dstore_3"

        case OPCODE_DSUB =>
          code.mnemonicString = "dsub"

        case OPCODE_DUP =>
          code.mnemonicString = "dup"

        case OPCODE_DUP_X1 =>
          code.mnemonicString = "dup_x1"

        case OPCODE_DUP_X2 =>
          code.mnemonicString = "dup_x2"

        case OPCODE_DUP2 =>
          code.mnemonicString = "dup2"

        case OPCODE_DUP2_X1 =>
          code.mnemonicString = "dup2_x1"

        case OPCODE_DUP2_X2 =>
          code.mnemonicString = "dup2_x2"

        case OPCODE_F2D =>
          code.mnemonicString = "f2d"

        case OPCODE_F2I =>
          code.mnemonicString = "f2i"

        case OPCODE_F2L =>
          code.mnemonicString = "f2l"

        case OPCODE_FADD =>
          code.mnemonicString = "fadd"

        case OPCODE_FALOAD =>
          code.mnemonicString = "faload"

        case OPCODE_FASTORE =>
          code.mnemonicString = "fastore"

        case OPCODE_FCMPG =>
          code.mnemonicString = "fcmpg"

        case OPCODE_FCMPL =>
          code.mnemonicString = "fcmpl"

        case OPCODE_FCONST_0 =>
          code.mnemonicString = "fconst_0"

        case OPCODE_FCONST_1 =>
          code.mnemonicString = "fconst_1"

        case OPCODE_FCONST_2 =>
          code.mnemonicString = "fconst_2"

        case OPCODE_FDIV =>
          code.mnemonicString = "fdiv"

        case OPCODE_FLOAD =>
          code.mnemonicString = "fload"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_FLOAD_0 =>
          code.mnemonicString = "fload_0"

        case OPCODE_FLOAD_1 =>
          code.mnemonicString = "fload_1"

        case OPCODE_FLOAD_2 =>
          code.mnemonicString = "fload_2"

        case OPCODE_FLOAD_3 =>
          code.mnemonicString = "fload_3"

        case OPCODE_FMUL =>
          code.mnemonicString = "fmul"

        case OPCODE_FNEG =>
          code.mnemonicString = "fneg"

        case OPCODE_FREM =>
          code.mnemonicString = "frem"

        case OPCODE_FRETURN =>
          code.mnemonicString = "freturn"

        case OPCODE_FSTORE =>
          code.mnemonicString = "fstore"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_FSTORE_0 =>
          code.mnemonicString = "fstore_0"

        case OPCODE_FSTORE_1 =>
          code.mnemonicString = "fstore_1"

        case OPCODE_FSTORE_2 =>
          code.mnemonicString = "fstore_2"

        case OPCODE_FSTORE_3 =>
          code.mnemonicString = "fstore_3"

        case OPCODE_FSUB =>
          code.mnemonicString = "fsub"

        case OPCODE_GETFIELD =>
          code.mnemonicString = "getfield"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2


        case OPCODE_GETSTATIC =>
          code.mnemonicString = "getstatic"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2


        case OPCODE_GOTO =>
          code.mnemonicString = "goto"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2


        case OPCODE_GOTO_W =>
          code.mnemonicString = "goto_w"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2


        case OPCODE_I2B =>
          code.mnemonicString = "i2b"

        case OPCODE_I2C =>
          code.mnemonicString = "i2c"

        case OPCODE_I2D =>
          code.mnemonicString = "i2d"

        case OPCODE_I2F =>
          code.mnemonicString = "i2f"

        case OPCODE_I2L =>
          code.mnemonicString = "i2l"

        case OPCODE_I2S =>
          code.mnemonicString = "i2s"

        case OPCODE_IADD =>
          code.mnemonicString = "iadd"

        case OPCODE_IALOAD =>
          code.mnemonicString = "iaload"

        case OPCODE_IAND =>
          code.mnemonicString = "iand"

        case OPCODE_IASTORE =>
          code.mnemonicString = "iastore"

        case OPCODE_ICONST_M1 =>
          code.mnemonicString = "iconst_m1"

        case OPCODE_ICONST_0 =>
          code.mnemonicString = "iconst_0"

        case OPCODE_ICONST_1 =>
          code.mnemonicString = "iconst_1"

        case OPCODE_ICONST_2 =>
          code.mnemonicString = "iconst_2"

        case OPCODE_ICONST_3 =>
          code.mnemonicString = "iconst_3"

        case OPCODE_ICONST_4 =>
          code.mnemonicString = "iconst_4"

        case OPCODE_ICONST_5 =>
          code.mnemonicString = "iconst_5"

        case OPCODE_IDIV =>
          code.mnemonicString = "idiv"

        case OPCODE_IF_ACMPEQ =>
          code.mnemonicString = "if_acmpeq"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ACMPNE =>
          code.mnemonicString = "if_acmpne"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ICMPEQ =>
          code.mnemonicString = "if_icmpeq"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ICMPGE =>
          code.mnemonicString = "if_icmpge"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ICMPGT =>
          code.mnemonicString = "if_icmpgt"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ICMPLE =>
          code.mnemonicString = "if_icmple"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ICMPLT =>
          code.mnemonicString = "if_icmplt"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IF_ICMPNE =>
          code.mnemonicString = "if_icmpne"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFEQ =>
          code.mnemonicString = "ifeq"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFGE =>
          code.mnemonicString = "ifge"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFGT =>
          code.mnemonicString = "ifgt"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFLE =>
          code.mnemonicString = "ifle"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFLT =>
          code.mnemonicString = "iflt"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFNE =>
          code.mnemonicString = "ifne"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFNONNULL =>
          code.mnemonicString = "ifnonnull"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IFNULL =>
          code.mnemonicString = "ifnull"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IINC =>
          code.mnemonicString = "iinc"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_ILOAD =>
          code.mnemonicString = "iload"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_ILOAD_0 =>
          code.mnemonicString = "iload_0"

        case OPCODE_ILOAD_1 =>
          code.mnemonicString = "iload_0"

        case OPCODE_ILOAD_2 =>
          code.mnemonicString = "iload_0"

        case OPCODE_ILOAD_3 =>
          code.mnemonicString = "iload_0"

        case OPCODE_IMPDEP1 =>
          code.mnemonicString = "impdep1"

        case OPCODE_IMPDEP2 =>
          code.mnemonicString = "impdep2"

        case OPCODE_IMUL =>
          code.mnemonicString = "imul"

        case OPCODE_INEG =>
          code.mnemonicString = "ineg"

        case OPCODE_INSTANCEOF =>
          code.mnemonicString = "instanceof"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_INVOKEDYNAMIC =>
          code.mnemonicString = "invokedynamic"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 4

        case OPCODE_INVOKEINTERFACE =>
          code.mnemonicString = "invokeinterface"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 4

        case OPCODE_INVOKESPECIAL =>
          code.mnemonicString = "invokespecial"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_INVOKESTATIC =>
          code.mnemonicString = "invokestatic"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_INVOKEVIRTUAL =>
          code.mnemonicString = "invokevirtual"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_IOR =>
          code.mnemonicString = "ior"

        case OPCODE_IREM =>
          code.mnemonicString = "irem"

        case OPCODE_IRETURN =>
          code.mnemonicString = "ireturn"

        case OPCODE_ISHL =>
          code.mnemonicString = "ishl"

        case OPCODE_ISHR =>
          code.mnemonicString = "ishr"

        case OPCODE_ISTORE =>
          code.mnemonicString = "istore"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_ISTORE_0 =>
          code.mnemonicString = "istore_0"

        case OPCODE_ISTORE_1 =>
          code.mnemonicString = "istore_1"

        case OPCODE_ISTORE_2 =>
          code.mnemonicString = "istore_2"

        case OPCODE_ISTORE_3 =>
          code.mnemonicString = "istore_3"

        case OPCODE_ISUB =>
          code.mnemonicString = "isub"

        case OPCODE_IUSHR =>
          code.mnemonicString = "iushr"

        case OPCODE_IXOR =>
          code.mnemonicString = "ixor"

        case OPCODE_JSR =>
          code.mnemonicString = "jsr"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_JSR_W =>
          code.mnemonicString = "jsr_w"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 4

        case OPCODE_L2D =>
          code.mnemonicString = "l2d"

        case OPCODE_L2F =>
          code.mnemonicString = "l2f"

        case OPCODE_L2I =>
          code.mnemonicString = "l2i"

        case OPCODE_LADD =>
          code.mnemonicString = "ladd"

        case OPCODE_LALOAD =>
          code.mnemonicString = "laload"

        case OPCODE_LAND =>
          code.mnemonicString = "land"

        case OPCODE_LASTORE =>
          code.mnemonicString = "lastore"

        case OPCODE_LCMP =>
          code.mnemonicString = "lcmp"

        case OPCODE_LCONST_0 =>
          code.mnemonicString = "lconst_0"

        case OPCODE_LCONST_1 =>
          code.mnemonicString = "lconst_1"

        case OPCODE_LDC =>
          code.mnemonicString = "ldc"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_LDC_W =>
          code.mnemonicString = "ldc_w"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_LDC2_W =>
          code.mnemonicString = "ldc2_2"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_LDIV =>
          code.mnemonicString = "ldiv"

        case OPCODE_LLOAD =>
          code.mnemonicString = "lload"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_LLOAD_0 =>
          code.mnemonicString = "lload_0"

        case OPCODE_LLOAD_1 =>
          code.mnemonicString = "lload_1"

        case OPCODE_LLOAD_2 =>
          code.mnemonicString = "lload_2"

        case OPCODE_LLOAD_3 =>
          code.mnemonicString = "lload_3"

        case OPCODE_LMUL =>
          code.mnemonicString = "lmul"

        case OPCODE_LNEG =>
          code.mnemonicString = "lneg"

        case OPCODE_LOOKUPSWITCH =>
          code.mnemonicString = "lookupswitch"

        case OPCODE_LOR =>
          code.mnemonicString = "lor"

        case OPCODE_LREM =>
          code.mnemonicString = "lrem"

        case OPCODE_LRETURN =>
          code.mnemonicString = "lreturn"

        case OPCODE_LSHL =>
          code.mnemonicString = "lshl"

        case OPCODE_LSHR =>
          code.mnemonicString = "lshr"

        case OPCODE_LSTORE =>
          code.mnemonicString = "lstore"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_LSTORE_0 =>
          code.mnemonicString = "lstore_0"

        case OPCODE_LSTORE_1 =>
          code.mnemonicString = "lstore_1"

        case OPCODE_LSTORE_2 =>
          code.mnemonicString = "lstore_2"

        case OPCODE_LSTORE_3 =>
          code.mnemonicString = "lstore_3"

        case OPCODE_LSUB =>
          code.mnemonicString = "lsub"

        case OPCODE_LUSHR =>
          code.mnemonicString = "lushr"

        case OPCODE_LXOR =>
          code.mnemonicString = "lxor"

        case OPCODE_MONITORENTER =>
          code.mnemonicString = "monitorenter"

        case OPCODE_MONITOREXIT =>
          code.mnemonicString = "monitorexit"

        case OPCODE_MULTIANEWARRAY =>
          code.mnemonicString = "multianewarray"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 3

        case OPCODE_NEW =>
          code.mnemonicString = "new"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_NEWARRAY =>
          code.mnemonicString = "newarray"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_NOP =>
          code.mnemonicString = "nop"

        case OPCODE_POP =>
          code.mnemonicString = "pop"

        case OPCODE_POP2 =>
          code.mnemonicString = "pop2"

        case OPCODE_PUTFIELD =>
          code.mnemonicString = "putfield"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_PUTSTATIC =>
          code.mnemonicString = "putstatic"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_RET =>
          code.mnemonicString = "ret"
          code.operands.add(classStream.readUnsignedByte())
          code.length += 1

        case OPCODE_RETURN =>
          code.mnemonicString = "return"

        case OPCODE_SALOAD =>
          code.mnemonicString = "saload"

        case OPCODE_SASTORE =>
          code.mnemonicString = "sastore"

        case OPCODE_SIPUSH =>
          code.mnemonicString = "sipush"
          code.operands.add(classStream.readUnsignedByte())
          code.operands.add(classStream.readUnsignedByte())
          code.length += 2

        case OPCODE_SWAP =>
          code.mnemonicString = "swap"

        case OPCODE_TABLESWITCH =>
          code.mnemonicString = "tableswitch"

        case OPCODE_WIDE =>
          code.mnemonicString = "wide"
      }

      codeLength += code.length
      codes.add(code)
    }

    codes
  }
}

