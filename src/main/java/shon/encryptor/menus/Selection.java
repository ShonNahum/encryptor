package shon.encryptor.menus;

import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.utils.ConsoleInput;
import shon.encryptor.exceptions.SelectionException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Selection extends MenuPrinter {
    final private ConsoleInput consoleInput;

    public Selection(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public Map<String,String> user() throws SelectionException {
        Map<String, String> userSelection = new HashMap<>();
        try {
            userSelection.put("MODE", mode());
            userSelection.put("ALGORITHM", algorithm());
        } catch (SelectionException e) {
            throw new SelectionException("User selection error: ",e);
        }
        return userSelection;
    }


    public String algorithm() throws SelectionException {
        List<String> algorithmMenu = List.of("Caesar", "XOR", "Reverse", "Multiplication");
        printMode(algorithmMenu,"Algorithm");

        String algorithmInput = consoleInput.string().toUpperCase();
        String algorithmSelector = switch (algorithmInput)
        {
            case "CAESAR", "XOR","REVERSE","MULTIPLICATION" -> algorithmInput;
            default -> throw new SelectionException("Invalid algorithm entered");
        };
        return algorithmSelector;
    }

    private String mode() throws SelectionException {
        List<String> ModeMenu = List.of("Encrypt", "Decrypt", "Exit");
        printMode(ModeMenu,"Modes");

        String modeInput = consoleInput.string().toUpperCase();
        String modeSelector = switch (modeInput)
        {
            case "ENCRYPT", "DECRYPT" -> modeInput;
            case "EXIT" ->
            {
                System.exit(0);
                yield "";
            }
            default -> throw new SelectionException("Invalid mode entered");

        };
        return modeSelector;
    }
}
