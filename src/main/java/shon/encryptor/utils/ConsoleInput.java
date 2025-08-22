package shon.encryptor.utils;
import java.util.Scanner;

public final class ConsoleInput {
    private static final ConsoleInput instance = new ConsoleInput();
    private final Scanner prompt;

    private ConsoleInput() {
        this.prompt = new Scanner(System.in);
    }

    public static ConsoleInput getInstance() {
        return instance;
    }

    public String string() {
        return prompt.nextLine();
    }
}
