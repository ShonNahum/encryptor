package shon.encryptor.menus;

import shon.encryptor.abstracts.ABMenu;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.SelectionException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Selection extends ABMenu {
    final private ConsolePrompt consolePrompt;

    public Selection(ConsolePrompt consolePrompt) {
        this.consolePrompt = consolePrompt;
    }

    public Map<String,String> user() throws SelectionException {
        Map<String, String> userSelection = new HashMap<>();
        try {
            userSelection.put("MODE", mode());
            userSelection.put("ALGORITHM", algorithm());
        } catch (SelectionException e) {
            throw new SelectionException("invalid");
        }
        return userSelection;
    }


    private String algorithm() throws SelectionException {
        List<String> algorithmMenu = List.of("Caesar", "XOR", "Reverse", "Multiplication");
        printMode(algorithmMenu,"Algorithm");

        String algorithmInput = consolePrompt.string().toUpperCase();
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

        String modeInput = consolePrompt.string().toUpperCase();
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
