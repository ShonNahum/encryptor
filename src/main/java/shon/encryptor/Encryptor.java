package shon.encryptor;
import shon.encryptor.abstracts.ABMenu;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.menus.Menu;
import shon.encryptor.menus.Selection;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.FileIO;
import shon.encryptor.utils.SelectionException;


public class Encryptor extends ABMenu {
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private final FileIO fileIO = new FileIO(consolePrompt);
    private final Caesar caesar = new Caesar(consolePrompt,fileIO);
    private final XOR xor = new XOR(consolePrompt,fileIO);
    private final Multiplication multiplication = new Multiplication(consolePrompt,fileIO);
    private final Menu menu = new Menu(caesar,xor,multiplication);
    private final Selection selection = new Selection(consolePrompt);



    public void start() {
        do {
            try {
                menu.start(selection.user(), fileIO.pathSelector());
            }
            catch (SelectionException e) {
                System.out.println("Restarting encryptor");
            }
        } while (true);
    }



}
