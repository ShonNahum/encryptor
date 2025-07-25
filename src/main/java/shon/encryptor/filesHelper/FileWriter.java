package shon.encryptor.filesHelper;

import shon.encryptor.enums.Mode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {

    public static boolean fileWriter(String data, Mode mode, String filepath) {
        try {
            String[] fileParts = filepath.split("\\.");
            String newFilePath;
            if (mode == Mode.ENCRYPT) {
                newFilePath = fileParts[0] + "_encrypted" + "." + fileParts[1];

            } else {
                newFilePath = fileParts[0] + "_decrypted" + "." + fileParts[1];

            }
            Files.writeString(Path.of(newFilePath), data);
            System.out.println(newFilePath + " Created successfully");
        } catch (IOException e) {
            System.out.println("Error create file with the data" + e);
            return false;
        }
        return true;
    }

}