package shon.encryptor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readString;

public class Handle {
    public Handle() {

    }

    public int validatedOption(int option) {

        if (option == 1 || option == 2 || option == 3) {
            return option;
        } else {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return -1;
        }
    }

    public boolean validateFile(String filePath) {
        try {
            String[] fileParts = filePath.split("\\.");
            fileParts[1] = null;
            readString(Path.of(filePath));
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.print("filepath not valid, write the full path");
            return false;
            }
        catch (IOException e) {
            System.out.print("File not found, write the full path");
            return false;
        }
    }
}


