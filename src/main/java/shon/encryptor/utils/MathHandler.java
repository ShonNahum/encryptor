package shon.encryptor.utils;

import java.util.Random;

public class MathHandler {


    public static int alwaysOdd(int range){
        int number;
        do {
            number = new Random().nextInt(range);
        } while (number % 2 != 0);
        return number;
    }
    public static double divideByByte(byte numerator,double denominator ){
        return numerator / denominator;
    }
}
