package shon.encryptor.utils;
import java.util.Scanner;

public final class ConsolePrompt {
    private static final ConsolePrompt instance = new ConsolePrompt();
    private final Scanner prompt;

    private ConsolePrompt() {
        this.prompt = new Scanner(System.in);
    }

    public static ConsolePrompt getInstance() {
        return instance;
    }

    public String string() {
        return prompt.nextLine();
    }




}
