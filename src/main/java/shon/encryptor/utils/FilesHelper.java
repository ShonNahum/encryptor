package shon.encryptor.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.readString;


public class FilesHelper {
    private static String filePath;
    private static String fileContext;

    public FilesHelper(String filePath) {
        FilesHelper.filePath = filePath;
    }

    public static String getFilePath() {
        return userFilePath();
    }

    private static String userFilePath() {
        userPrompt userpromt = new userPrompt();
        System.out.println("Please Enter Your file path");
        filePath = userpromt.promptString();
        return filePath;
    }

    public static String fileReader() throws IOException {
        fileContext = readString(Path.of(userFilePath() + ".txt"));
        System.out.println(fileContext);

        return fileContext;
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

