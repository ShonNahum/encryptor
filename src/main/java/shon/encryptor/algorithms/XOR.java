package shon.encryptor.algorithms;

import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.ConsoleInput;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.utils.FileIO;

import java.util.Random;

import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public class XOR implements Cipher {
    private final FileIO fileIO;
    private final ConsoleInput consoleInput;

    public XOR(ConsoleInput consoleInput, FileIO fileIO){
        this.fileIO = fileIO;
        this.consoleInput = consoleInput;
    }


    @Override
    public void encrypt(String filePath) {
        final int BYTE_RANGE = 256;
        try {
            String data = fileIO.read(filePath);
            byte key = (byte) new Random().nextInt(BYTE_RANGE);
            System.out.println(Byte.toUnsignedInt(key));
            String encryptedData = XORLogic(data, key);
            fileIO.write(encryptedData, filePath, ENCRYPT);
        } catch (FileException e) {
            System.out.println("Failed to encrypt using Caesar");
        }
    }

    @Override
    public void decrypt(String filePath) {
        System.out.println("Please enter decryption key:");

        final int MAX_BYTE = 255;
        final int MIN_BYTE = 0;
        try {
            int decryptKey = Integer.parseInt(consoleInput.string());
            if (decryptKey < MIN_BYTE || decryptKey > MAX_BYTE)
                throw new IllegalArgumentException("Key must be between 0 and 255");

            byte byteDecryptKey = (byte) decryptKey;
            String data = fileIO.read(filePath);
            String decryptedData = XORLogic(data, byteDecryptKey);
            fileIO.write(decryptedData, filePath, DECRYPT);
        } catch (FileException e) {
            System.out.println("Failed to read file: " + e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
        System.out.println("Key must be between 0 and 255");
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
