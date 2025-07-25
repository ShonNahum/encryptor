package shon.encryptor;
import java.util.Scanner;

public class Inputs {
    private final Scanner input; // different value for each object,need create object to use.
    private static Inputs instance;

    public static Inputs getInstance() {
        if (instance == null) {
            instance = new Inputs();
        }
        return instance;
    }

    public Inputs() { // private constructor to prevent new instance
        input = new Scanner(System.in);
    }

    public String stringInput() {
        return input.nextLine();
    }
}
