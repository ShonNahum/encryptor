package shon.encryptor.utils;
import java.util.Scanner;

public final class ScannerPrompt {
    private static final ScannerPrompt instance = new ScannerPrompt();
    private final Scanner prompt;

    // Private constructor
    private ScannerPrompt() {
        this.prompt = new Scanner(System.in);
    }

    // Singleton accessor
    public static ScannerPrompt getInstance() {
        return instance;
    }

    public String string() {
        return prompt.nextLine();
    }




}
