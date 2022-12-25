package cn.navclub.nes4j.bin.apu;

/**
 * Divider implement
 *
 * @author <a href="https://github.com/GZYangKui">GZYangKui</a>
 */
public class Divider extends Timer {
    private boolean output;

    public Divider() {
        super(null);
    }

    public boolean output() {
        var temp = this.output;
        if (temp) {
            this.output = false;
        }
        return temp;
    }

    @Override
    public void tick() {
        this.counter--;
        //Reset divider and clock
        if (this.counter == 0) {
            this.reset();
            this.output = true;
        }
    }

    public void reset() {
        this.output = false;
        this.counter = this.period;
    }
}
