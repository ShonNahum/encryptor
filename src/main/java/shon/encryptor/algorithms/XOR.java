package shon.encryptor.algorithms;

import shon.encryptor.interfaces.Cipher;

import java.util.Random;

public class XOR implements Cipher {


    @Override
    public String encrypt(String beforeData) {
        final int BYTE_RANGE = 256;
        byte key = (byte) new Random().nextInt(BYTE_RANGE);
        System.out.println(Byte.toUnsignedInt(key));
        return XORLogic(beforeData, key);
    }

    @Override
    public String decrypt(String beforeData, int decrptKey) {
        return XORLogic(beforeData, decrptKey);
    }

    private String XORLogic(String beforeData, int key) {
        StringBuilder newData = new StringBuilder();
        for (char ch : beforeData.toCharArray()) {
            newData.append((char) (ch ^ key));
        }
        return newData.toString();
    }
}
