package shon.encryptor.menus;

import shon.encryptor.enums.Algorithms;
import shon.encryptor.utils.ConsolePrompt;

public class AlgorithmsMenu {

    public Algorithms start() {
        final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();
        final String CAESAR = "1";
        final String XOR = "2";
        final String REVERSE = "3";
        final String MULTIPLICATION = "4";


        printAlgorithmMenu();
        String AlgorithmPrompt = consolePrompt.string();
        Algorithms algorithmState = null;

        switch (AlgorithmPrompt)
        {
            case CAESAR -> algorithmState = Algorithms.CAESAR;
            case XOR -> algorithmState = Algorithms.XOR;
            case REVERSE -> algorithmState = Algorithms.REVERSE;
            case MULTIPLICATION -> algorithmState = Algorithms.MULTIPLICATION;

            default -> System.out.println("Invalid Algorithm Option, try again...");
        }
        return algorithmState;
    }

    private void printAlgorithmMenu(){
        System.out.println(
                """
                === Menu ===
                [1] Caesar
                [2] XOR
                [3] Reverse
                [4] Multiplication
                """
        );
    }

}
