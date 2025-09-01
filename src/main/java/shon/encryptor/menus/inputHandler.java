package shon.encryptor.menus;

import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.exceptions.SelectionException;

import java.util.*;

import static java.lang.System.exit;


public class inputHandler extends MenuPrinter {
    private final Scanner input = new Scanner(System.in);
    private final  Map<String, String> userSelection = new HashMap<>();


    public Map<String,String> userSelections() throws SelectionException {
        try {
            userSelection.put("MODE", modeSelection());
            userSelection.put("FILE_PATH",fileSelection());
            userSelection.put("ALGORITHM", algorithmSelection());

            if ("REVERSE".equals(userSelection.get("ALGORITHM"))){
                userSelection.put("ALGORITHM", algorithmSelection());
                if ("ENCRYPT".equals(userSelection.get("MODE"))) {
                    userSelection.put("MODE","DECRYPT");
                } else {
                    userSelection.put("MODE","ENCRYPT");
                }
            }
            DecryptValidation(userSelection);

        } catch (SelectionException | NumberFormatException e ) {
            System.out.println(e);
            throw new SelectionException(e.getMessage());
        }
        return userSelection;
    }
    public Map<String,String> DecryptValidation(Map<String,String> userSelection) throws SelectionException {
        if ("DECRYPT".equals(userSelection.get("MODE"))){
            userSelection.put("DECRYPT_KEY",decryptKeySelection());
            int NumberValidation = Integer.parseInt(userSelection.get("DECRYPT_KEY"));
        }
        return userSelection;
    }

    public String modeSelection() throws SelectionException {
        List<String> ModeMenu = List.of("Encrypt", "Decrypt", "Exit");
        printMode(ModeMenu, "Modes");
        try {
            String modeInput = input.nextLine().toUpperCase();
            String modeSelector = switch (modeInput) {
                case "ENCRYPT", "DECRYPT" -> modeInput;
                case "EXIT" -> {
                    exit(0);
                    yield "";
                }
                default -> throw new SelectionException("Invalid mode input");

            };
            return modeSelector;
        } catch (NoSuchElementException | IllegalStateException | SelectionException e) {
            throw new SelectionException(e.getMessage());
    }
    }

    public String algorithmSelection() throws SelectionException {
        List<String> algorithmMenu = List.of("Caesar", "XOR", "Reverse", "Multiplication");
        printMode(algorithmMenu,"Algorithm");
        try {
            String algorithmInput = input.nextLine().toUpperCase();
            String algorithmSelector = switch (algorithmInput) {
                case "CAESAR", "XOR", "REVERSE", "MULTIPLICATION" -> algorithmInput;
                default -> throw new SelectionException("Invalid algorithm input");
            };
            return algorithmSelector;
        } catch (NoSuchElementException | IllegalStateException | SelectionException e) {
            throw new SelectionException(e.getMessage());
        }
    }


    private String decryptKeySelection() throws SelectionException {
        try {
            System.out.println("Enter decryption key");
            return input.nextLine();
        } catch (NoSuchElementException | IllegalStateException e){
            throw new SelectionException("Failed to read decryption key",e);

        }
    }

    private String fileSelection() throws SelectionException {
        try {
            System.out.println("Please enter filepath");
            return input.nextLine();
        } catch (NoSuchElementException | IllegalStateException e){
            throw new SelectionException("Failed to read file path", e);
        }
    }
}
