package shon.encryptor.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.readString;


public class FilesHelper {
    private static String filePath;


    public FilesHelper(String filePath) {
        FilesHelper.filePath = filePath;
    }

    public static String getFilePath() {
        return filePath + ".txt";
    }

    private static String userFilePath() {
        UserPrompt userpromt = UserPrompt.getInstance();
        System.out.println("Please Enter Your file path");
        filePath = userpromt.promptString();
        return filePath;
    }

    public static String fileReader() throws IOException {
        return readString(Path.of(userFilePath() + ".txt"));
    }

    public static void fileWriter(StringBuilder newContext,boolean encrypt) throws IOException {
        String newFilePath;
        if (encrypt) {
            newFilePath = filePath + "_encrypted.txt";
        } else {
            newFilePath = filePath + "_decrypted.txt";
        }
        Files.writeString(
                Path.of(newFilePath),
                newContext,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

}

