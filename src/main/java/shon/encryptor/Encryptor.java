package shon.encryptor;

import shon.encryptor.algorithms.Caesar;
import shon.encryptor.convertions.TypeConverts;
import shon.encryptor.filesHelper.FileValidation;
import shon.encryptor.inputs.Inputs;
import shon.encryptor.ModeMenu.ModePrinter;
import shon.encryptor.ModeMenu.ModeValidator;

public class Encryptor {

    TypeConverts typeConverts = new TypeConverts();
    FileValidation fileValidation = new FileValidation();
    ModeValidator modeValidator = new ModeValidator();
    Inputs input  = Inputs.getInstance();
    Caesar caesar = new Caesar();
    ModePrinter modePrinter = new ModePrinter();


    public void Start() {
        modePrinter.printModeMenu();
        while(true) {
            int modeInput = modeValidator.validatedMode(typeConverts.stringToInt(input.stringInput()));

            if (modeInput == 3){
                return;
            }
            else if (modeInput != -1) {
                choiceStartMenu(modeInput);
            }
            modePrinter.printModeMenu();

        }
    }

    private void choiceStartMenu(int modeInput) {
        System.out.println("please enter filepath");
        String filePath = input.stringInput();

        if(fileValidation.validateFile(filePath)) {
            caesar.CaesarMenu(modeInput,filePath);
        }
    }
}
