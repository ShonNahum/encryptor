package shon.encryptor.timers;

public class TimerHandler {
    public static long start() {
        return System.nanoTime();
    }

    public static long stop() {
        return System.nanoTime();
    }

    public static double getDurationMillis(long startTime, long stopTime) {
        double durationMs = (stopTime - startTime) / 1_000_000.0;
        return durationMs;
    }
}
