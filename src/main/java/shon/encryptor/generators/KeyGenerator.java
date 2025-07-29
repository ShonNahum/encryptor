package shon.encryptor.generators;


import java.util.Random;

public class KeyGenerator {
    public int generateKey() {
        int number = new Random().nextInt(20);
        // in java 24 System.out.println(STR."the key is {number}\n");
        // in java 8 System.out.print("the key is " + number + "\n");
        // in java 17
        System.out.printf("the key is %s \n", number);
        return number;
    }

}
