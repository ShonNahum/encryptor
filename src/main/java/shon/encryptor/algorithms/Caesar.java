package shon.encryptor.algorithms;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.Constants;
import shon.encryptor.utils.ConvertHandler;

import static shon.encryptor.utils.MathHandler.generateRandomNumber;


public final class Caesar implements Cipher{

    @Override
    public String encrypt(String data) { // ADD ABSTRACT FOR IT
        final int SHIFT_RANGE = 20;
        int shiftKey = generateRandomNumber(SHIFT_RANGE);
        System.out.printf("%nthe shift key is %d%n" ,shiftKey);
        return caesarLogic(data, shiftKey, Constants.ENCRYPT);
    }

    @Override
    public String decrypt(String data, String decryptKey) throws CipherException {
        try {
            int key = ConvertHandler.StringToInt(decryptKey);
            return caesarLogic(data, key, Constants.DECRYPT);
        } catch (NumberFormatException e) {
            throw new CipherException("Invalid decrypt key: " + e.getMessage());
        }
    }

    private String caesarLogic(String data, int key, String mode) {
        StringBuilder result = new StringBuilder();
        if (Constants.DECRYPT.equals(mode)) {
            key = -key;
        }
        for (char ch : data.toCharArray()) {
            char shifted = (char) (ch + key);
            result.append(shifted);
        }
        return result.toString();
    }
}


