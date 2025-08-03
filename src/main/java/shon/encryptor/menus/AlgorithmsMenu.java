package shon.encryptor.menus;

import shon.encryptor.enums.Algorithms;
import shon.encryptor.utils.ConsolePrompt;

public class AlgorithmsMenu {
    private final ConsolePrompt consolePrompt  = ConsolePrompt.getInstance();

    public Algorithms start() {
        printAlgorithmMenu();
        String algorithmPrompt = consolePrompt.string();
        return processAlgorithmMenu(algorithmPrompt);
    }

    private Algorithms processAlgorithmMenu(String AlgorithmPrompt){
        final String CAESAR = "1";
        final String XOR = "2";
        final String REVERSE = "3";
        final String MULTIPLICATION = "4";
        final String EXIT = "5";
        Algorithms algorithmState = null;

        switch (AlgorithmPrompt)
        {
            case CAESAR -> algorithmState = Algorithms.CAESAR;
            case XOR -> algorithmState = Algorithms.XOR;
            case REVERSE -> algorithmState = Algorithms.REVERSE;
            case MULTIPLICATION -> algorithmState = Algorithms.MULTIPLICATION;
            case EXIT -> System.exit(0);

            default -> System.out.println("Invalid Algorithm Option, try again...");
        }
        return algorithmState;
    }

    private void printAlgorithmMenu(){
        System.out.println(
                """
                === Algorithm Menu ===
                [1] Caesar
                [2] XOR
                [3] Reverse
                [4] Multiplication
                [5] Exit
                """
        );
    }

}
