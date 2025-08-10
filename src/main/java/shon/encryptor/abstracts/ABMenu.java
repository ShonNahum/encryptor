package shon.encryptor.abstracts;


import shon.encryptor.enums.Algorithms;
import shon.encryptor.enums.Modes;
import shon.encryptor.utils.ConsolePrompt;

import java.util.HashMap;
import java.util.Map;

public abstract class ABMenu {



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


    protected void printMode(Map<?, ?> modes, String menuKind) {
        System.out.printf("=== %s Menu ===%n",menuKind);
        for (Object key : modes .keySet()) {
            System.out.println(key);
        }
        System.out.println("Please write one of the options above");
    }
}
