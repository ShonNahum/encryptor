package shon.encryptor.algorithms;
import shon.encryptor.utils.File;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.enums.Mode;
import shon.encryptor.interfaces.Cipher;
import java.util.Random;
import static shon.encryptor.enums.Mode.DECRYPT;
import static shon.encryptor.enums.Mode.ENCRYPT;

public final class Caesar implements Cipher {

    private final ConsolePrompt consolePrompt = ConsolePrompt.getInstance();

    @Override
    public String encrypt(String data) {
        int shiftKey = new Random().nextInt(20);
        return caesarLogic(data, shiftKey, ENCRYPT);
    }

    @Override
    public String decrypt(String data, int shiftKey) {
        return caesarLogic(data, shiftKey, Mode.DECRYPT);

    }

    private String caesarLogic(String data, int shiftKey, Mode mode) {
        StringBuilder newData = new StringBuilder();

        if (mode.equals(DECRYPT)) {
            shiftKey = -shiftKey;
        }

        for (char ch : data.toCharArray()) {
            char shifted = (char) (ch + shiftKey);
            newData.append(shifted);
        }
        return newData.toString();
    }

    public void menu(String choiceInput, String filePath) throws Throwable {
        final File file = File.getInstance();
        final String ENCRYPTION = "1";
        final String DECRYPTION = "2";
        try
        {
            switch (choiceInput) {
                case ENCRYPTION -> {
                    String encryptedData = encrypt(file.read(filePath));
                    file.write(encryptedData, filePath, ENCRYPT);
                }
                case DECRYPTION -> {
                    System.out.println("Please enter decryption key:");
                    String decryptKey = consolePrompt.string();
                    String decryptedData = decrypt(file.read(filePath), Integer.parseInt(decryptKey));
                    file.write(decryptedData, filePath, DECRYPT);
                }
                default -> System.out.println("invalid value, Enter one of the visually choices");
            }
        }
        catch (Throwable e)
        {
            throw new Throwable(e);
        }
    }
}


