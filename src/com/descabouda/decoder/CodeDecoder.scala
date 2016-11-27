package com.descabouda.decoder

import java.io.DataInputStream

import com.descabouda.input.ClassInputStream
import com.descabouda.model.BaseField
import com.descabouda.model.constants.BaseCode

class CodeDecoder {
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

  def decode(classStream: DataInputStream, length: Int): BaseCode = {
    val code = new BaseCode()
    code.opCode = classStream.readByte()

    code.opCode match {
      case OPCODE_AALOAD =>
        code.opCodeString = "aaload"

      case OPCODE_AASTORE =>
        code.opCodeString = "aastore"

      case OPCODE_ACONST_NULL =>
        code.opCodeString = ""

      case OPCODE_ALOAD =>
        code.opCodeString = "aload"
        code.operands.add(classStream.readByte())

      case OPCODE_ALOAD_0 =>
        code.opCodeString = ""

      case OPCODE_ALOAD_1 =>
        code.opCodeString = ""

      case OPCODE_ALOAD_2 =>
        code.opCodeString = ""

      case OPCODE_ALOAD_3 =>
        code.opCodeString = ""

      case OPCODE_ANEWARRAY =>
        code.opCodeString = ""

      case OPCODE_ARETURN =>
        code.opCodeString = ""

      case OPCODE_ARRAYLENGTH =>
        code.opCodeString = ""

      case OPCODE_ASTORE =>
        code.opCodeString = ""

      case OPCODE_ASTORE_0 =>
        code.opCodeString = ""

      case OPCODE_ASTORE_1 =>
        code.opCodeString = ""

      case OPCODE_ASTORE_2 =>
        code.opCodeString = ""

      case OPCODE_ASTORE_3 =>
        code.opCodeString = ""

      case OPCODE_ATHROW =>
        code.opCodeString = ""

      case OPCODE_BALOAD =>
        code.opCodeString = ""

      case OPCODE_BASTORE =>
        code.opCodeString = ""

      case OPCODE_BIPUSH =>
        code.opCodeString = ""

      case OPCODE_BREAKPOINT =>
        code.opCodeString = ""

      case OPCODE_CALOAD =>
        code.opCodeString = ""

      case OPCODE_CASTORE =>
        code.opCodeString = ""

      case OPCODE_CHECKCAST =>
        code.opCodeString = ""

      case OPCODE_D2F =>
        code.opCodeString = ""

      case OPCODE_D2I =>
        code.opCodeString = ""

      case OPCODE_D2L =>
        code.opCodeString = ""

      case OPCODE_DADD =>
        code.opCodeString = ""

      case OPCODE_DALOAD =>
        code.opCodeString = ""

      case OPCODE_DASTORE =>
        code.opCodeString = ""

      case OPCODE_DCMPG =>
        code.opCodeString = ""

      case OPCODE_DCMPL =>
        code.opCodeString = ""

      case OPCODE_DCONST_0 =>
        code.opCodeString = ""

      case OPCODE_DCONST_1 =>
        code.opCodeString = ""

      case OPCODE_DDIV =>
        code.opCodeString = ""

      case OPCODE_DLOAD =>
        code.opCodeString = ""

      case OPCODE_DLOAD_0 =>
        code.opCodeString = ""

      case OPCODE_DLOAD_1 =>
        code.opCodeString = ""

      case OPCODE_DLOAD_2 =>
        code.opCodeString = ""

      case OPCODE_DLOAD_3 =>
        code.opCodeString = ""

      case OPCODE_DMUL =>
        code.opCodeString = ""

      case OPCODE_DNEG =>
        code.opCodeString = ""

      case OPCODE_DREM =>
        code.opCodeString = ""

      case OPCODE_DRETURN =>
        code.opCodeString = ""

      case OPCODE_DSTORE =>
        code.opCodeString = ""

      case OPCODE_DSTORE_0 =>
        code.opCodeString = ""

      case OPCODE_DSTORE_1 =>
        code.opCodeString = ""

      case OPCODE_DSTORE_2 =>
        code.opCodeString = ""

      case OPCODE_DSTORE_3 =>
        code.opCodeString = ""

      case OPCODE_DSUB =>
        code.opCodeString = ""

      case OPCODE_DUP =>
        code.opCodeString = ""

      case OPCODE_DUP_X1 =>
        code.opCodeString = ""

      case OPCODE_DUP_X2 =>
        code.opCodeString = ""

      case OPCODE_DUP2 =>
        code.opCodeString = ""

      case OPCODE_DUP2_X1 =>
        code.opCodeString = ""

      case OPCODE_DUP2_X2 =>
        code.opCodeString = ""

      case OPCODE_F2D =>
        code.opCodeString = ""

      case OPCODE_F2I =>
        code.opCodeString = ""

      case OPCODE_F2L =>
        code.opCodeString = ""

      case OPCODE_FADD =>
        code.opCodeString = ""

      case OPCODE_FALOAD =>
        code.opCodeString = ""

      case OPCODE_FASTORE =>
        code.opCodeString = ""

      case OPCODE_FCMPG =>
        code.opCodeString = ""

      case OPCODE_FCMPL =>
        code.opCodeString = ""

      case OPCODE_FCONST_0 =>
        code.opCodeString = ""

      case OPCODE_FCONST_1 =>
        code.opCodeString = ""

      case OPCODE_FCONST_2 =>
        code.opCodeString = ""

      case OPCODE_FDIV =>
        code.opCodeString = ""

      case OPCODE_FLOAD =>
        code.opCodeString = ""

      case OPCODE_FLOAD_0 =>
        code.opCodeString = ""

      case OPCODE_FLOAD_1 =>
        code.opCodeString = ""

      case OPCODE_FLOAD_2 =>
        code.opCodeString = ""

      case OPCODE_FLOAD_3 =>
        code.opCodeString = ""

      case OPCODE_FMUL =>
        code.opCodeString = ""

      case OPCODE_FNEG =>
        code.opCodeString = ""

      case OPCODE_FREM =>
        code.opCodeString = ""

      case OPCODE_FRETURN =>
        code.opCodeString = ""

      case OPCODE_FSTORE =>
        code.opCodeString = ""

      case OPCODE_FSTORE_0 =>
        code.opCodeString = ""

      case OPCODE_FSTORE_1 =>
        code.opCodeString = ""

      case OPCODE_FSTORE_2 =>
        code.opCodeString = ""

      case OPCODE_FSTORE_3 =>
        code.opCodeString = ""

      case OPCODE_FSUB =>
        code.opCodeString = ""

      case OPCODE_GETFIELD =>
        code.opCodeString = ""

      case OPCODE_GETSTATIC =>
        code.opCodeString = ""

      case OPCODE_GOTO =>
        code.opCodeString = ""

      case OPCODE_GOTO_W =>
        code.opCodeString = ""

      case OPCODE_I2B =>
        code.opCodeString = ""

      case OPCODE_I2C =>
        code.opCodeString = ""

      case OPCODE_I2D =>
        code.opCodeString = ""

      case OPCODE_I2F =>
        code.opCodeString = ""

      case OPCODE_I2L =>
        code.opCodeString = ""

      case OPCODE_I2S =>
        code.opCodeString = ""

      case OPCODE_IADD =>
        code.opCodeString = ""

      case OPCODE_IALOAD =>
        code.opCodeString = ""

      case OPCODE_IAND =>
        code.opCodeString = ""

      case OPCODE_IASTORE =>
        code.opCodeString = ""

      case OPCODE_ICONST_M1 =>
        code.opCodeString = ""

      case OPCODE_ICONST_0 =>
        code.opCodeString = ""

      case OPCODE_ICONST_1 =>
        code.opCodeString = ""

      case OPCODE_ICONST_2 =>
        code.opCodeString = ""

      case OPCODE_ICONST_3 =>
        code.opCodeString = ""

      case OPCODE_ICONST_4 =>
        code.opCodeString = ""

      case OPCODE_ICONST_5 =>
        code.opCodeString = ""

      case OPCODE_IDIV =>
        code.opCodeString = ""

      case OPCODE_IF_ACMPEQ =>
        code.opCodeString = ""

      case OPCODE_IF_ACMPNE =>
        code.opCodeString = ""

      case OPCODE_IF_ICMPEQ =>
        code.opCodeString = ""

      case OPCODE_IF_ICMPGE =>
        code.opCodeString = ""

      case OPCODE_IF_ICMPGT =>
        code.opCodeString = ""

      case OPCODE_IF_ICMPLE =>
        code.opCodeString = ""

      case OPCODE_IF_ICMPLT =>
        code.opCodeString = ""

      case OPCODE_IF_ICMPNE =>
        code.opCodeString = ""

      case OPCODE_IFEQ =>
        code.opCodeString = ""

      case OPCODE_IFGE =>
        code.opCodeString = ""

      case OPCODE_IFGT =>
        code.opCodeString = ""

      case OPCODE_IFLE =>
        code.opCodeString = ""

      case OPCODE_IFLT =>
        code.opCodeString = ""

      case OPCODE_IFNE =>
        code.opCodeString = ""

      case OPCODE_IFNONNULL =>
        code.opCodeString = ""

      case OPCODE_IFNULL =>
        code.opCodeString = ""

      case OPCODE_IINC =>
        code.opCodeString = ""

      case OPCODE_ILOAD =>
        code.opCodeString = ""

      case OPCODE_ILOAD_0 =>
        code.opCodeString = ""

      case OPCODE_ILOAD_1 =>
        code.opCodeString = ""

      case OPCODE_ILOAD_2 =>
        code.opCodeString = ""

      case OPCODE_ILOAD_3 =>
        code.opCodeString = ""

      case OPCODE_IMPDEP1 =>
        code.opCodeString = ""

      case OPCODE_IMPDEP2 =>
        code.opCodeString = ""

      case OPCODE_IMUL =>
        code.opCodeString = ""

      case OPCODE_INEG =>
        code.opCodeString = ""

      case OPCODE_INSTANCEOF =>
        code.opCodeString = ""

      case OPCODE_INVOKEDYNAMIC =>
        code.opCodeString = ""

      case OPCODE_INVOKEINTERFACE =>
        code.opCodeString = ""

      case OPCODE_INVOKESPECIAL =>
        code.opCodeString = ""

      case OPCODE_INVOKESTATIC =>
        code.opCodeString = ""

      case OPCODE_INVOKEVIRTUAL =>
        code.opCodeString = ""

      case OPCODE_IOR =>
        code.opCodeString = ""

      case OPCODE_IREM =>
        code.opCodeString = ""

      case OPCODE_IRETURN =>
        code.opCodeString = ""

      case OPCODE_ISHL =>
        code.opCodeString = ""

      case OPCODE_ISHR =>
        code.opCodeString = ""

      case OPCODE_ISTORE =>
        code.opCodeString = ""

      case OPCODE_ISTORE_0 =>
        code.opCodeString = ""

      case OPCODE_ISTORE_1 =>
        code.opCodeString = ""

      case OPCODE_ISTORE_2 =>
        code.opCodeString = ""

      case OPCODE_ISTORE_3 =>
        code.opCodeString = ""

      case OPCODE_ISUB =>
        code.opCodeString = ""

      case OPCODE_IUSHR =>
        code.opCodeString = ""

      case OPCODE_IXOR =>
        code.opCodeString = ""

      case OPCODE_JSR =>
        code.opCodeString = ""

      case OPCODE_JSR_W =>
        code.opCodeString = ""

      case OPCODE_L2D =>
        code.opCodeString = ""

      case OPCODE_L2F =>
        code.opCodeString = ""

      case OPCODE_L2I =>
        code.opCodeString = ""

      case OPCODE_LADD =>
        code.opCodeString = ""

      case OPCODE_LALOAD =>
        code.opCodeString = ""

      case OPCODE_LAND =>
        code.opCodeString = ""

      case OPCODE_LASTORE =>
        code.opCodeString = ""

      case OPCODE_LCMP =>
        code.opCodeString = ""

      case OPCODE_LCONST_0 =>
        code.opCodeString = ""

      case OPCODE_LCONST_1 =>
        code.opCodeString = ""

      case OPCODE_LDC =>
        code.opCodeString = ""

      case OPCODE_LDC_W =>
        code.opCodeString = ""

      case OPCODE_LDC2_W =>
        code.opCodeString = ""

      case OPCODE_LDIV =>
        code.opCodeString = ""

      case OPCODE_LLOAD =>
        code.opCodeString = ""

      case OPCODE_LLOAD_0 =>
        code.opCodeString = ""

      case OPCODE_LLOAD_1 =>
        code.opCodeString = ""

      case OPCODE_LLOAD_2 =>
        code.opCodeString = ""

      case OPCODE_LLOAD_3 =>
        code.opCodeString = ""

      case OPCODE_LMUL =>
        code.opCodeString = ""

      case OPCODE_LNEG =>
        code.opCodeString = ""

      case OPCODE_LOOKUPSWITCH =>
        code.opCodeString = ""

      case OPCODE_LOR =>
        code.opCodeString = ""

      case OPCODE_LREM =>
        code.opCodeString = ""

      case OPCODE_LRETURN =>
        code.opCodeString = ""

      case OPCODE_LSHL =>
        code.opCodeString = ""

      case OPCODE_LSHR =>
        code.opCodeString = ""

      case OPCODE_LSTORE =>
        code.opCodeString = ""

      case OPCODE_LSTORE_0 =>
        code.opCodeString = ""

      case OPCODE_LSTORE_1 =>
        code.opCodeString = ""

      case OPCODE_LSTORE_2 =>
        code.opCodeString = ""

      case OPCODE_LSTORE_3 =>
        code.opCodeString = ""

      case OPCODE_LSUB =>
        code.opCodeString = ""

      case OPCODE_LUSHR =>
        code.opCodeString = ""

      case OPCODE_LXOR =>
        code.opCodeString = ""

      case OPCODE_MONITORENTER =>
        code.opCodeString = ""

      case OPCODE_MONITOREXIT =>
        code.opCodeString = ""

      case OPCODE_MULTIANEWARRAY =>
        code.opCodeString = ""

      case OPCODE_NEW =>
        code.opCodeString = ""

      case OPCODE_NEWARRAY =>
        code.opCodeString = ""

      case OPCODE_NOP =>
        code.opCodeString = ""

      case OPCODE_POP =>
        code.opCodeString = ""

      case OPCODE_POP2 =>
        code.opCodeString = ""

      case OPCODE_PUTFIELD =>
        code.opCodeString = ""

      case OPCODE_PUTSTATIC =>
        code.opCodeString = ""

      case OPCODE_RET =>
        code.opCodeString = ""

      case OPCODE_RETURN =>
        code.opCodeString = ""

      case OPCODE_SALOAD =>
        code.opCodeString = ""

      case OPCODE_SASTORE =>
        code.opCodeString = ""

      case OPCODE_SIPUSH =>
        code.opCodeString = ""

      case OPCODE_SWAP =>
        code.opCodeString = ""

      case OPCODE_TABLESWITCH =>
        code.opCodeString = ""

      case OPCODE_WIDE =>
        code.opCodeString = ""
    }

    code
  }
}
