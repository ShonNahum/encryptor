package shon.encryptor.utils;

import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Read;
import shon.encryptor.interfaces.Write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static shon.encryptor.enums.Modes.ENCRYPT;

public class FileIO implements Read, Write {
    private static final FileIO instance = new FileIO();

    private FileIO() {
    }

    public static FileIO getInstance() {
        return instance;
    }

    public String filePathSelector(ConsolePrompt consolePrompt){
        System.out.println("Please enter filepath");
        return consolePrompt.string();
    }
    @Override
    public String read(String filepath) throws Throwable { // and now i dont need the try and catch, because if its fail it thorw
        try {
            return readString(Path.of(filepath));
        } catch (IOException e) {
            throw new Throwable("Invalid file path: " + e.getMessage());
        }
    }


    @Override
    public void write(String data, String filepath, Modes modes) throws Throwable {
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
            throw new Throwable("Failed write to file: " + e.getMessage());
        }
    }

}
