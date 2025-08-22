package shon.encryptor.algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Cipher;
import java.util.Random;
import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public final class Caesar implements Cipher {

    @Override
    public String encrypt(String beforeData) {
        final int SHIFT_RANGE = 20;
        int shiftKey = new Random().nextInt(SHIFT_RANGE);
        System.out.println(shiftKey);
        return caesarLogic(beforeData, shiftKey, ENCRYPT);
    }

    @Override
    public String decrypt(String beforeData, int decryptKey) {
        return caesarLogic(beforeData, decryptKey, Modes.DECRYPT);
    }

    private String caesarLogic(String beforeData, int key, Modes modes) {
        StringBuilder newData = new StringBuilder();
        if (DECRYPT.equals(modes)) {
            key = -key;
        }
        for (char ch : beforeData.toCharArray()) {
            char shifted = (char) (ch + key);
            newData.append(shifted);
        }
        return newData.toString();
    }
}


