package shon.encryptor.utils;

import java.util.Random;

public class KeyGenerator {

    public int randomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(10);
        System.out.print("the number is " + number + "\n");
        return number;
    }


}



