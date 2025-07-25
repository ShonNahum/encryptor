package shon.encryptor;

import static shon.encryptor.FileReader.fileReader;
import static shon.encryptor.FileWriter.fileWriter;

public class Encryptor {

    TypeConverts typeConverts = new TypeConverts();
    Handle handle = new Handle();
    Inputs input  = Inputs.getInstance();
    Outputs outputs = Outputs.GetInstance();
    Caesar caesar = Caesar.getInstance();


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



    private void choiceStartMenu(int choiceInput) {
        System.out.println("please enter filepath");
        String filePath = input.stringInput();

        if(handle.validateFile(filePath)) {
            caesar.CaesarMenu(choiceInput,filePath);
        }
    }

}
