package shon.encryptor.utils;
import java.util.Scanner;

public final class ConsolePrompt {
    private static final ConsolePrompt instance = new ConsolePrompt();
    private final Scanner prompt;

    // Private constructor
    private ConsolePrompt() {
        this.prompt = new Scanner(System.in);
    }

    // Singleton accessor
    public static ConsolePrompt getInstance() {
        return instance;
    }

    public String string() {
        return prompt.nextLine();
    }




}
