package shon.encryptor.algorithms;

import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Cipher;

import java.util.Random;

import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;
import static shon.encryptor.utils.MathHandler.alwaysOdd;

public class Multiplication implements Cipher {

    @Override
    public String encrypt(String beforeData) {
        final int BYTE_RANGE = 10;
        int key = alwaysOdd(new Random().nextInt(BYTE_RANGE));
        System.out.printf("the key is %d", key);
        return MultiplicationLogic(beforeData, key);
    }

    @Override
    public String decrypt(String beforeData,int decryptKey) {
        return MultiplicationLogic(beforeData, decryptKey);
    }


    private String MultiplicationLogic(String beforeData, int key) {
        StringBuilder newData = new StringBuilder();
        for (char ch : beforeData.toCharArray()) {
            newData.append((char)(ch * key));
        }
        return newData.toString();
    }
}
