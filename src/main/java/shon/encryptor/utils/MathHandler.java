package shon.encryptor.utils;

public class MathHandler {
    private static final MathHandler instance = new MathHandler(); // can be static so behave like math library

    private MathHandler() {
    }

    public static MathHandler getInstance() {
        return instance;
    }

    public int alwaysOdd(int number){
        return number * 2 + 1;
    }
    public double divideByByte(byte numerator,double denominator ){
        return numerator / denominator;
    }
}
