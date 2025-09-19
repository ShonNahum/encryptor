package shon.encryptor.IO;

import shon.encryptor.exceptions.FileException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.constants.Constants;

import java.io.File;
import java.util.List;



public class UserSelection  {
    final private InputHandler inputHandler;


    public UserSelection(InputHandler inputhandler) {
        this.inputHandler = inputhandler;
    }

    private void printMenu(List<String> options, String menuKind) {
        System.out.printf("=== %s Menu ===%n",menuKind);
        for (String option : options ) {
            System.out.println(option);
        }
        System.out.println("Please write one of the options above");
    }

    public String chooseMode() throws SelectionException {
        final  List<String> ModeMenu = List.of(
                Constants.ENCRYPT,
                Constants.DECRYPT,
                Constants.EXIT
        );
        printMenu(ModeMenu, "Modes");
        return inputHandler.mode();
    }


    public String chooseAlgorithm() throws SelectionException {
        final List<String> algorithmMenu = List.of(
                Constants.CAESAR,
                Constants.XOR,
                Constants.REVERSE,
                Constants.MULTIPLICATION
        );
        printMenu(algorithmMenu,"Algorithm");
        return inputHandler.algorithm();

    }

    public String chooseDecryptKey() {
        System.out.println("=== Please Enter Decrypt Key ===");
        return inputHandler.string();
    }
    public String chooseEncryptKey() {
        System.out.println("=== Please Enter Encrypt Key ===");
        return inputHandler.string();
    }

    public String chooseFilePath() throws FileException {
        System.out.println("=== Please Enter File Path ===");
        File file = new File(inputHandler.string());
        if (file.exists()) {
            return file.toString();
        } else {
            throw new FileException("File does not exists..");
        }
    }
}
