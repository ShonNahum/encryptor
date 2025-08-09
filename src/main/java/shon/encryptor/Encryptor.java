package shon.encryptor;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.menus.GeneralMenu;
import shon.encryptor.utils.ConsolePrompt;

import java.util.HashMap;
import java.util.Map;


public class Encryptor {
    // make it my main (global singleton) so everyone can pull from this the instances
    // make this singleton and if everyone i want something, i can call it from this class.
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final Multiplication multiplication = new Multiplication();
    private final GeneralMenu generalMenu = new GeneralMenu(caesar,xor,multiplication);

    public void start() throws Throwable {
        do {
            String filePath = filePathSelector(consolePrompt);
            generalMenu.start(userSelector(consolePrompt),filePath);
        } while (true);
    }

    private String filePathSelector(ConsolePrompt consolePrompt){
        System.out.println("Please enter filepath");
        return consolePrompt.string();
    }

    private Map<String,String> userSelector(ConsolePrompt consolePrompt) {
        Map<String, String> userSelection = new HashMap<>();
        userSelection.put("MODE",modeSelection(consolePrompt));
        userSelection.put("ALGORITHM",algorithmSelection(consolePrompt));
        return userSelection;
    }

    private String modeSelection(ConsolePrompt consolePrompt){
        String modeInput = generalMenu.modeSelection(consolePrompt).toUpperCase();
        String modeSelector = switch (modeInput)
        {
            case "ENCRYPT", "DECRYPT" -> modeInput;
            case "EXIT" ->
            {
                System.exit(0);
                yield "";
            }
            default ->
            {
                System.out.println("Please enter appropriate mode ");
                yield "";
            }
        };
        return modeSelector;
    }

    private String algorithmSelection(ConsolePrompt consolePrompt){
        String algorithmInput = generalMenu.algorithmSelection(consolePrompt).toUpperCase();
        String algorithmSelector = switch (algorithmInput)
        {
            case "CAESAR", "XOR","REVERSE","MULTIPLICATION" -> algorithmInput;
            default ->
            {
                System.out.println("Please enter appropriate algorithm ");
                yield "";
            }
        };
        return algorithmSelector;
    }



}
