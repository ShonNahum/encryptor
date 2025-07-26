package shon.encryptor.generators;


import java.util.Random;

public class KeyGenerator {
    public int generateKey() {
        Random rand = new Random();
        int number = rand.nextInt(20);
        System.out.print("the key is " + number + "\n");
        return number;
    }

}
