package shon.encryptor.IO;

import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.constants.Constants;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private static final InputHandler instance = new InputHandler();
    private final Scanner scanner;

    private InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public static InputHandler getInstance() {
        return instance;
    }

    private String readOption(List<String> validOptions) throws SelectionException {
        String value = scanner.nextLine().toUpperCase();
        if (!validOptions.contains(value)) {
            throw new SelectionException("Invalid Option" + ": " + value);
        }
        return value;
    }

    public String mode() throws SelectionException {
        return readOption(List.of(Constants.ENCRYPT, Constants.DECRYPT, Constants.EXIT));
    }

    public String algorithm() throws SelectionException {
        return readOption(List.of(Constants.CAESAR, Constants.XOR, Constants.REVERSE, Constants.MULTIPLICATION));
    }

    public String string() {
        return scanner.nextLine();
    }
}
