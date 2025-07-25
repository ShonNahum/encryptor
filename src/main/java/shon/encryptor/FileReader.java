package shon.encryptor;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readString;

public class FileReader {
    public static String fileReader(String filepath) {
        try {
            return readString(Path.of(filepath));
        } catch (IOException e) {
            return "file error: " + e;
        }
    }
}
