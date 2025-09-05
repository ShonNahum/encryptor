package shon.encryptor.menus;

import shon.encryptor.exceptions.SelectionException;

import java.util.*;



public class InputHandler {
    private final Scanner input = new Scanner(System.in);


    public String modeInput() throws SelectionException {
        String mode = switch (input.nextLine().toUpperCase()) {
            case "ENCRYPT" -> "ENCRYPT";
            case "DECRYPT" -> "DECRYPT";
            case "EXIT" -> "EXIT";
            default -> throw new SelectionException("Invalid mode Input");
        };
        return mode;
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
