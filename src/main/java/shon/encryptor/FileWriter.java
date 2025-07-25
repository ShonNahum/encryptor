package shon.encryptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {

    public static void fileWriter(String data,Mode mode,String filepath) throws IOException {
        String[] fileParts = filepath.split("\\.");
        String newFilePath;
        if (mode == Mode.ENCRYPT) {
            newFilePath = fileParts[0] + "_encrypted" + "." + fileParts[1];

        }
        else {
            newFilePath = fileParts[0] + "_decrypted" + "." + fileParts[1];

        }
        Files.writeString(Path.of(newFilePath), data);
        }

}