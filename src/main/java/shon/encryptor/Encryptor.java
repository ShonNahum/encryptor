package shon.encryptor;
import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.menus.CipherHandler;
import shon.encryptor.menus.inputHandler;

import shon.encryptor.utils.FileHandler;

import java.util.Map;


public class Encryptor extends MenuPrinter {
    private final FileHandler fileHandler = new FileHandler();
    private final inputHandler inputhandler = new inputHandler();
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final Multiplication multiplication = new Multiplication();
    private final CipherHandler cipherHandler = new CipherHandler(caesar, xor, multiplication,inputhandler);


    public void start() {
        do {
            Map<String, String> userSelection;
            try {
                userSelection = inputhandler.userSelections();
                String filepath = userSelection.get("FILE_PATH");
                String beforeData = fileHandler.read(filepath);
                String newData = cipherHandler.dataProcessor(userSelection, beforeData);
                fileHandler.write(newData, filepath, userSelection.get("MODE"));
            } catch (SelectionException | FileException e) {
                System.out.println(e);
            }
        } while (true);
    }
}