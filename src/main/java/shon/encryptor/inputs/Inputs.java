package shon.encryptor.inputs;
import java.util.Scanner;

public final class Inputs {
    private final Scanner input;
    private static Inputs instance;

    private Inputs() { // private constructor to prevent new instance
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
