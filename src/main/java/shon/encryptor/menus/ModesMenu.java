package shon.encryptor.menus;

import shon.encryptor.enums.Modes;
import shon.encryptor.utils.ConsolePrompt;

public class ModesMenu {
    final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();


    public Modes start() { // too general name // takeSelection
        printModeMenu(); // modeMenu
        String modePrompt = consolePrompt.string();
        return processModeMenu(modePrompt);
    }

    private Modes processModeMenu(String modePrompt) {
        final String DECRYPTION = "2";
        final String ENCRYPTION = "1";
        final String EXIT = "3";
        Modes modesState = null;
        switch (modePrompt) // learn about yeld deeply
        {
            case ENCRYPTION -> modesState = Modes.ENCRYPT;
            case DECRYPTION -> modesState = Modes.DECRYPT;
            case EXIT -> System.exit(0);
            default -> System.out.println("Invalid Mode Option, try again...");
        }
        return modesState;
    } // inside class i want to have details function name becuase i dont call the class object , but outside its ok to be like only print. becuase the class name represent itself

    private void printModeMenu(){ // why printModeMenu if im in class ModeMenu, use just printMode
        System.out.println(
                """
                === Modes Menu ===
                [1] Encryption
                [2] Decryption
                [3] Exit
                """
        );
    }

}
