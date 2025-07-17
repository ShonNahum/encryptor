package encryption;
import java.io.IOException;
import java.util.Random;
import static utils.Files.fileReader;
import static utils.Files.getFilePath;

public class Encryption {
    private int shiftKey;
    public Encryption() throws IOException {
        System.out.println("encryption");
    }

    private int keyGenerator() {
        Random rand = new Random();
        shiftKey = rand.nextInt(2);
        System.out.println("the shift key is " + shiftKey);
        return shiftKey;
    }

    public void caesarAlgorithemEncrypt() throws IOException {
        shiftKey = keyGenerator();
        StringBuilder result = new StringBuilder();
        String textBefore = fileReader(getFilePath());
        System.out.println(textBefore);

        for (char character : textBefore.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char shifted = (char) ((character - base + shiftKey) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        System.out.print(result);
    }






}
