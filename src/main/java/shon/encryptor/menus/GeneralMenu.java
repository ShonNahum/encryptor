package shon.encryptor.menus;

import shon.encryptor.Encryptor;
import shon.encryptor.abstracts.Menu;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.TimerHandler;

import java.util.HashMap;
import java.util.Map;

public class GeneralMenu extends Menu {

    final private Caesar caesar;
    final private XOR xor;
    final private Multiplication multiplication;

    public GeneralMenu(Caesar caesar, XOR xor, Multiplication multiplication) {
        this.caesar = caesar;
        this.xor = xor;
        this.multiplication = multiplication;
    }


    public void start(Map<String,String> userSelection,String filePath) throws Throwable {
        String algorithmSelection = userSelection.get("ALGORITHM");
        String ModeSelection = userSelection.get("MODE");
        long startTime = 0;
        long stopTime = 0;
        if("ENCRYPTION".equals(ModeSelection)) {
            startTime = TimerHandler.start();
            encryptionProcess(algorithmSelection,filePath);
        }
        else {
            startTime = TimerHandler.start();
            decryptionProcess(algorithmSelection,filePath);
        }
        stopTime = TimerHandler.stop();
        System.out.println(TimerHandler.getDurationMillis(startTime,stopTime));

    }// its standard to have 1 try and alot of catch and specific log on him.


    public void encryptionProcess(String algorithmPrompt,String filePath) throws Throwable { // all this can be abstract and in the main just call to it, and i can use the dict from the first menu to call that
        switch (algorithmPrompt) {
            case "CAESAR" -> caesar.encrypt(filePath);
            case "XOR" -> xor.encrypt(filePath);
//            case "REVERSE" -> start(,filePath);
            case "MULTIPLICATION" -> multiplication.encrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }

    public void decryptionProcess(String algorithmPrompt,String filePath) throws Throwable {
        switch (algorithmPrompt) {
            case "CAESAR" -> caesar.decrypt(filePath);
            case "XOR" -> xor.decrypt(filePath);
//            case "REVERSE" -> start(,filePath);
            case "MULTIPLICATION" -> multiplication.decrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }


    public String algorithmSelection(ConsolePrompt consolePrompt) {
        Map<String, Algorithms> algorithmMenu = new HashMap<>();
        algorithmMenu.put("Caesar", Algorithms.CAESAR);
        algorithmMenu.put("XOR", Algorithms.XOR);
        algorithmMenu.put("Reverse", Algorithms.REVERSE);
        algorithmMenu.put("Multiplication", Algorithms.MULTIPLICATION);
        printMode(algorithmMenu,"Algorithm");
        return consolePrompt.string();
    }

    public String modeSelection(ConsolePrompt consolePrompt) {
        Map<String, Modes> ModeMenu = new HashMap<>();
        ModeMenu.put("Encrypt", Modes.ENCRYPT);
        ModeMenu.put("Decrypt", Modes.DECRYPT);
        ModeMenu.put("EXIT", Modes.EXIT);
        printMode(ModeMenu,"Modes");
        return consolePrompt.string();
    }

}
