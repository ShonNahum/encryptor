package shon.encryptor.utils;

import shon.encryptor.enums.Mode;
import shon.encryptor.abstracts.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static shon.encryptor.enums.Mode.ENCRYPT;

public class File extends IO {
    private static final File instance = new File();

    // Private constructor
    private File() {
    }

    // Singleton accessor
    public static File getInstance() {
        return instance;
    }

    @Override
    public String read(String filepath) throws Exception {
        try {
            return readString(Path.of(filepath));
        } catch (IOException e) {
            throw new Exception("Invalid file path: " + e.getMessage());
        }
    }

    @Override
    public void write(String data, String filepath,  Mode mode) throws Exception {
        try {
            String[] fileParts = filepath.split("\\.");
            String newFilePath;

            if (ENCRYPT.equals(mode)) {
                newFilePath = fileParts[0] + "_encrypted" + "." + fileParts[1];
            } else {
                newFilePath = fileParts[0] + "_decrypted" + "." + fileParts[1];
            }

            Files.writeString(Path.of(newFilePath), data);
            System.out.println(newFilePath + " Created successfully");
        } catch (Exception e) {
            throw new Exception("Failed write to file: " + e.getMessage());
        }
    }
}
