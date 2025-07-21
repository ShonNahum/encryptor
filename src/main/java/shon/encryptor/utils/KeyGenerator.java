package shon.encryptor.utils;
import java.util.Random;


public class KeyGenerator {
    private static KeyGenerator instance; // static = class variable, not object!

    private KeyGenerator(){}

    public static KeyGenerator GetInstance() {
        if (instance == null) {
            instance = new KeyGenerator();
        }
        return instance;
}

    public int randomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(10);
        System.out.print("the number is " + number + "\n");

        return number;
    }


}



