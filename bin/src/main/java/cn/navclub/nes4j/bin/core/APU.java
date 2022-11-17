package cn.navclub.nes4j.bin.core;

import cn.navclub.nes4j.bin.NESystemComponent;
import cn.navclub.nes4j.bin.apu.Channel;
import cn.navclub.nes4j.bin.apu.FrameCounter;
import cn.navclub.nes4j.bin.enums.ChannelType;

/**
 * <a href="https://www.nesdev.org/wiki/APU">APU Document</a>
 */
public class APU implements NESystemComponent {
    private final SRegister status;
    private final Channel pulse0;
    private final Channel pulse1;
    private final Channel triangle;
    private final Channel noise;
    private final Channel dmc;
    private final FrameCounter frameCounter;

    public APU() {
        this.status = new SRegister();
        this.frameCounter = new FrameCounter();
        this.dmc = new Channel(ChannelType.DMC);
        this.noise = new Channel(ChannelType.NOISE);
        this.pulse0 = new Channel(ChannelType.PULSE);
        this.pulse1 = new Channel(ChannelType.PULSE1);
        this.triangle = new Channel(ChannelType.TRIANGLE);
    }

    @Override
    public void write(int address, byte b) {
        if (address == 0x4015) {
            this.status.setBits(b);
        }

        if (address >= 0x4000 && address <= 0x4003) {
            this.pulse0.update(address, b);
        }

        if (address >= 0x4004 && address <= 0x4007) {
            this.pulse1.update(address, b);
        }

        if (address >= 0x4008 && address <= 0x400B) {
            this.triangle.update(address, b);
        }

        if (address >= 0x400c && address <= 0x400f) {
            this.noise.update(address, b);
        }
        if (address >= 0x4010 && address <= 0x4013) {
            this.dmc.update(address, b);
        }
        if (address == 0x4017) {
            this.frameCounter.write(address, b);
        }
    }

    @Override
    public byte read(int address) {
        return this.status.bits;
    }

    @Override
    public void tick(int cycle) {
        this.frameCounter.tick(cycle);
    }
}
