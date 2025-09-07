package shon.encryptor.utils;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.interfaces.Cipher;

import java.util.Map;

public class CipherHandler {
    private final Map<String, Cipher> algorithms;



    public CipherHandler(Caesar caesar, XOR xor, Multiplication multiplication) {
        this.algorithms = Map.of(
                Constants.CAESAR, caesar,
                Constants.XOR, xor,
                Constants.MULTIPLICATION, multiplication
        );
    }

    public String dataProcessor(String mode ,String algorithm, String fileData,String decryptKey) throws CipherException {
        Cipher cipher = getCipher(algorithm);
        long startTimer = TimerHandler.start();
        String result = switch (mode) {
            case Constants.ENCRYPT -> cipher.encrypt(fileData);
            case Constants.DECRYPT -> cipher.decrypt(fileData, decryptKey);
            default -> throw new CipherException("Invalid mode " + mode);

        };
        long stopTimer = TimerHandler.stop();
        TimerHandler.getDurationMillis(startTimer,stopTimer);
        return result;
    }

    private Cipher getCipher(String algorithm) throws CipherException {
        Cipher cipher = algorithms.get(algorithm.toUpperCase());
        if (cipher == null) {
            throw new CipherException("Invalid algorithm: " + algorithm);
        }
        return cipher;
    }

}

