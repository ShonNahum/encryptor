package shon.encryptor.utils;

import shon.encryptor.enums.Modes;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.interfaces.Read;
import shon.encryptor.interfaces.Write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;

public class FileHandler implements Read, Write {

    @Override
    public String read(String filepath) throws FileException {
        try {
            return readString(Path.of(filepath));
        } catch (IOException | OutOfMemoryError | SecurityException e) {
            System.out.println(e);
            throw new FileException("failed to read the file path",e);
        }
    }


    @Override
    public void write(String data, String filepath, String mode) throws FileException {
        try {
            String[] fileParts = filepath.split("\\.");
            String newFilePath;

            if ("ENCRYPT".equals(mode)) {
                newFilePath = fileParts[0] + "_encrypted" + "." + fileParts[1];
            } else {
                newFilePath = fileParts[0] + "_decrypted" + "." + fileParts[1];
            }

            Files.writeString(Path.of(newFilePath), data);
            System.out.println(newFilePath + " Created successfully");
        } catch (Throwable e) {
            throw new FileException("Failed write to file: " + filepath,e);
        }
    }

}
