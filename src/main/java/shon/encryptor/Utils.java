package shon.encryptor;

import java.util.Random;

public class Utils {
    public int randomKey() {
        Random rand = new Random();
        int number = rand.nextInt(20);
        System.out.print("the number is " + number + "\n");
        return number;
    }

}
