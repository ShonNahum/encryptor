package shon.encryptor.menus;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.TimerHandler;
import java.util.Map;

public class CipherHandler {
    final private Caesar caesar;
    final private XOR xor;
    final private Multiplication multiplication;
    final private Selection selection;
    final private InputHandler inputHandler;

    public CipherHandler(Caesar caesar, XOR xor, Multiplication multiplication, Selection selection,InputHandler inputHandler) {
        this.caesar = caesar;
        this.xor = xor;
        this.multiplication = multiplication;
        this.selection = selection;
        this.inputHandler = inputHandler;
    }

    public String dataProcessor(Map<String,String> userSelection, String beforeData) {
        // Handle Reverse Algorithm
        if ("REVERSE".equals(userSelection.get("ALGORITHM"))){
            userSelection.put("ALGORITHM", selection.getAlgorithm());
            if ("ENCRYPT".equals(userSelection.get("MODE"))) {
                userSelection.put("MODE","DECRYPT");
            } else {
                userSelection.put("MODE","ENCRYPT");
            }
        }
        String modeSelection = userSelection.get("MODE");


        if ("DECRYPT".equals(modeSelection)){
            userSelection.put("DECRYPT_KEY", selection.getDecryptKey());
        }
        final Map<String, Cipher> algorithms = Map.of(
                "CAESAR", caesar,
                "XOR", xor,
                "MULTIPLICATION", multiplication
        );
        Cipher algorithmSelection = algorithms.get(userSelection.get("ALGORITHM"));


        long startTimer = TimerHandler.start();
        String newData = switch (modeSelection) {
            case "ENCRYPT" -> algorithmSelection.encrypt(beforeData);
            case "DECRYPT" -> algorithmSelection.decrypt(beforeData, userSelection.get("DECRYPT_KEY")));
            default -> throw new IllegalArgumentException("Invalid mode: " + modeSelection);
        };
        long stopTimer = TimerHandler.stop();
        TimerHandler.getDurationMillis(startTimer,stopTimer);
        return newData;

    }

}

