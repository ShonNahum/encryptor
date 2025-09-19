package shon.encryptor.cipher;
import shon.encryptor.cipher.algorithms.Caesar;
import shon.encryptor.cipher.algorithms.Multiplication;
import shon.encryptor.cipher.algorithms.XOR;
import shon.encryptor.constants.Constants;
import shon.encryptor.conveters.ConvertHandler;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.IO.UserSelection;

import java.util.HashMap;
import java.util.Map;

import static shon.encryptor.math.MathHandler.divideByByte;


public class CipherHandler {
    private final UserSelection userSelection;



    public CipherHandler(UserSelection userSelection) {
        this.userSelection = userSelection;
    }

    public int multiplicationDecryptKey(String encryptkey) {
        return divideByByte(ConvertHandler.StringToInt(encryptkey));
    }

    public Map<String,String> reverseAlgoValidator(String algorithm,String mode) throws SelectionException {
        Map<String,String> selection = new HashMap<>();
        selection.put("ALGORITHM",algorithm);
        selection.put("MODE",mode);

        while(Constants.REVERSE.equals(selection.get("ALGORITHM"))) {
            selection.put("ALGORITHM",userSelection.chooseAlgorithm());
            if (Constants.ENCRYPT.equals(selection.get("MODE"))) {
                selection.put("MODE",Constants.DECRYPT);
            } else {
                selection.put("MODE",Constants.ENCRYPT);
            }
        }
        return selection;
    }

    public byte[] dataProcessor(String algorithm , String mode, byte[] fileData,String decryptKey) throws CipherException {
        Cipher cipher = getCipher(algorithm);
        return switch (mode) {
            case Constants.ENCRYPT -> cipher.encrypt(fileData);
            case Constants.DECRYPT -> cipher.decrypt(fileData, decryptKey);
            default -> throw new CipherException("Invalid mode: " + mode);
        };
    }

    private Cipher getCipher(String algorithm) throws CipherException {
        return switch (algorithm) {
            case Constants.CAESAR -> new Caesar();
            case Constants.XOR -> new XOR();
            case Constants.MULTIPLICATION -> new Multiplication();
            default -> throw new CipherException("Invalid algorithm: " + algorithm);
        };
    }

}

