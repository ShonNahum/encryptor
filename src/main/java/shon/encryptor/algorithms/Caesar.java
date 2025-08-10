package shon.encryptor.algorithms;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.FileException;
import shon.encryptor.utils.FileIO;
import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Cipher;
import java.util.Random;
import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public final class Caesar implements Cipher {

    private final FileIO fileIO;
    private final ConsolePrompt consolePrompt;

    public Caesar(ConsolePrompt consolePrompt, FileIO fileIO) {
        this.fileIO = fileIO;
        this.consolePrompt = consolePrompt;
    }

    @Override
    public void encrypt(String filePath) { // use generic fucntion so there is no duplicate code, and the encrypt and decrypt small changes
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
            int decryptKey = Integer.parseInt(consolePrompt.string());
            String data = fileIO.read(filePath);
            String decryptedData = caesarLogic(data, decryptKey, Modes.DECRYPT);
            fileIO.write(decryptedData, filePath, DECRYPT);
        } catch (FileException e) {
            System.out.println(e);
        }
    }

    private String caesarLogic(String data, int key, Modes modes) {
        StringBuilder newData = new StringBuilder();
        if (modes.equals(DECRYPT)) {
            key = -key;
        }

        for (char ch : data.toCharArray()) {
            char shifted = (char) (ch + key);
            newData.append(shifted);
        }
        return newData.toString();
    }
}


