package shon.encryptor.algorithms;

import shon.encryptor.interfaces.Cipher;
import shon.encryptor.menus.Constants;
import shon.encryptor.utils.ConvertHandler;

import java.awt.*;
import java.util.Random;

public class XOR implements Cipher {


    @Override
    public String encrypt(String beforeData) {
        final int BYTE_RANGE = 256;
        byte key = (byte) new Random().nextInt(BYTE_RANGE);
        System.out.printf("the key is %d" ,key);
        return XORLogic(beforeData, key);
    }

    @Override
    public String decrypt(String beforeData, String decryptKey) {
        try {
            int key = ConvertHandler.StringToInt(decryptKey);
            return XORLogic(beforeData, (byte) key);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + e);
            return null;
        }
    }

    private String XORLogic(String beforeData, byte key) {
        StringBuilder newData = new StringBuilder();
        for (char ch : beforeData.toCharArray()) {
            newData.append((char) (ch ^ key));
        }
        return newData.toString();
    }
}
