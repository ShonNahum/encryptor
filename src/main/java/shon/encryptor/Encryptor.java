package shon.encryptor;
import shon.encryptor.abstracts.CipherProcess;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.menus.Menu;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.FileIO;
import java.util.HashMap;
import java.util.Map;


public class Encryptor {
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private final FileIO fileIO = FileIO.getInstance();
    private final Caesar caesar = new Caesar(consolePrompt,fileIO);
    private final XOR xor = new XOR(consolePrompt,fileIO);
    private final Multiplication multiplication = new Multiplication(consolePrompt,fileIO);
    private final Menu generalMenu = new Menu(caesar,xor,multiplication);
    private String filePath;

    public void start() throws Throwable {
        do {
            generalMenu.start(userSelector(),filePath);
        } while (true);
    }

    private Map<String,String> userSelector() {
        Map<String, String> userSelection = new HashMap<>();
        userSelection.put("MODE",modeSelection(consolePrompt));
        userSelection.put("ALGORITHM",algorithmSelection(consolePrompt));
        filePath = fileIO.filePathSelector(consolePrompt);
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
