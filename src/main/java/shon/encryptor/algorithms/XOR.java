package shon.encryptor.algorithms;

import shon.encryptor.exceptions.CipherException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.ConvertHandler;


import static shon.encryptor.utils.MathHandler.generateRandomNumber;

public class XOR implements Cipher {


    @Override
    public String encrypt(String data) {
        final int BYTE_RANGE = 256;
        byte key = (byte) generateRandomNumber(BYTE_RANGE);
        System.out.printf("%nthe key is %d%n" ,key);
        return XORLogic(data, key);
    }

    @Override
    public String decrypt(String data, String decryptKey) throws CipherException {
        try {
            int key = ConvertHandler.StringToInt(decryptKey);
            return XORLogic(data, (byte) key);
        } catch (NumberFormatException e) {
            throw new CipherException("Invalid decrypt key: " + e.getMessage());
        }
    }

    private String XORLogic(String data, byte key) {
        StringBuilder result = new StringBuilder();
        for (char ch : data.toCharArray()) {
            result.append((char) (ch ^ key));
        }
        return result.toString();
    }
}
