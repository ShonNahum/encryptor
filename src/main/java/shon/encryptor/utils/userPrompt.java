package shon.encryptor.utils;

import java.util.Scanner;

public class UserPrompt {
    private static UserPrompt instance;
    private Scanner myObj; // different value for each object,need create object to use.

    private UserPrompt(){ // private constructor to prevent new instance
        myObj = new Scanner(System.in);
    }

    public static UserPrompt getInstance() {
        if (instance == null) {
            instance = new UserPrompt();
        }
        return instance;
    }


    private void menuPrint(){
        System.out.println("\nChoose one of the options (enter the number)");
        System.out.println("[1] Encryption");
        System.out.println("[2] Decryption");
        System.out.println("[3] Exit");
    }

    public int menuPrompt() {
        menuPrint();
        return myObj.nextInt();
    }

    public int promptInt() {
        return myObj.nextInt();
    }

    public String promptString() {
        myObj.nextLine();
        return  myObj.nextLine();
    }


}
