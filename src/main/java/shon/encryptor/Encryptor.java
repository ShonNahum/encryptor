package shon.encryptor;
import shon.encryptor.abstracts.MenuPrinter;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.menus.Menu;
import shon.encryptor.menus.Selection;
import shon.encryptor.utils.ConsoleInput;
import shon.encryptor.utils.FileIO;
import shon.encryptor.exceptions.SelectionException;

// fix all exception to print them good! with %n

public class Encryptor extends MenuPrinter {
    private final ConsoleInput consoleInput = ConsoleInput.getInstance();
    private final FileIO fileIO = new FileIO(consoleInput);
    private final Selection selection = new Selection(consoleInput);
    private final Caesar caesar = new Caesar(consoleInput,fileIO);
    private final XOR xor = new XOR(consoleInput,fileIO);
    private final Multiplication multiplication = new Multiplication(consoleInput,fileIO);
    private final Menu menu = new Menu(caesar,xor,multiplication,selection);



    public void start() {
        do {
            try {
                menu.start(selection.user(), fileIO.pathSelector());
            }
            catch (SelectionException e) {
                System.out.printf("Restarting encryptor ERROR %s",e);
            }
        } while (true);
    }



}
