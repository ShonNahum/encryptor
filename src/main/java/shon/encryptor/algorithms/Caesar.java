package shon.encryptor.algorithms;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.menus.Constants;
import shon.encryptor.utils.ConvertHandler;

import java.util.Random;


public final class Caesar implements Cipher{

    @Override
    public String encrypt(String beforeData) {
        final int SHIFT_RANGE = 20;
        int shiftKey = new Random().nextInt(SHIFT_RANGE);
        System.out.printf("the shift key is %d" ,shiftKey);
        return caesarLogic(beforeData, shiftKey, Constants.ENCRYPT);
    }

    @Override
    public String decrypt(String beforeData, String decryptKey) {
        try {
            int key = ConvertHandler.StringToInt(decryptKey);
            return caesarLogic(beforeData, key, Constants.DECRYPT);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + e);
            return null;
        }
    }

    private String caesarLogic(String beforeData, int key, String modes) {
        StringBuilder newData = new StringBuilder();
        if (Constants.DECRYPT.equals(modes)) {
            key = -key;
        }
        for (char ch : beforeData.toCharArray()) {
            char shifted = (char) (ch + key);
            newData.append(shifted);
        }
        return newData.toString();
    }
}


