package book.jungsuk.ch07;

public class TVCR extends Tv2 implements IVCR {
    VCR vcr = new VCR();

    public void play() {
        vcr.play();
    }

    public void stop() {
        vcr.stop();
    }

    public void reset() {
        vcr.reset();
    }

    public int getCounter() {
        return vcr.getCounter();
    }

    public void setCounter(int c) {
        vcr.setCounter(c);
    }

}

class Tv2 {
    protected boolean power;
    protected int channel;
    protected int volume;

    public void power() {
        power = !power;
    }

    public void channelUp() {
        channel++;
    }

    public void channelDown() {
        channel--;
    }

    public void volumeUp() {
        volume++;
    }

    public void volumeDown() {
        volume--;
    }
}
class VCR {
    protected int counter;

    public void play() {
    }

    public void stop() {

    }

    public void reset() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int c) {
        counter = c;
    }
}

interface IVCR {
    void play();

    void stop();

    void reset();

    int getCounter();

    void setCounter(int c);
}

