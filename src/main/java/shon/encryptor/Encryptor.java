package shon.encryptor;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.menus.AlgorithmsMenu;
import shon.encryptor.menus.GeneralMenu;
import shon.encryptor.menus.ModesMenu;
import shon.encryptor.utils.ConsolePrompt;

public class Encryptor { // make it my main (global singleton) so everyone can pull from this the instances
    // make this singleton and if everyone i want something, i can call it from this class.
    private final AlgorithmsMenu algorithmsMenu = new AlgorithmsMenu();
    private final ModesMenu modesMenu = new ModesMenu();
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private final GeneralMenu generalMenu = new GeneralMenu(casear,xor.multiplaction);

    public void start() {
        do { // using and learn about dict (map)  , can make all those 3 classes into key value ENCRYPTION -- > processFunc and the print can be the key's.. no need number, the user will write all the key name and no numbers
            Modes modePrompt = modesMenu.start(); // Selection , userSelection , menuSelection
            Algorithms algorithmPrompt = algorithmsMenu.start(); // algorithmSelection - שיתחלק טוב בלשון
            System.out.println("Please enter filepath:");
            String filePath = consolePrompt.string();
            generalMenu.start(algorithmPrompt, modePrompt, filePath); // mainMenu
        } while (true);
    }

}
