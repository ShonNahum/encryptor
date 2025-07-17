package encryption;
import java.io.IOException;
import java.util.Random;
import static utils.Files.fileReader;
import static utils.Files.getFilePath;

public class Encryption {

    public Encryption() throws IOException {
        System.out.println("encryption");
        keyGenerator();
        caesarAlgorithemEncrypt();
    }

    private int keyGenerator() {
        Random rand = new Random();
        int key = rand.nextInt(20);
        return key;
    }

    public void caesarAlgorithemEncrypt() throws IOException {
        System.out.println(fileReader(getFilePath()));
    }






}
