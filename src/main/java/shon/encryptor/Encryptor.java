package shon.encryptor;
import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.menus.CipherHandler;
import shon.encryptor.menus.UserSelection;
import shon.encryptor.menus.inputHandler;

import shon.encryptor.utils.FileHandler;

import java.util.Map;

import static java.lang.System.exit;


public class Encryptor extends MenuPrinter {
    private final FileHandler fileHandler = new FileHandler();
    private final inputHandler inputhandler = new inputHandler();
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final Multiplication multiplication = new Multiplication();
    private final CipherHandler cipherHandler = new CipherHandler(caesar, xor, multiplication,inputhandler);
    private final UserSelection userSelection = new UserSelection(inputhandler);



    public void start() {
        do {
            final  Map<String, String>  selection = userSelection.Select();
            if ("EXIT".equals(selection.get("MODE"))) {
                exit(0);
            }
             if (null == selection.get("FILE_PATH")) {
                 continue;
             }
                String filepath = selection.get("FILE_PATH");
                String beforeData = fileHandler.read(filepath);
                String newData = cipherHandler.dataProcessor(userSelection, beforeData);
                fileHandler.write(newData, filepath, userSelection.get("MODE"));
            } catch (SelectionException | FileException e) {
                System.out.println(e);
            }
        } while (true);
    }
}