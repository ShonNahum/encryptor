package shon.encryptor.utils;

import shon.encryptor.interfaces.Timer;

public class TimerHandler implements Timer {
    @Override
    public long start() {
        return System.nanoTime();
    }

    @Override
    public long stop() {
        return System.nanoTime();
    }

    @Override
    public double getDurationMillis(long startTime, long stopTime) {
        final double oneMillion = 1_000_000.0;
        return (stopTime - startTime) /  oneMillion;
    }
}
