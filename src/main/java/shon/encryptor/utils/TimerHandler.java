package shon.encryptor.utils;

public class TimerHandler { // overkill , its the only Timer no need interface for that
    public static long start() {
        return System.nanoTime();
    }

    public static long stop() {
        return System.nanoTime();
    }

    public static double getDurationMillis(long startTime, long stopTime){
        final double oneMillion = 1_000_000.0;
        return (stopTime - startTime) /  oneMillion;
    }
}
