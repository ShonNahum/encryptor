package shon.encryptor.menus;

import shon.encryptor.exceptions.SelectionException;

import java.util.*;



public class InputHandler {
    private final Scanner input = new Scanner(System.in);


    public String modeInput() throws SelectionException {
        String inputValue = input.nextLine().toUpperCase();
        return switch (inputValue) {
            case "ENCRYPT", "DECRYPT", "EXIT" -> inputValue;
            default -> throw new SelectionException("Invalid mode input: " + inputValue);
        };
    }



    public String algorithmInput() throws SelectionException {
        String algorithm = switch (input.nextLine().toUpperCase()) {
            case "CAESAR" -> "CAESAR";
            case "XOR" -> "XOR";
            case "REVERSE" -> "REVERSE";
            case "MULTIPLICATION" -> "MULTIPLICATION";
            default -> throw new SelectionException("Invalid algorithm input");
        };
        return algorithm;
    }


    public String StringInput()  {
        return input.nextLine();
    }



}
