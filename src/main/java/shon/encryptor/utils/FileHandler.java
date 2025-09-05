package shon.encryptor.utils;

import shon.encryptor.enums.Modes;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.interfaces.Read;
import shon.encryptor.interfaces.Write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.PatternSyntaxException;

import static java.nio.file.Files.readString;

public class FileHandler implements Read, Write {

    public String validateFileReader(String filepath) {
        try {
            return readString(Path.of(filepath));
        } catch (IOException | OutOfMemoryError | SecurityException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String read(String filepath) {
        return validateFileReader(filepath);
    }


    public void validateFileWriter(String data, String filepath, String mode) {
        try {
            String[] fileParts = filepath.split("\\.");
            String newFilePath;

            if ("ENCRYPT".equals(mode)) {
                newFilePath = fileParts[0] + "_encrypted" + "." + fileParts[1];
            } else {
                newFilePath = fileParts[0] + "_decrypted" + "." + fileParts[1];
            }

            Files.writeString(Path.of(newFilePath), data);
            System.out.println(newFilePath + " Created sucgcessfully");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void void(String data, String filepath, String mode) throws FileException {
        return validateFileWriter(data,filepath,mode);
    }

}
