package utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import static java.nio.file.Files.readString;

public class Files {
    private static String filePath;

    public Files(String filePath) {
        Files.filePath = filePath;
    }

    public static String getFilePath() {
        return userFilePath();
    }

    private static String userFilePath() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Enter Your file path");
        filePath = myObj.nextLine();
        return filePath;
    }

    public static String fileReader(String filePath) throws IOException {
        return readString(Path.of(filePath));
    }


}
