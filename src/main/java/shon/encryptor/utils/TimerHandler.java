package shon.encryptor.utils;

public class TimerHandler {
    public static long start() {
        return System.nanoTime();
    }

    public static long stop() {
        return System.nanoTime();
    }

    public static double getDurationMillis(long startTime, long stopTime) {
        double durationMs = (stopTime - startTime) / 1_000_000.0;
        System.out.printf("%nThe process took: %.2f ms%n", durationMs);
        return durationMs;
    }
}
