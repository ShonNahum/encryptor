package shon.encryptor.menus;

import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.utils.ConsolePrompt;



public class GeneralMenu {
    private final Caesar caesar = new Caesar();
    private final AlgorithmsMenu algorithmsMenu = new AlgorithmsMenu();
    private final ModesMenu modesMenu = new ModesMenu();
    final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private Algorithms algorithmPrompt;
    private Modes modePrompt;
    private String filePath;



    public void start() {

        do {
            algorithmPrompt = algorithmsMenu.start();
            modePrompt = modesMenu.start();
            System.out.println("Please enter filepath:");
            filePath = consolePrompt.string();
            Menu();
        } while (true);
    }


    private void Menu() {
        try
        {
            if (modePrompt.equals(Modes.ENCRYPT))
            {
                long startTime = System.nanoTime();
                switch (algorithmPrompt) {
                    case CAESAR -> caesar.encrypt(filePath);
                    case XOR -> System.out.println("2 encrypt");
                    case REVERSE -> System.out.println("3 encrypt");
                    case MULTIPLICATION -> System.out.println("4 encrypt");
                    default -> System.out.println("Invalid Algorithm Prompt, try again...");
                }
                long stopTime = System.nanoTime();
                System.out.printf("Encryption took %s ms%n",(stopTime - startTime) / 1_000_000.0);

            }
            else
            {
                System.out.println("Please enter decryption key:");
                String decryptKey = consolePrompt.string();
                long startTime = System.nanoTime();
                switch (algorithmPrompt) {
                    case CAESAR -> caesar.decrypt(filePath,Integer.parseInt(decryptKey));
                    case XOR -> System.out.println("2 decrypt");
                    case REVERSE -> System.out.println("3 decrypt");
                    case MULTIPLICATION -> System.out.println("4 decrypt ");
                    default -> System.out.println("Invalid Algorithm Prompt, try again...");
                }
                long stopTime = System.nanoTime();
                System.out.printf("Decryption took %s ms%n", (stopTime - startTime) / 1_000_000.0);
            }
        }
        catch (Throwable e) {
            System.out.printf("%s.%nBack to menu.%n", e.getMessage());
        }
    }
}
