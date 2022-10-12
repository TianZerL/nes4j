package cn.navclub.nes4j.bin.test.impl;

import cn.navclub.nes4j.bin.core.CPU;
import cn.navclub.nes4j.bin.core.registers.CSRegister;
import cn.navclub.nes4j.bin.test.BaseTest;
import cn.navclub.nes4j.bin.util.ByteUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CPUTest extends BaseTest {
    @Test
    void lad() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xA9), 0x11,
        };
        var cpu = createInstance(rpg);
        Assertions.assertEquals(cpu.getRa(), 0x11);
    }

    @Test
    void test_0x69_adc() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xA9), 1,
                ByteUtil.overflow(0x69), 10,
        };
        var cpu = createInstance(rpg);
        Assertions.assertEquals(cpu.getRa(), 11);
    }

    @Test
    void test_0x69_adc_carry_zero_flag() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xA9), ByteUtil.overflow(0x81),
                ByteUtil.overflow(0x69), 0x7f
        };
        var cpu = createInstance(rpg);
        var status = cpu.getStatus();
        Assertions.assertEquals(cpu.getRa(), 0x00);
        Assertions.assertTrue(status.hasFlag(CSRegister.BIFlag.ZF));
        Assertions.assertTrue(status.hasFlag(CSRegister.BIFlag.CF));
        Assertions.assertFalse(status.hasFlag(CSRegister.BIFlag.OF));
    }

    @Test
    void test_0x69_adc_overflow() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xA9), 0x7f,
                ByteUtil.overflow(0x69), 0x7f
        };
        var cpu = this.createInstance(rpg);
        var status = cpu.getStatus();
        Assertions.assertTrue(status.hasFlag(CSRegister.BIFlag.OF));
    }

    @Test
    void test_0xe9_sbc() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xA9), 0x10,
                ByteUtil.overflow(0xE9), 0x02
        };
        var cpu = this.createInstance(rpg);
        Assertions.assertEquals(cpu.getRa(), 0x0d);
    }

    @Test
    void test_0xe9_sbc_carry() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xA9), 0x0A,
                ByteUtil.overflow(0xE9), 0x0B
        };
        var cpu = this.createInstance(rpg);
        Assertions.assertEquals(cpu.getRa(), 0xfe);
    }

    @Test
    void test_0xe9_sbc_negative() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xa9), 0x02,
                ByteUtil.overflow(0xe9), 0x03
        };
        var cpu = this.createInstance(rpg);
        var status = cpu.getStatus();
        Assertions.assertTrue(status.hasFlag(CSRegister.BIFlag.NF));
        Assertions.assertEquals(cpu.getRa(), 0xfe);
    }

    @Test
    void test_0xe9_sbc_overflow() {
        var rpg = new byte[]{
                ByteUtil.overflow(0xa9), 0x50,
                ByteUtil.overflow(0xe9), ByteUtil.overflow(0xb0)
        };
        var cpu = this.createInstance(rpg);
        Assertions.assertEquals(cpu.getRa(), 0x9f);
    }

//    @Test
//    void testNesFile() {
//        var nes = NES.NESBuilder.newBuilder()
//                .file(new File("nes/snow_bros.nes"))
//                .build();
//        nes.execute();
//    }

    CPU createInstance(byte[] rpg) {
        return this.createInstance(rpg, new byte[]{}, 0x8000);
    }
}
