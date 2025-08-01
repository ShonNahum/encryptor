package shon.encryptor.utils;

import shon.encryptor.enums.    Mode;
import shon.encryptor.abstracts.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static shon.encryptor.enums.Mode.ENCRYPT;

public class FileIO extends IO {
    private static final FileIO instance = new FileIO();

    // Private constructor
    private FileIO() {
    }

    // Singleton accessor
    public static FileIO getInstance() {
        return instance;
    }

    @Override
    public String read(String filepath) throws Throwable {
        try {
            return readString(Path.of(filepath));
        } catch (IOException e) {
            throw new Throwable("Invalid file path: " + e.getMessage());
        }
    }

    @Override
    public void write(String data, String filepath,  Mode mode) throws Throwable {
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
        } catch (Throwable e) {
            throw new Throwable("Failed write to file: " + e.getMessage());
        }
    }
}
