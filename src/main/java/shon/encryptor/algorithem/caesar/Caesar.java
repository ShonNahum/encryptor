package shon.encryptor.algorithem.caesar;

import shon.encryptor.utils.KeyGenerator;
import shon.encryptor.algorithem.Encryptions;
import shon.encryptor.app.App;
import shon.encryptor.utils.UserPrompt;

import java.io.IOException;

public class Caesar implements Encryptions {
    AlgorithemLogic algorithemLogic = AlgorithemLogic.getInstance();
    App app = App.getInstance();
    KeyGenerator keyGenerator = KeyGenerator.GetInstance();
    UserPrompt userprompt = UserPrompt.getInstance();

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
