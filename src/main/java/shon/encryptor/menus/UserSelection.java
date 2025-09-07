package shon.encryptor.menus;

import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.utils.Constants;
import shon.encryptor.utils.InputHandler;

import java.util.List;



public class UserSelection  {
    final private InputHandler inputHandler;


    public UserSelection(InputHandler inputhandler) {
        this.inputHandler = inputhandler;
    }

    private void printMenu(List<String> options, String menuKind) {
        System.out.printf("%n=== %s Menu ===%n",menuKind);
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
        return inputHandler.modeInput();
    }


    public String chooseAlgorithm() throws SelectionException {
        final List<String> algorithmMenu = List.of(
                Constants.CAESAR,
                Constants.XOR,
                Constants.REVERSE,
                Constants.MULTIPLICATION
        );
        printMenu(algorithmMenu,"Algorithm");
        return inputHandler.algorithmInput();

    }

    public String chooseDecryptKey() {
        System.out.println("=== Please Enter Decrypt Key ===");
        return inputHandler.stringInput();
    }

    public String chooseFilePath() throws SelectionException {
        System.out.println("=== Please Enter File Path ===");
        return inputHandler.stringInput();
    }
}
