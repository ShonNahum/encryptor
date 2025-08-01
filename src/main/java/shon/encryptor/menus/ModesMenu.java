package shon.encryptor.menus;

import shon.encryptor.enums.Modes;
import shon.encryptor.utils.ConsolePrompt;

public class ModesMenu {

    public Modes start() {
        final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
        final String DECRYPTION = "2";
        final String ENCRYPTION = "1";
        final String EXIT = "3";

        printModeMenu();
        String modePrompt = consolePrompt.string();
        Modes modesState = null;

        switch (modePrompt)
        {
            case ENCRYPTION -> modesState = Modes.ENCRYPT;
            case DECRYPTION -> modesState = Modes.DECRYPT;
            case EXIT -> System.exit(0);
            default -> System.out.println("Invalid Mode Option, try again...");
        }
        return modesState;
    }

    private void printModeMenu(){
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
