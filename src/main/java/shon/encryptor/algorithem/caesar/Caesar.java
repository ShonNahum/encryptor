package shon.encryptor.algorithem.caesar;

import shon.encryptor.utils.KeyGenerator;
import shon.encryptor.algorithem.Encryptions;
import shon.encryptor.app.App;
import shon.encryptor.utils.userPrompt;

import java.io.IOException;

public class Caesar implements Encryptions {
    AlgorithemLogic algorithemLogic = new AlgorithemLogic();
    App app = new App();
    KeyGenerator keyGenerator = new KeyGenerator();
    userPrompt userprompt = new userPrompt();

    @Override
    public void encrypt() throws IOException {
        int shiftkey = keyGenerator.randomNumber();
        boolean encrypt = true;
        algorithemLogic.caesarAlgorithem(shiftkey,encrypt);
        app.userChoice();
    }

    @Override
    public void decrypt() throws IOException {
        boolean encrypt = false;
        System.out.println("enter decrypt key");
        int shiftkey = userprompt.promptInt();
        algorithemLogic.caesarAlgorithem(shiftkey,encrypt);
        app.userChoice();
    }
}
