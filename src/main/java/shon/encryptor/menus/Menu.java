package shon.encryptor.menus;

import shon.encryptor.abstracts.ABMenu;
import shon.encryptor.abstracts.CipherProcess;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.utils.ConsolePrompt;
import shon.encryptor.utils.TimerHandler;


import java.util.Map;

public class Menu extends ABMenu {

    final private Caesar caesar;
    final private XOR xor;
    final private Multiplication multiplication;
    final private Cipher cipher = new Cipher();

    public Menu(Caesar caesar, XOR xor, Multiplication multiplication) {
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
            cipher.encryption(algorithmSelection,filePath);
        }
        else {
            startTime = TimerHandler.start();
            cipher.decryption(algorithmSelection,filePath);
        }
        stopTime = TimerHandler.stop();
        System.out.println(TimerHandler.getDurationMillis(startTime,stopTime));

    }// its standard to have 1 try and alot of catch and specific log on him.


}
