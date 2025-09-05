package shon.encryptor.menus;

import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.exceptions.SelectionException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


public class Selection extends MenuPrinter {
    private final  Map<String, String> userSelection = new HashMap<>();
    final private InputHandler inputhandler;


    public Selection(InputHandler inputhandler) {
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

    public String getDecryptKey() {
        System.out.printf("=== %s Please Enter Decrypt Key ===%n");
        return inputhandler.StringInput();
    }

    public String getFilePath() {
        System.out.printf("=== %s Please Enter File Path ===%n");
        try {
            String filePath = inputhandler.StringInput();
            return filePath;
        } catch (NoSuchElementException | IllegalStateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
