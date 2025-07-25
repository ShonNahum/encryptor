package shon.encryptor;

import java.io.IOException;

import static shon.encryptor.FileReader.fileReader;
import static shon.encryptor.FileWriter.fileWriter;

public class Encryptor {

    Handle handle = new Handle();
    Inputs input  = Inputs.getInstance();
    Outputs outputs = new Outputs();
    Caesar caesar = new Caesar();


    public void Start() throws IOException {
        outputs.printStartMenu();
        while(true) {
            int choiceInput = handle.validatedOption(handle.stringToInt(input.stringInput()));
            if (choiceInput == 3){
                return;
            }
            else if (choiceInput != -1) {
                choiceStartMenu(choiceInput);
                outputs.printStartMenu();
            }
            else {
                outputs.printStartMenu();
            }

        }
    }



    private void choiceStartMenu(int choice) throws IOException {
        System.out.println("please enter filepath");
        String filePath = input.stringInput();
        if (choice == 1) {
            String encrypData = caesar.encrypt(fileReader(filePath));
            fileWriter(encrypData,Mode.ENCRYPT,filePath);


        } else if (choice == 2) {
            System.out.println("please enter decryption key");
            String decryptKey = input.stringInput();
            String decrypData = caesar.decrypt(fileReader(filePath), handle.stringToInt(decryptKey));
            fileWriter(decrypData,Mode.DECRYPT,filePath);

        } else {
            System.out.println("invalid value, Enter one of the visually choices");
        }
    }

}
