package shon.encryptor.utils;

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
            throw new FileException("Cannot read file " + e);
        }
    }


    @Override
    public void write(String data, String filepath, String mode) throws FileException {
        try {
            String[] fileParts = filepath.split("\\.");
            String newFilePath;

            if (Constants.ENCRYPT.equals(mode)) {
                newFilePath = fileParts[0] + "_encrypted" + "." + fileParts[1];
            } else {
                newFilePath = fileParts[0] + "_decrypted" + "." + fileParts[1];
            }

            Files.writeString(Path.of(newFilePath), data);
            System.out.println(newFilePath + " Created successfully");
        } catch (IOException | SecurityException | IllegalArgumentException | UnsupportedOperationException e) {
            throw new FileException("Cannot write to file: " + e);
        }
        }
    }
