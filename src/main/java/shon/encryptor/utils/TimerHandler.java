package shon.encryptor.utils;

public class TimerHandler {
    public static long start() {
        return System.nanoTime();
    }

    public static long stop() {
        return System.nanoTime();
    }

    public static void getDurationMillis(long startTime, long stopTime){
        final double oneMillion = 1_000_000.0;
        System.out.printf("%nthe process took: %2f ms%n",(stopTime - startTime) /  oneMillion );
    }
}
