package shon.encryptor.utils;

public  class MathHandler {


    public static int alwaysOdd(int number){
        if (number % 2 == 0){
            return number + 1;
        }
        return number;
    }
    public static double divideByByte(byte numerator,double denominator ){
        return numerator / denominator;
    }
}
