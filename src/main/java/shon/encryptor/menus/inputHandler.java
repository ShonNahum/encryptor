package shon.encryptor.menus;

import shon.encryptor.exceptions.SelectionException;

import java.util.*;



public class inputHandler extends InputValidation  {
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


    public String filePathInput()  {
        return input.nextLine();
    }


    public int decryptKeyInput() throws SelectionException {
        try {
            System.out.println("Enter decryption key");
            return Integer.parseInt(input.nextLine());
        } catch (NoSuchElementException | IllegalStateException e){
            throw new SelectionException("Failed to read decryption key",e);

        }
    }

}
