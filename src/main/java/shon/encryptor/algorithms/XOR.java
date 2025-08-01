package shon.encryptor.algorithms;

import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.FileIO;

import java.util.Random;

import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public class XOR implements Cipher {
    final FileIO fileIO = FileIO.getInstance();

    @Override
    public void encrypt(String filePath) throws Throwable {
        final int BYTE_RANGE = 256;
        try {
            String data = fileIO.read(filePath);
            byte key = (byte) new Random().nextInt(BYTE_RANGE);
            System.out.println(Byte.toUnsignedInt(key));
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
        final  int MAX_BYTE = 255;
        final int MIN_BYTE = 0;
        try {
            if (decryptKey < MIN_BYTE || decryptKey > MAX_BYTE)
                throw new IllegalArgumentException("Key must be between 0 and 255");

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
            newData.append((char)(ch ^ key));
        }
        return newData.toString();
    }

}
