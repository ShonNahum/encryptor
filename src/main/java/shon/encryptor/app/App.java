package shon.encryptor.app;

import shon.encryptor.algorithem.caesar.Caesar;
import shon.encryptor.utils.userPrompt;

import java.io.IOException;


public class App {
    userPrompt userprompt = new userPrompt();

    public App(){
    }


    public void userChoice() throws IOException {
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
