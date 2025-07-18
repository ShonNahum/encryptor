package shon.encryptor.utils;

import java.util.Scanner;

public class userPrompt {
    private String stringPromptValue;
    private int menuPromptValue;

    private void menuPrint(){
        System.out.println("\nChoose one of the options (enter the number)");
        System.out.println("[1] Encryption");
        System.out.println("[2] Decryption");
        System.out.println("[3] Exit");
    }

    public int menuPrompt() {
        Scanner myObj = new Scanner(System.in);
        menuPrint();
        menuPromptValue = myObj.nextInt();
        return menuPromptValue;
    }

    public int promptInt() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextInt();
    }

    public String promptString() {
        Scanner myObj = new Scanner(System.in);
        stringPromptValue = myObj.nextLine();
        return stringPromptValue;
    }


}
