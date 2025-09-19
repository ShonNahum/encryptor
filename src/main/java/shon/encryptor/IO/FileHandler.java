package shon.encryptor.IO;

import shon.encryptor.exceptions.FileException;
import shon.encryptor.constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readAllBytes;

public class FileHandler implements Read, Write {


    @Override
    public byte[] read(String filepath) throws FileException {
        try {
            return readAllBytes(Path.of(filepath));
        } catch (IOException | OutOfMemoryError | SecurityException e) {
            throw new FileException("Cannot read file " + e);
        }
    }


    @Override
    public void write(byte[] data, String filepath, String mode) throws FileException {
        try {
            int lastDotInFilePath = filepath.lastIndexOf('.');
            String basename = filepath.substring(0, lastDotInFilePath);
            String extension = filepath.substring(lastDotInFilePath + 1);

            String newFilePath;
            if (Constants.ENCRYPT.equals(mode)) {
                newFilePath = basename + "_encrypted." + extension;
            } else {
                newFilePath = basename + "_decrypted." + extension;
            }


            Files.write(Path.of(newFilePath), data);
            System.out.println(newFilePath + " Created successfully");
        } catch (IOException | SecurityException | IllegalArgumentException | UnsupportedOperationException e) {
            throw new FileException("Cannot write to file: " + e);
        }
        }
    }
