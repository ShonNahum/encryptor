package shon.encryptor.utils;

import java.util.Scanner;

public class userPrompt {

    private void menuPrint(){
        System.out.println("\nChoose one of the options (enter the number)");
        System.out.println("[1] Encryption");
        System.out.println("[2] Decryption");
        System.out.println("[3] Exit");
    }

    public int menuPrompt() {
        Scanner myObj = new Scanner(System.in);
        menuPrint();
        return myObj.nextInt();
    }

    public int promptInt() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextInt();
    }

    public String promptString() {
        Scanner myObj = new Scanner(System.in);
        return  myObj.nextLine();
    }


}
