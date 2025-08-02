package shon.encryptor.interfaces;

public interface Timer {
    long start();
    long stop();
    double getDurationMillis(long startTime, long stopTime);
}
