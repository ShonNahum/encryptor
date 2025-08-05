package shon.encryptor.menus;

import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.utils.TimerHandler;


public class GeneralMenu { // no need to init all the classes, use constructor.. no need to have new
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final TimerHandler timerHandler = new TimerHandler();
    private  final AlgorithmsMenu algorithmsMenu = new AlgorithmsMenu();
    private final Multiplication multiplication = new Multiplication();

//    public GeneralMenu(Caesar caesar) { LIKE THIS, it will save us if we change the constructor its less depends
//        this.caesar = caesar;
//    }

    public void start(Algorithms algorithmPrompt,Modes modePrompt , String filePath) {
        try
        {
            long startTime;
            long stopTime;
// if two nulls there is objects.equals its generic (learn)
            if(modePrompt.equals(Modes.DECRYPT)) { // better to use different to make CONSTANT -> dynamic, if i do not like this it will give me nullPointerException
                startTime = timerHandler.start();
                decryptionProcess(algorithmPrompt,filePath);
                return;
            }
            else
            {
                startTime = timerHandler.start();
                encryptionProcess(algorithmPrompt,filePath);
            }
            stopTime = timerHandler.stop();
            System.out.printf("the process took %.2f ms%n",timerHandler.getDurationMillis(startTime,stopTime));
        }
        catch (Throwable e) {// change all the excpetion to be specifics.. so i can debug better. // its standard to have 1 try and alot of catch and specific log on him.
            System.out.printf("%s.%nBack to menu.%n", e.getMessage());
        }
    }// its standard to have 1 try and alot of catch and specific log on him.


    public void encryptionProcess(Algorithms algorithmPrompt,String filePath) throws Throwable { // all this can be abstract and in the main just call to it, and i can use the dict from the first menu to call that
        switch (algorithmPrompt) {
            case CAESAR -> caesar.encrypt(filePath);
            case XOR -> xor.encrypt(filePath);
            case REVERSE -> decryptionProcess(algorithmsMenu.start(),filePath);
            case MULTIPLICATION -> multiplication.encrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }

    public void decryptionProcess(Algorithms algorithmPrompt,String filePath) throws Throwable {
        switch (algorithmPrompt) {
            case CAESAR -> caesar.decrypt(filePath);
            case XOR -> xor.decrypt(filePath);
            case REVERSE -> encryptionProcess(algorithmsMenu.start(),filePath);
            case MULTIPLICATION -> multiplication.decrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }
}
