package shon.encryptor.algorithms;

import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.FileIO;

import java.util.Random;

import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public class XOR implements Cipher {
    final FileIO fileIO = FileIO.getInstance();

    @Override
    public void encrypt(String filePath) throws Throwable {
        try {
            String data = fileIO.read(filePath);
            byte key = (byte) new Random().nextInt(256);
            System.out.println(key);
            String encryptedData = XORLogic(data, key);
            fileIO.write(encryptedData, filePath, ENCRYPT);
        }
        catch (Throwable e)
        {
            throw new Throwable(e);
        }
    }

    @Override
    public void decrypt(String filePath, int decryptKey) throws Throwable {
        try {
            byte byteDecryptKey = (byte) decryptKey;
            String data = fileIO.read(filePath);
            String decryptedData = XORLogic(data, byteDecryptKey);
            fileIO.write(decryptedData, filePath, DECRYPT);
        }
        catch (Throwable e)
        {
            throw new Throwable(e);
        }
    }

    private String XORLogic(String data, byte key) {
        StringBuilder newData = new StringBuilder();

        for (char ch : data.toCharArray()) {
            char xor = (char) (ch ^ key);
            newData.append(xor);
        }
        return newData.toString();
    }

}
