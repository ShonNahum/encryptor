package shon.encryptor.algorithms;

import shon.encryptor.interfaces.Cipher;
import shon.encryptor.menus.Constants;
import shon.encryptor.utils.ConvertHandler;


import static shon.encryptor.utils.MathHandler.alwaysOdd;

public class Multiplication implements Cipher {

    @Override
    public String encrypt(String beforeData) {
        final int BYTE_RANGE = 10;
        int key = alwaysOdd(BYTE_RANGE);
        System.out.printf("the key is %d", key);
        return MultiplicationLogic(beforeData, key);
    }

    @Override
    public String decrypt(String beforeData,String decryptKey) {
        try {
            int key = ConvertHandler.StringToInt(decryptKey);
            return MultiplicationLogic(beforeData,key);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + e);
            return null;
        }
    }


    private String MultiplicationLogic(String beforeData, int key) {
        StringBuilder newData = new StringBuilder();
        for (char ch : beforeData.toCharArray()) {
            newData.append((char)(ch * key));
        }
        return newData.toString();
    }
}
