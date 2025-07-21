package shon.encryptor.app;

import shon.encryptor.algorithem.caesar.Caesar;
import shon.encryptor.utils.UserPrompt;

import java.io.IOException;


public class App {
    private static App instance;

    private App() {}

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public void userChoice() throws IOException { // static void because i dont want it as object (no need save the output)
        UserPrompt userprompt = UserPrompt.getInstance();
        Caesar caesar = new Caesar();
        int prompt = userprompt.menuPrompt();

        if (prompt == 1) {
            caesar.encrypt();
        } else if (prompt == 2) {
            caesar.decrypt();
        } else if (prompt == 3) {
            return;

        } else {
            System.out.println("invalid value");
        }
    }
}
