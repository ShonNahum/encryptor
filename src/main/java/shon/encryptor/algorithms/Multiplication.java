package shon.encryptor.algorithms;

import shon.encryptor.exceptions.CipherException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.ConvertHandler;


import static shon.encryptor.utils.MathHandler.generateOddKey;

public class Multiplication implements Cipher {

    @Override
    public String encrypt(String data) {
        int BYTE_RANGE = 256;
        int key = generateOddKey(BYTE_RANGE);
        System.out.printf("%nthe key is %d%n", key);
        return MultiplicationLogic(data, key);
    }

    @Override
    public String decrypt(String data,String decryptKey) throws CipherException {
        try {
            int key = ConvertHandler.StringToInt(decryptKey);
            return MultiplicationLogic(data,key);
        } catch (NumberFormatException e) {
            throw new CipherException("Invalid decrypt key: " + e.getMessage());
        }
    }


    private String MultiplicationLogic(String data, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : data.toCharArray()) {
            result.append((char)(ch * key));
        }
        return result.toString();
    }
}
