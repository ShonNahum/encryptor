package shon.encryptor;

import java.io.IOException;

import static shon.encryptor.FileReader.fileReader;
import static shon.encryptor.FileWriter.fileWriter;

public class Encryptor {

    TypeConverts typeConverts = new TypeConverts();
    Handle handle = new Handle();
    Inputs input  = Inputs.getInstance();
    Outputs outputs = Outputs.GetInstance();
    Caesar caesar = new Caesar();


    public void Start() {
        outputs.printStartMenu();
        while(true) {
            int choiceInput = handle.validatedOption(typeConverts.stringToInt(input.stringInput()));

            if (choiceInput == 3){
                return;
            }
            else if (choiceInput != -1) {
                choiceStartMenu(choiceInput);
            }
            outputs.printStartMenu();

        }
    }



    private void choiceStartMenu(int choice) {
        System.out.println("please enter filepath");
        String filePath = input.stringInput();

        if(handle.validateFile(filePath)) {
            switch(choice) {
                case 1:
                    String encrypData = caesar.encrypt(fileReader(filePath));
                    fileWriter(encrypData, Mode.ENCRYPT, filePath);
                    break;
                case 2:
                    System.out.println("please enter decryption key");
                    String decryptKey = input.stringInput();
                    String decrypData = caesar.decrypt(fileReader(filePath), typeConverts.stringToInt(decryptKey));
                    fileWriter(decrypData, Mode.DECRYPT, filePath);
                    break;

                default:
                    System.out.println("invalid value, Enter one of the visually choices");
                    break;
            }
        }
    }

}
