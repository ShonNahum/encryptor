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
    final private inputHandler inputhandler;


    public CipherHandler(Caesar caesar, XOR xor, Multiplication multiplication, inputHandler inputhandler) {
        this.caesar = caesar;
        this.xor = xor;
        this.multiplication = multiplication;
        this.inputhandler = inputhandler;
    }

    public String dataProcessor(Map<String,String> userSelection, String beforeData) throws SelectionException {
        if ("REVERSE".equals(userSelection.get("ALGORITHM"))){
            userSelection.put("ALGORITHM", inputhandler.algorithmSelection());
            if ("ENCRYPT".equals(userSelection.get("MODE"))) {
                userSelection.put("MODE","DECRYPT");
            } else {
                userSelection.put("MODE","ENCRYPT");
            }
        }

        if ("DECRYPT".equals(userSelection.get("MODE"))){
            userSelection.put("DECRYPT_KEY", String.valueOf(inputhandler.decryptKeySelection()));
        }
        final Map<String, Cipher> algorithms = Map.of(
                "CAESAR", caesar,
                "XOR", xor,
                "MULTIPLICATION", multiplication
        );

        String modeSelection = userSelection.get("MODE");
        Cipher algorithmSelection = algorithms.get(userSelection.get("ALGORITHM"));
        if (null == algorithmSelection) {
            throw new IllegalArgumentException("Invalid algorithm: " + userSelection.get("ALGORITHM"));
        }
        long startTimer = TimerHandler.start();
        String newData = switch (modeSelection) {
            case "ENCRYPT" -> algorithmSelection.encrypt(beforeData);
            case "DECRYPT" -> algorithmSelection.decrypt(beforeData, Integer.parseInt(userSelection.get("DECRYPT_KEY")));
            default -> throw new IllegalArgumentException("Invalid mode: " + modeSelection);
        };
        long stopTimer = TimerHandler.stop();
        TimerHandler.getDurationMillis(startTimer,stopTimer);
        return newData;

    }

}

