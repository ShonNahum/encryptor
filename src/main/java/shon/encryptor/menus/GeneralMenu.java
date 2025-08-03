package shon.encryptor.menus;

import shon.encryptor.algorithms.XOR;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.utils.TimerHandler;


public class GeneralMenu {
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final TimerHandler timerHandler = new TimerHandler();
    private  final AlgorithmsMenu algorithmsMenu = new AlgorithmsMenu();

    public void start(Algorithms algorithmPrompt,Modes modePrompt , String filePath) {
        try
        {
            long startTime;
            long stopTime;

            if(modePrompt.equals(Modes.DECRYPT)) {
                startTime = timerHandler.start();
                decryptionProcess(algorithmPrompt,filePath);
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


    public void encryptionProcess(Algorithms algorithmPrompt,String filePath) throws Throwable {
        switch (algorithmPrompt) {
            case CAESAR -> caesar.encrypt(filePath);
            case XOR -> xor.encrypt(filePath);
            case REVERSE -> start(algorithmsMenu.start() ,Modes.DECRYPT,filePath);
            case MULTIPLICATION -> System.out.println("4 encrypt");
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }

    public void decryptionProcess(Algorithms algorithmPrompt,String filePath) throws Throwable {
        switch (algorithmPrompt) {
            case CAESAR -> caesar.decrypt(filePath);
            case XOR -> xor.decrypt(filePath);
            case REVERSE -> start(algorithmsMenu.start() ,Modes.ENCRYPT,filePath);
            case MULTIPLICATION -> System.out.println("4 decrypt ");
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }
}
