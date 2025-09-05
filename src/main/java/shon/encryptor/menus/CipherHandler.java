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


    public CipherHandler(Caesar caesar, XOR xor, Multiplication multiplication, Selection selection) {
        this.caesar = caesar;
        this.xor = xor;
        this.multiplication = multiplication;
        this.selection = selection;
    }

    public String dataProcessor(String modeSelection ,String algorithm, String beforeData) throws SelectionException {
        String decryptKey = "";
        final  Map<String, Cipher> algorithms = Map.of(
                Constants.CAESAR, caesar,
                Constants.XOR, xor,
                Constants.MULTIPLICATION, multiplication
        );

        // Handle Reverse Algorithm
        if ("REVERSE".equals(algorithm)){
             algorithm = selection.setAlgorithm();
            if (Constants.ENCRYPT.equals(modeSelection)) {
                modeSelection = Constants.DECRYPT;
            } else {
                modeSelection = Constants.ENCRYPT;
            }
        }

        if (Constants.DECRYPT.equals(modeSelection)){
            decryptKey = selection.getDecryptKey();
        }

        Cipher algorithmSelection = algorithms.get(algorithm);
        long startTimer = TimerHandler.start();
        String newData = switch (modeSelection) {
            case Constants.ENCRYPT -> algorithmSelection.encrypt(beforeData);
            case Constants.DECRYPT -> algorithmSelection.decrypt(beforeData, decryptKey);
            default -> null;
        };
        long stopTimer = TimerHandler.stop();
        TimerHandler.getDurationMillis(startTimer,stopTimer);
        return newData;

    }

}

