package shon.encryptor;

import static shon.encryptor.FileReader.fileReader;

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

    public boolean validateFilePath(String filePath) {
        try {
            String[] fileParts = filePath.split("\\.");
            fileParts[1] = null;
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.print("filepath not valid, write the full path");
            return false;
            }
    }
}


