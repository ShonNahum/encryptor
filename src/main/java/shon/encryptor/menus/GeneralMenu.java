package shon.encryptor.menus;

import shon.encryptor.algorithms.XOR;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.TimerHandler;


public class GeneralMenu {
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
    private final TimerHandler timerHandler = new TimerHandler();


    public void start(Algorithms algorithmPrompt,Modes modePrompt , String filePath) {
        try
        {
            long startTime;
            long stopTime;

            if(modePrompt.equals(Modes.DECRYPT)) {
                System.out.println("Please enter decryption key:");
                String decryptKey = consolePrompt.string();
                startTime = timerHandler.start();
                decryptionProcess(algorithmPrompt,filePath,decryptKey);
            }
            else
            {
                startTime = timerHandler.start();
                encryptionProcess(algorithmPrompt,filePath);
            }
            stopTime = timerHandler.stop();
            System.out.printf("the process took %.2f ms%n",timerHandler.getDurationMillis(startTime,stopTime));

        }
        catch (Throwable e) {
            System.out.printf("%s.%nBack to menu.%n", e.getMessage());
        }
    }


    private void encryptionProcess(Algorithms algorithmPrompt,String filePath) throws Throwable {
        switch (algorithmPrompt) {
            case CAESAR -> caesar.encrypt(filePath);
            case XOR -> xor.encrypt(filePath);
            case REVERSE -> System.out.println("3 encrypt");
            case MULTIPLICATION -> System.out.println("4 encrypt");
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }

    }

    private void decryptionProcess(Algorithms algorithmPrompt,String filePath,String decryptKey) throws Throwable {
        switch (algorithmPrompt) {
            case CAESAR -> caesar.decrypt(filePath,Integer.parseInt(decryptKey));
            case XOR -> xor.decrypt(filePath, Integer.parseInt(decryptKey));
            case REVERSE -> System.out.println("3 decrypt");
            case MULTIPLICATION -> System.out.println("4 decrypt ");
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }

    }
}
