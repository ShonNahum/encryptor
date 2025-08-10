package shon.encryptor.utils;

import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Read;
import shon.encryptor.interfaces.Write;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static shon.encryptor.enums.Modes.ENCRYPT;

public class FileIO implements Read, Write {
    private final ConsolePrompt consolePrompt;

    public FileIO(ConsolePrompt consolePrompt) {
        this.consolePrompt = consolePrompt;
    }


    public String pathSelector(){
        System.out.println("Please enter filepath");
        return consolePrompt.string();
    }


    @Override
    public String read(String filepath) throws FileException {
        try {
            return readString(Path.of(filepath));
        } catch (IOException | OutOfMemoryError | SecurityException e) {
            throw new FileException("Error reading file at path: " + filepath, e);
        }

    }


    @Override
    public void write(String data, String filepath, Modes modes) throws FileException {
        try {
            String[] fileParts = filepath.split("\\.");
            String newFilePath;

            if (ENCRYPT.equals(modes)) {
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
