package shon.encryptor.algorithms;
import shon.encryptor.utils.ConsoleInput;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.utils.FileIO;
import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Cipher;
import java.util.Random;
import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public final class Caesar implements Cipher {

    private final FileIO fileIO;
    private final ConsoleInput consoleInput;

    public Caesar(ConsoleInput consoleInput, FileIO fileIO) {
        this.fileIO = fileIO;
        this.consoleInput = consoleInput;
    }

    @Override
    public void encrypt(String filePath) {
        final int SHIFT_RANGE = 20;
        try {
            String data = fileIO.read(filePath);
            int shiftKey = new Random().nextInt(SHIFT_RANGE);
            System.out.println(shiftKey);
            String encryptedData = caesarLogic(data, shiftKey, ENCRYPT);
            fileIO.write(encryptedData, filePath, ENCRYPT);
        } catch (FileException e) {
            System.out.println(e);
        }
    }

    @Override
    public void decrypt(String filePath) {
        try {
            System.out.println("Please enter decryption key:");
            int decryptKey = Integer.parseInt(consoleInput.string());
            String data = fileIO.read(filePath);
            String decryptedData = caesarLogic(data, decryptKey, Modes.DECRYPT);
            fileIO.write(decryptedData, filePath, DECRYPT);
        } catch (FileException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("failed to convert input" + e);
        }
    }

    private String caesarLogic(String data, int key, Modes modes) {
        StringBuilder newData = new StringBuilder();
        if (DECRYPT.equals(modes)) {
            key = -key;
        }

        for (char ch : data.toCharArray()) {
            char shifted = (char) (ch + key);
            newData.append(shifted);
        }
        return newData.toString();
    }
}


