package shon.encryptor.utils;

import shon.encryptor.interfaces.Timer;

public class TimerHandler implements Timer { // overkill , its the only Timer no need interface for that
    @Override // can be static BUT also can be object and instance for every class, and no need to get start and stop time in the class, just active the function
    public long start() {
        return System.nanoTime();
    }

    @Override
    public long stop() {
        return System.nanoTime();
    }

    @Override
    public double getDurationMillis(long startTime, long stopTime)
        final double oneMillion = 1_000_000.0;
        return (stopTime - startTime) /  oneMillion;
    }
}
