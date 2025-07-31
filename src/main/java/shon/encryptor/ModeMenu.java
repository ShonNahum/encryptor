package shon.encryptor;

import shon.encryptor.utils.ScannerPrompt;
import shon.encryptor.algorithms.Caesar;



public class ModeMenu {
    private final ScannerPrompt prompt  = ScannerPrompt.getInstance();
    private final Caesar caesar = new Caesar();

    public void start() {
        final String DECRYPTION = "2";
        final String ENCRYPTION = "1";
        final String EXIT = "3";

        do {
            printModeMenu();
            String modePrompt = prompt.string();

            switch (modePrompt)
            {
                case ENCRYPTION, DECRYPTION -> processModeMenu(modePrompt);
                case EXIT -> System.exit(0);
                default -> System.out.println("Invalid Option, try again...");
            }
        } while (true);
    }

    private void processModeMenu(String modePrompt) {
        System.out.println("Please enter filepath:");
        String filePath = prompt.string();
        try {
            caesar.menu(modePrompt,(filePath));
            }
        catch (Exception e) {
            System.out.printf("%s.%nBack to menu.%n", e.getMessage());
            }
    }

    private void printModeMenu(){
        System.out.println(
                """
                === Menu ===
                [1] Encryption
                [2] Decryption
                [3] Exit
                """
        );
    }

}
