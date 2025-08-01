package shon.encryptor.algorithms;
import shon.encryptor.utils.FileIO;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Cipher;
import java.util.Random;
import static shon.encryptor.enums.Modes.DECRYPT;
import static shon.encryptor.enums.Modes.ENCRYPT;

public final class Caesar implements Cipher {

    private final ConsolePrompt consolePrompt = ConsolePrompt.getInstance();
    final FileIO fileIO = FileIO.getInstance();

    @Override
    public void encrypt(String filePath) throws Throwable {
        try {
            String data = fileIO.read(filePath);
            int shiftKey = new Random().nextInt(20);
            String encryptedData = caesarLogic(data, shiftKey, ENCRYPT);
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
            String data = fileIO.read(filePath);
            String decryptedData = caesarLogic(data, decryptKey, Modes.DECRYPT);
            fileIO.write(decryptedData, filePath, DECRYPT);
        }
        catch (Throwable e)
        {
            throw new Throwable(e);
        }
    }

    private String caesarLogic(String data, int shiftKey, Modes modes) {
        StringBuilder newData = new StringBuilder();

        if (modes.equals(DECRYPT)) {
            shiftKey = -shiftKey;
        }

        for (char ch : data.toCharArray()) {
            char shifted = (char) (ch + shiftKey);
            newData.append(shifted);
        }
        return newData.toString();
    }

}


