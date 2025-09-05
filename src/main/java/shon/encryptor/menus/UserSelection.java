package shon.encryptor.menus;

import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.exceptions.SelectionException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


public class UserSelection extends MenuPrinter {
    private final  Map<String, String> userSelection = new HashMap<>();
    final private inputHandler inputhandler;


    public UserSelection(inputHandler inputhandler) {
        this.inputhandler = inputhandler;
    }


    public Map<String,String> Select()  {
        userSelection.put("MODE",getMode());
        userSelection.put("ALGORITHM",getAlgorithm());
        userSelection.put("FILE_PATH",getFilePath());
        return userSelection;
    }


    public String getMode() {
        final  List<String> ModeMenu = List.of("Encrypt", "Decrypt", "Exit");
        printMenu(ModeMenu, "Modes");
        try {
            String modeInput = inputhandler.modeInput();
            return modeInput;
        } catch (NoSuchElementException | IllegalStateException | SelectionException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public String getAlgorithm() {
        final List<String> algorithmMenu = List.of("Caesar", "XOR", "Reverse", "Multiplication");
        printMenu(algorithmMenu,"Algorithm");
        try {
            String algorithmInput = inputhandler.algorithmInput();
            return algorithmInput;
        } catch (NoSuchElementException | IllegalStateException | SelectionException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getFilePath() {
        System.out.printf("=== %s Please Enter File Path ===%n");
        try {
            String filePath = inputhandler.filePathInput();
            return filePath;
        } catch (NoSuchElementException | IllegalStateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
