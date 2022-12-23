package cn.navclub.nes4j.bin.config;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static cn.navclub.nes4j.bin.config.AddressMode.*;
import static cn.navclub.nes4j.bin.util.BinUtil.int8;


/**
 * 6502 指令集
 *
 * @author <a href="https://github.com/GZYangKui">GZYangKui</a>
 */
@Slf4j
public enum Instruction {
    /**
     * More detail please visit:<a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#ADC">ADC Document</a>
     */
    ADC(new InstructionWrap[]{
            InstructionWrap.create(int8(0x69), 2, 2, Immediate),
            InstructionWrap.create(int8(0x65), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x75), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x6D), 3, 4, Absolute),
            InstructionWrap.create(int8(0x7D), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x79), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0x61), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0x71), 2, 5, Indirect_Y),
    }),
    /**
     * 加载一字节数据进入累加器并视情况而定是否需要设置零或者负数flags.
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#LDA">相关文档</a>
     */
    LDA(new InstructionWrap[]{
            InstructionWrap.create(int8(0xA9), 2, 2, Immediate),
            InstructionWrap.create(int8(0xA5), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xB5), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0xAD), 3, 4, Absolute),
            InstructionWrap.create(int8(0xBD), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0xB9), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0xA1), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0xB1), 2, 5, Indirect_Y),
    }),
    /**
     * 将累加器中的值写入内存中
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#STA">相关文档</a>
     */
    STA(new InstructionWrap[]{
            InstructionWrap.create(int8(0x85), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x95), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x8D), 3, 4, Absolute),
            InstructionWrap.create(int8(0x9D), 3, 5, Absolute_X),
            InstructionWrap.create(int8(0x99), 3, 5, Absolute_Y),
            InstructionWrap.create(int8(0x81), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0x91), 2, 6, Indirect_Y)
    }
    ),
    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#STX">相关文档</a>
     */
    STX(new InstructionWrap[]{
            InstructionWrap.create(int8(0x86), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x96), 2, 4, ZeroPage_Y),
            InstructionWrap.create(int8(0x8E), 3, 4, Absolute),
    }),

    /**
     * 将寄存器Y中的值刷新到内存中
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#STY">相关文档</a>
     */
    STY(new InstructionWrap[]{
            InstructionWrap.create(int8(0x84), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x94), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0X8C), 3, 4, Absolute)
    }),

    /**
     * 与逻辑指令实现
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#AND">相关文档</a>
     */
    AND(new InstructionWrap[]{
            InstructionWrap.create(int8(0x29), 2, 2, Immediate),
            InstructionWrap.create(int8(0x25), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x35), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x2D), 3, 4, Absolute),
            InstructionWrap.create(int8(0x3D), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x39), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0x21), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0x31), 2, 5, Indirect_Y),
    }),

    /**
     * 或指令实现
     */
    ORA(new InstructionWrap[]{
            InstructionWrap.create(int8(0x09), 2, 2, Immediate),
            InstructionWrap.create(int8(0x05), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x15), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x0D), 3, 4, Absolute),
            InstructionWrap.create(int8(0x1D), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x19), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0x01), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0x11), 2, 5, Indirect_Y)
    }
    ),

    /**
     * 异或逻辑实现
     */
    EOR(new InstructionWrap[]{
            InstructionWrap.create(int8(0x49), 2, 2, Immediate),
            InstructionWrap.create(int8(0x45), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x55), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x4D), 3, 4, Absolute),
            InstructionWrap.create(int8(0x5D), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x59), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0x41), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0x51), 2, 5, Indirect_Y)
    }
    ),

    /**
     * 将累加寄存器中的值push到堆栈上
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#PHA">相关文档</a>
     */
    PHA(int8(0x48), 1, 3),

    /**
     * 将状态寄存器push到堆栈上
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#PHP">相关文档</a>
     */
    PHP(int8(0X08), 1, 3),

    /**
     * 从系统栈中获取值并更新累加寄存器
     *
     * <a href="href="https://www.nesdev.org/obelisk-6502-guide/reference.html#PLA">相关文档</a>
     */
    PLA(int8(0x68), 1, 4),

    /**
     * 从系统栈中读取值并更新状态寄存器
     * <a href="href="https://www.nesdev.org/obelisk-6502-guide/reference.html#PLP">相关文档</a>
     */
    PLP(int8(0x28), 1, 4),

    /**
     * 将操作数所有字节左移一位
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#ASL">相关文档</a>
     */
    ASL(new InstructionWrap[]{
            InstructionWrap.create(int8(0x0A), 1, 2, Accumulator),
            InstructionWrap.create(int8(0x06), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x16), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x0E), 3, 6, Absolute),
            InstructionWrap.create(int8(0x1E), 3, 7, Absolute_X)
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#LSR">相关文档</a>
     */
    LSR(new InstructionWrap[]{
            InstructionWrap.create(int8(0x4A), 1, 2, Accumulator),
            InstructionWrap.create(int8(0x46), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x56), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x4E), 3, 6, Absolute),
            InstructionWrap.create(int8(0x5E), 3, 7, Absolute_X)
    }),

    /**
     * 累加寄存器与指定内存值比较
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CMP">相关文档</a>
     */
    CMP(new InstructionWrap[]{
            InstructionWrap.create(int8(0xC9), 2, 2, Immediate),
            InstructionWrap.create(int8(0xC5), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xD5), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0xCD), 3, 4, Absolute),
            InstructionWrap.create(int8(0xDD), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0xD9), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0xC1), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0xD1), 2, 5, Indirect_Y)
    }),

    /**
     * 比较X寄存器与指定内存的值
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CMX">相关文档</a>
     */
    CPX(new InstructionWrap[]{
            InstructionWrap.create(int8(0xE0), 2, 2, Immediate),
            InstructionWrap.create(int8(0xE4), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xEC), 2, 4, Absolute),
    }),

    /**
     * 比较y寄存器与内存中的值
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CMY">相关文档</a>
     */
    CPY(new InstructionWrap[]{
            InstructionWrap.create(int8(0xC0), 2, 2, Immediate),
            InstructionWrap.create(int8(0xC4), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xCC), 2, 4, Absolute),
    }
    ),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#LDX">相关文档</a>
     */
    LDX(new InstructionWrap[]{
            InstructionWrap.create(int8(0xA2), 2, 2, Immediate),
            InstructionWrap.create(int8(0xA6), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xB6), 2, 4, ZeroPage_Y),
            InstructionWrap.create(int8(0xAE), 3, 4, Absolute),
            InstructionWrap.create(int8(0xBE), 3, 4, Absolute_Y)
    }
    ),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#LDY">相关文档</a>
     */
    LDY(new InstructionWrap[]{
            InstructionWrap.create(int8(0xA0), 2, 2, Immediate),
            InstructionWrap.create(int8(0xA4), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xb4), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0xAC), 3, 4, Absolute),
            InstructionWrap.create(int8(0xBC), 3, 4, Absolute_X)
    }
    ),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#INC">相关文档</a>
     */
    INC(new InstructionWrap[]{
            InstructionWrap.create(int8(0xE6), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0xF6), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0xEE), 3, 6, Absolute),
            InstructionWrap.create(int8(0xFE), 3, 7, Absolute_X),
    }
    ),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#JSR">相关文档</a>
     */
    JSR(new InstructionWrap[]{
            InstructionWrap.create(int8(0x20), 3, 6, Absolute)
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BIT">相关文档</a>
     */
    BIT(new InstructionWrap[]{
            InstructionWrap.create(int8(0x24), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0X2C), 3, 4, Absolute)
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#DCE">相关文档</a>
     */
    DEC(new InstructionWrap[]{
            InstructionWrap.create(int8(0xC6), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0xD6), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0xCE), 3, 6, Absolute),
            InstructionWrap.create(int8(0xDE), 3, 7, Absolute_X)
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#JMP">相关文档</a>
     */
    JMP(new InstructionWrap[]{
            InstructionWrap.create(int8(0x4c), 3, 3, Absolute),
            InstructionWrap.create(int8(0x6c), 3, 5, Indirect)
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#ROR">相关文档</a>
     */
    ROR(new InstructionWrap[]{
            InstructionWrap.create(int8(0x6A), 1, 2, Accumulator),
            InstructionWrap.create(int8(0x66), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x76), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x6E), 3, 6, Absolute),
            InstructionWrap.create(int8(0x7E), 3, 7, Absolute_X),
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#ROL">相关文档</a>
     */
    ROL(new InstructionWrap[]{
            InstructionWrap.create(int8(0x2A), 1, 2, Accumulator),
            InstructionWrap.create(int8(0x26), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x36), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x2E), 3, 6, Absolute),
            InstructionWrap.create(int8(0x3E), 3, 7, Absolute_X),
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#ADC">相关文档</a>
     */
    SBC(new InstructionWrap[]{
            InstructionWrap.create(int8(0xe9), 2, 2, Immediate),
            InstructionWrap.create(int8(0xe5), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xf5), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0xed), 3, 4, Absolute),
            InstructionWrap.create(int8(0xfd), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0xf9), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0xe1), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0xf1), 2, 5, Indirect_Y),
            //un-office sbc+NOP
            InstructionWrap.create((byte) 0xeb, 2, 2, Immediate)
    }),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#DCX">相关文档</a>
     */
    DEX(int8(0xCA), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#DCY">相关文档</a>
     */
    DEY(int8(0x88), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#RTS">相关文档</a>
     */
    RTS(int8(0X60), 1, 6),

    /**
     * 清除进位标识
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CLC">相关文档</a>
     */
    CLC(int8(0x18), 1, 2),

    /**
     * 清除数字标识
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CLD">相关文档</a>
     */
    CLD(int8(0xD8), 1, 2),

    /**
     * 清除中断标识
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CLI">相关文档</a>
     */
    CLI(int8(0x58), 1, 2),

    /**
     * 清除溢出标识
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#CLV">相关文档</a>
     */
    CLV(int8(0xB8), 1, 2),

    /**
     * 自增X寄存器
     *
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#INX">相关文档</a>
     */
    INX(int8(0XE8), 1, 2),

    /**
     * 自增Y寄存器
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#INY">相关文档</a>
     */
    INY(int8(0xC8), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#NOP">相关文档</a>
     */
    NOP(int8(0xea), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BCC">相关文档</a>
     */
    BCC(int8(0x90), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BCS">相关文档</a>
     */
    BCS(int8(0xB0), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BEQ">相关文档</a>
     */
    BEQ(int8(0xf0), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BNE">相关文档</a>
     */
    BNE(int8(0XD0), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BPL">相关文档</a>
     */
    BPL(int8(0X10), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BMI">相关文档</a>
     */
    BMI(int8(0x30), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BVC">相关文档</a>
     */
    BVC(int8(0x50), 2, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#BVS">相关文档</a>
     */
    BVS(int8(0x70), 2, 2, Relative),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#RTI">相关文档</a>
     */
    RTI(int8(0x40), 1, 6),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#SEC">相关文档</a>
     */
    SEC(int8(0x38), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#SED">相关文档</a>
     */
    SED(int8(0xF8), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#SEI">相关文档</a>
     */
    SEI(int8(0x78), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#TAX">相关文档</a>
     */
    TAX(int8(0xAA), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#TAY">相关文档</a>
     */
    TAY(int8(0xA8), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#TSX">相关文档</a>
     */
    TSX(int8(0xBA), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#TXA">相关文档</a>
     */
    TXA(int8(0x8A), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#TXS">相关文档</a>
     */
    TXS(int8(0x9A), 1, 2),

    /**
     * <a href="https://www.nesdev.org/obelisk-6502-guide/reference.html#TYA">相关文档</a>
     */
    TYA(int8(0x98), 1, 2),

    /**
     * 中断指令
     */
    BRK(int8(0x00), 1, 7),
    /**
     * AND+LSR
     */
    ALR(InstructionWrap.create(int8(0x4b), 2, 2, Immediate)),

    SHX(InstructionWrap.create(int8(0x9e), 3, 5, Absolute_Y)),

    XAA(InstructionWrap.create(int8(0x8b), 2, 2, Immediate)),

    ARR(InstructionWrap.create(int8(0x6b), 2, 2, Immediate)),
    /**
     * M AND SP -> A, X, SP
     */
    LAS(InstructionWrap.create(int8(0xbb), 3, 4, Immediate)),
    /**
     * Store * AND oper in A and X
     */
    LXA(InstructionWrap.create(int8(0xab), 2, 2, Immediate)),
    /**
     * AND oper + set C as ASL
     */
    ANC(new InstructionWrap[]{
            InstructionWrap.create(int8(0x0b), 2, 2, Immediate),
            InstructionWrap.create(int8(0x2b), 2, 2, Immediate)
    }),
    /**
     * LAD+LDX
     */
    LAX(new InstructionWrap[]{
            InstructionWrap.create(int8(0xa7), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0xb7), 2, 4, ZeroPage_Y),
            InstructionWrap.create(int8(0xaf), 3, 4, Absolute),
            InstructionWrap.create(int8(0xbf), 3, 4, Absolute_Y),
            InstructionWrap.create(int8(0xa3), 2, 6, Indirect_X),
            InstructionWrap.create(int8(0xb3), 2, 5, Indirect_Y)
    }),

    /**
     * DEC oper + CMP oper
     * <p>
     * M - 1 -> M, A - M
     */
    DCP(new InstructionWrap[]{
            InstructionWrap.create(int8(0xc7), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0xd7), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0xcf), 3, 6, Absolute),
            InstructionWrap.create(int8(0xdf), 3, 7, Absolute_X),
            InstructionWrap.create(int8(0xdb), 3, 7, Absolute_Y),
            InstructionWrap.create(int8(0xc3), 2, 8, Indirect_X),
            InstructionWrap.create(int8(0xd3), 2, 8, Indirect_Y)
    }),

    RLA(new InstructionWrap[]{
            InstructionWrap.create(int8(0x27), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x37), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x2f), 3, 6, Absolute),
            InstructionWrap.create(int8(0x3f), 3, 7, Absolute_X),
            InstructionWrap.create(int8(0x3b), 3, 7, Absolute_Y),
            InstructionWrap.create(int8(0x23), 2, 8, Indirect_X),
            InstructionWrap.create(int8(0x33), 2, 8, Indirect_Y)
    }),

    ISC(new InstructionWrap[]{
            InstructionWrap.create(int8(0xE7), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0xF7), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0xEF), 3, 6, Absolute),
            InstructionWrap.create(int8(0xFF), 3, 7, Absolute_X),
            InstructionWrap.create(int8(0xFB), 3, 7, Absolute_Y),
            InstructionWrap.create(int8(0xE3), 2, 8, Indirect_X),
            InstructionWrap.create(int8(0xF3), 2, 8, Indirect_Y)
    }),

    SLO(new InstructionWrap[]{
            InstructionWrap.create(int8(0x07), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x17), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x0f), 3, 6, Absolute),
            InstructionWrap.create(int8(0x1f), 3, 7, Absolute_X),
            InstructionWrap.create(int8(0x1b), 3, 7, Absolute_Y),
            InstructionWrap.create(int8(0x03), 2, 8, Indirect_X),
            InstructionWrap.create(int8(0x13), 2, 8, Indirect_Y)

    }),

    SRE(new InstructionWrap[]{
            InstructionWrap.create(int8(0x47), 2, 5, ZeroPage),
            InstructionWrap.create(int8(0x57), 2, 6, ZeroPage_X),
            InstructionWrap.create(int8(0x4f), 3, 6, Absolute),
            InstructionWrap.create(int8(0x5f), 3, 7, Absolute_X),
            InstructionWrap.create(int8(0x5b), 3, 7, Absolute_Y),
            InstructionWrap.create(int8(0x43), 2, 8, Indirect_X),
            InstructionWrap.create(int8(0x53), 2, 8, Indirect_Y)
    }),

    SAX(new InstructionWrap[]{
            InstructionWrap.create((byte) 0x87, 2, 3, ZeroPage),
            InstructionWrap.create((byte) 0x97, 2, 4, ZeroPage_Y),
            InstructionWrap.create((byte) 0x8f, 3, 4, Absolute),
            InstructionWrap.create((byte) 0x83, 2, 6, Indirect_X),
    }),


    NOP_S(new InstructionWrap[]{
            InstructionWrap.create(int8(0x1A), 1, 2, Implied),
            InstructionWrap.create(int8(0x3A), 1, 2, Implied),
            InstructionWrap.create(int8(0x5A), 1, 2, Implied),
            InstructionWrap.create(int8(0x7A), 1, 2, Implied),
            InstructionWrap.create(int8(0xDA), 1, 2, Implied),
            InstructionWrap.create(int8(0xFA), 1, 2, Implied),
            InstructionWrap.create(int8(0x80), 2, 2, Immediate),
            InstructionWrap.create(int8(0x82), 2, 2, Immediate),
            InstructionWrap.create(int8(0x89), 2, 2, Immediate),
            InstructionWrap.create(int8(0xC2), 2, 2, Immediate),
            InstructionWrap.create(int8(0xE2), 2, 2, Immediate),
            InstructionWrap.create(int8(0x04), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x44), 2, 3, ZeroPage),
            InstructionWrap.create(int8(0x64), 2, 3, ZeroPage_X),
            InstructionWrap.create(int8(0x14), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x34), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x54), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x74), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0xD4), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0xF4), 2, 4, ZeroPage_X),
            InstructionWrap.create(int8(0x0C), 3, 4, Absolute),
            InstructionWrap.create(int8(0x1C), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x3C), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x5C), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0x7C), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0xDC), 3, 4, Absolute_X),
            InstructionWrap.create(int8(0xFC), 3, 4, Absolute_X),
    });

    private final InstructionWrap wrap;
    private final InstructionWrap[] wraps;

    Instruction(InstructionWrap wrap, InstructionWrap[] wraps) {
        this.wrap = wrap;
        this.wraps = wraps;
        if (this.wrap != null) {
            this.wrap.setInstruction(this);
        } else {
            Arrays.stream(this.wraps).forEach(it -> it.setInstruction(this));
        }
    }

    Instruction(byte openCode, int size, int cycle) {
        this.wrap = new InstructionWrap(openCode, size, cycle, this);
        this.wraps = null;
    }

    Instruction(byte openCode, int size, int cycle, AddressMode mode) {
        this.wrap = new InstructionWrap(openCode, size, cycle, mode);
        this.wrap.setInstruction(this);
        this.wraps = null;
    }

    Instruction(InstructionWrap[] instruction6502s) {
        this(null, instruction6502s);
    }

    Instruction(InstructionWrap instruction6502) {
        this(instruction6502, null);
    }

    public static InstructionWrap getInstance(byte openCode) {
        for (Instruction value : values()) {
            var parent = value.wrap;
            if (parent != null || value.wraps == null) {
                if (parent != null && parent.getOpenCode() == openCode) {
                    return parent;
                }
                continue;
            }
            for (InstructionWrap instruction6502 : value.wraps) {
                if (instruction6502.getOpenCode() == openCode) {
                    return instruction6502;
                }
            }
        }
        throw new RuntimeException("Illegal open code:0x" + Integer.toHexString(openCode & 0xff));
    }
}
