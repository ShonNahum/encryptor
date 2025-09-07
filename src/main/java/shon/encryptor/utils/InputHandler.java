package shon.encryptor.utils;

import shon.encryptor.exceptions.SelectionException;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private final Scanner input = new Scanner(System.in);

    private String readOption(List<String> validOptions) throws SelectionException {
        String value = input.nextLine().toUpperCase();
        if (!validOptions.contains(value)) {
            throw new SelectionException("Invalid Option" + ": " + value);
        }
        return value;
    }

    public String modeInput() throws SelectionException {
        return readOption(List.of(Constants.ENCRYPT, Constants.DECRYPT, Constants.EXIT));
    }

    public String algorithmInput() throws SelectionException {
        return readOption(List.of(Constants.CAESAR, Constants.XOR, Constants.REVERSE, Constants.MULTIPLICATION));
    }

    public String stringInput() {
        return input.nextLine();
    }
}
