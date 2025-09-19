package shon.encryptor.math;

import java.sql.PreparedStatement;
import java.util.Random;

public class MathHandler {
    private static Random random = new Random();



    public static int generateOddKey(int range){
        int number;
        do {
            number = random.nextInt(range);
        } while (number % 2 != 0 || number == 0);
        return number;
    }
    public static int generateRandomNumber(int range){
        return random.nextInt(range);
    }


    public static int divideByByte(int denominator ){
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        int result =  (byte) 1 / denominator;
        return  result;
    }
}
