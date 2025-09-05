package shon.encryptor.menus;

import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.exceptions.SelectionException;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.System.exit;


public class Selection extends MenuPrinter {
    final private InputHandler inputhandler;


    public Selection(InputHandler inputhandler) {
        this.inputhandler = inputhandler;
    }


    public String setMode() throws SelectionException {
        final  List<String> ModeMenu = List.of("Encrypt", "Decrypt", "Exit");
        printMenu(ModeMenu, "Modes");
        try {
            String modeInput = inputhandler.modeInput();
            if (Constants.EXIT.equals(modeInput)) {
                exit(0);
            }
            return modeInput;
        } catch (NoSuchElementException | IllegalStateException | SelectionException e){
            throw new SelectionException(e.getMessage());
        }
    }


    public String setAlgorithm() throws SelectionException {
        final List<String> algorithmMenu = List.of("Caesar", "Xor", "Reverse", "Multiplication");
        printMenu(algorithmMenu,"Algorithm");
        try {
            String algorithmInput = inputhandler.algorithmInput();
            return algorithmInput;
        } catch (NoSuchElementException | IllegalStateException | SelectionException e){
            throw new SelectionException(e.getMessage());
        }
    }

    public String getDecryptKey() {
        System.out.println("=== Please Enter Decrypt Key ===");
        return inputhandler.StringInput();
    }

    public String setFilePath() throws SelectionException {
        System.out.println("=== Please Enter File Path ===");
        try {
            String filePath = inputhandler.StringInput();
            return filePath;
        } catch (NoSuchElementException | IllegalStateException e){
            throw new SelectionException(e.getMessage());
        }
    }
}
