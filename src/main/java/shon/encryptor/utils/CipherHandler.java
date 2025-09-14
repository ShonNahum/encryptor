package shon.encryptor.utils;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.menus.UserSelection;


public class CipherHandler {
    private final UserSelection userSelection;



    public CipherHandler(UserSelection userSelection) {
        this.userSelection = userSelection;
    }

    public String[] reverseAlgoValidator(String algorithm,String mode) throws SelectionException {
        while(Constants.REVERSE.equals(algorithm)) {
            algorithm = userSelection.chooseAlgorithm();
            if (Constants.ENCRYPT.equals(mode)) {
                mode = Constants.DECRYPT;
            } else {
                mode = Constants.ENCRYPT;
            }
        }
        return new String[] { algorithm, mode };
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

