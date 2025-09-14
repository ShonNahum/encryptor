package shon.encryptor.abstracts;

import shon.encryptor.exceptions.CipherException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.Constants;
import shon.encryptor.utils.ConvertHandler;
import shon.encryptor.utils.TimerHandler;

public abstract class AbstractCipher implements Cipher {

    protected abstract byte[] logic(byte[] data, Object key, String mode);
    protected abstract Object generateKey();

    @Override
    public byte[] encrypt(byte[] data) {
        System.out.println("Starting Encryption....");
        long startTimer = TimerHandler.start();

        Object key = generateKey();
        System.out.printf("The encryption key is %s%n", key);
        byte[] result = logic(data, key, Constants.ENCRYPT);
        long stopTimer = TimerHandler.stop();
        double duration = TimerHandler.getDurationMillis(startTimer, stopTimer);
        System.out.printf("Encryption Finished and took %.2f ms%n", duration);

        return result;
    }

    @Override
    public byte[] decrypt(byte[] data, String decryptKey) throws CipherException {
        System.out.println("Starting Decryption....");
        long startTimer = TimerHandler.start();

        Object key = parseKey(decryptKey);
        byte[] result = logic(data, key, Constants.DECRYPT);

        long stopTimer = TimerHandler.stop();
        double duration = TimerHandler.getDurationMillis(startTimer, stopTimer);
        System.out.printf("Decryption Finished and took %.2f ms%n", duration);
        return result;
    }

    protected Object parseKey(String key) throws CipherException { // default is int; override for other type of key
        try {
            return ConvertHandler.StringToInt(key);
        } catch (NumberFormatException e) {
            throw new CipherException(e.getMessage());
        }
    }
}
