package shon.encryptor.algorithms;

import shon.encryptor.interfaces.Cipher;
import shon.encryptor.utils.ConsoleInput;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.utils.FileIO;

import java.util.Random;

import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;
import static shon.encryptor.utils.MathHandler.alwaysOdd;
import static shon.encryptor.utils.MathHandler.divideByByte;

public class Multiplication implements Cipher {
    private final FileIO fileIO;
    private final ConsoleInput consoleInput;

    public Multiplication(ConsoleInput consoleInput, FileIO fileIO){
        this.fileIO = fileIO;
        this.consoleInput = consoleInput;
    }

    @Override
    public void encrypt(String filePath) {
        final int BYTE_RANGE = 10;
        try {
            String data = fileIO.read(filePath);
            int key = alwaysOdd(new Random().nextInt(BYTE_RANGE));
            System.out.println(key);
            String encryptedData = MultiplicationLogic(data, key);
            fileIO.write(encryptedData, filePath, ENCRYPT);
        } catch (FileException e) {
            System.out.println("Failed to encrypt using Multiplication");
        }
    }

    @Override
    public void decrypt(String filePath) {
        final byte ONE_BYTE = 1;
        try {
            System.out.println("Please enter the encryption key:");
            double encryptKeyPrompt = Integer.parseInt(consoleInput.string());
            double decryptKey = divideByByte(ONE_BYTE, encryptKeyPrompt);
            System.out.printf("the decrypt key is %s%n",decryptKey);
            String data = fileIO.read(filePath);
            String decryptedData = MultiplicationLogic(data, decryptKey);
            fileIO.write(decryptedData, filePath, DECRYPT);
        } catch (FileException e) {
            System.out.println("Failed to decrypt using Multiplication");
        } catch (NumberFormatException e) {
            System.out.println("failed to convert input" + e);
        }
    }


    private String MultiplicationLogic(String data, double key) {
        StringBuilder newData = new StringBuilder();
        for (char ch : data.toCharArray()) {
            newData.append((char)(ch * key));
        }
        return newData.toString();
    }
}
