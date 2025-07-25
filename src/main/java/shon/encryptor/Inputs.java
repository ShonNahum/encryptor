package shon.encryptor;
import java.util.Scanner;

public class Inputs {
    private final Scanner input; // different value for each object,need create object to use.
    private static Inputs instance;

    private Inputs(){ // private constructor to prevent new instance
        input = new Scanner(System.in);

    }

    public static Inputs getInstance() {
        if (instance == null) {
            instance = new Inputs();
        }
        return instance;
    }

    public String stringInput() {
        return input.nextLine();
    }
}
