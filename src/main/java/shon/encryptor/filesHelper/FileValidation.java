package shon.encryptor.filesHelper;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readString;

public class FileValidation { // its already file.. and FileValidator
    public boolean validateFile(String filePath) {
        try {
            String[] fileParts = filePath.split("\\.");
            fileParts[1] = null;
            readString(Path.of(filePath));
            return true;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.print("filepath not valid, write the full path");
            return false;
        } catch (IOException e) {
            System.out.print("File not found, write the full path");
            return false;
        }
    }
}
