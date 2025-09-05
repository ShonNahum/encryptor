package shon.encryptor;
import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.menus.CipherHandler;
import shon.encryptor.menus.Selection;
import shon.encryptor.menus.InputHandler;

import shon.encryptor.utils.FileHandler;

import java.util.Map;

import static java.lang.System.exit;


public class Encryptor extends MenuPrinter {
    private final FileHandler fileHandler = new FileHandler();
    private final InputHandler inputhandler = new InputHandler();
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final InputHandler inputHandler = new InputHandler();

    private final Multiplication multiplication = new Multiplication();
    private final Selection selection = new Selection(inputhandler);
    private final CipherHandler cipherHandler = new CipherHandler(caesar, xor, multiplication, selection,inputHandler);



    public void start() {
        do {
            final  Map<String, String>  selection = this.selection.Select();
            if ("EXIT".equals(selection.get("MODE"))) {
                exit(0);
            }
             if (null == selection.get("FILE_PATH")) {
                 continue;
             }
            String filepath = selection.get("FILE_PATH");
            String beforeData = fileHandler.read(filepath);

            if (null == selection.get("MODE") || null == selection.get("ALGORITHM")) {
                continue;
            }
            String newData = cipherHandler.dataProcessor(selection, beforeData);

            fileHandler.write(newData, filepath, selection.get("MODE"));
        } while (true);
    }
}