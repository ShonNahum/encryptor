package shon.encryptor;
import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.interfaces.Cipher;
import shon.encryptor.menus.CipherHandler;
import shon.encryptor.menus.Constants;
import shon.encryptor.menus.Selection;
import shon.encryptor.menus.InputHandler;

import shon.encryptor.utils.FileHandler;

import java.util.Map;



public class Encryptor extends MenuPrinter {
    private final FileHandler fileHandler = new FileHandler();
    private final InputHandler inputhandler = new InputHandler();
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final Multiplication multiplication = new Multiplication();
    private final Selection selection = new Selection(inputhandler);
    private final CipherHandler cipherHandler = new CipherHandler(caesar, xor, multiplication, selection);


    public void start() {
        do {
            try {
                final Map<String, String> userSelection = Map.of(
                        Constants.KEY_MODE, selection.setMode(),
                        Constants.KEY_ALGORITHM, selection.setAlgorithm(),
                        Constants.KEY_FILE_PATH, selection.setFilePath()
                );
                String beforeData = fileHandler.read(userSelection.get(Constants.KEY_FILE_PATH));
                String newData = cipherHandler.dataProcessor(userSelection.get(Constants.KEY_MODE),userSelection.get(Constants.KEY_ALGORITHM), beforeData);
                if (null == newData){
                    continue;
                }
                fileHandler.write(newData, userSelection.get(Constants.KEY_FILE_PATH),userSelection.get(Constants.KEY_MODE));
            }
            catch (SelectionException | FileException e ){
                System.out.printf(e.getMessage());
            }
        } while (true);
    }
}