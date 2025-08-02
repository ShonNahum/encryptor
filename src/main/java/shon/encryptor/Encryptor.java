package shon.encryptor;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.menus.AlgorithmsMenu;
import shon.encryptor.menus.GeneralMenu;
import shon.encryptor.menus.ModesMenu;
import shon.encryptor.utils.ConsolePrompt;

public class Encryptor {
    private final AlgorithmsMenu algorithmsMenu = new AlgorithmsMenu();
    private final ModesMenu modesMenu = new ModesMenu();
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private final GeneralMenu generalMenu = new GeneralMenu();

    public void start() {
        do {
            Algorithms algorithmPrompt = algorithmsMenu.start();
            Modes modePrompt = modesMenu.start();
            System.out.println("Please enter filepath:");
            String filePath = consolePrompt.string();
            generalMenu.start(algorithmPrompt,modePrompt,filePath);
        } while (true);
        }

}
