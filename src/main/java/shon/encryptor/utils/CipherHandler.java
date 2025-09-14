package shon.encryptor.utils;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.interfaces.Cipher;

import java.util.Map;

public class CipherHandler {
    private final Map<String, Cipher> algorithms;



    public CipherHandler() {
        this.algorithms = Map.of( // no need all 3, one is enough
                Constants.CAESAR, new Caesar(),
                Constants.XOR, new XOR(),
                Constants.MULTIPLICATION, new Multiplication()
        );
    }

    public byte[] dataProcessor(String mode ,String algorithm, byte[] fileData,String decryptKey) throws CipherException {
        Cipher cipher = getCipher(algorithm);
        return switch (mode) {
            case Constants.ENCRYPT -> cipher.encrypt(fileData);
            case Constants.DECRYPT -> cipher.decrypt(fileData, decryptKey);
            default -> throw new CipherException("Invalid mode " + mode);

        };
    }

    private Cipher getCipher(String algorithm) throws CipherException { // complex, maybe enum better
        Cipher cipher = algorithms.get(algorithm);
        if (cipher == null) {
            throw new CipherException("Invalid algorithm: " + algorithm);
        }
        return cipher;
    }

}

