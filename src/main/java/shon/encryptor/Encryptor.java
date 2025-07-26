package shon.encryptor;

import shon.encryptor.algorithms.Caesar;
import shon.encryptor.convertions.TypeConverts;
import shon.encryptor.filesHelper.FileValidation;
import shon.encryptor.inputs.Inputs;
import shon.encryptor.ModeMenu.ModePrinter;
import shon.encryptor.ModeMenu.ModeValidator;

public class Encryptor {
 // private final = Instance shouldn’t change (best practice) (ask yonke to explain better)
    private final TypeConverts typeConverts = new TypeConverts();
    private final FileValidation fileValidation = new FileValidation();
    private final ModeValidator modeValidator = new ModeValidator();
    private final Inputs input  = Inputs.getInstance();
    private final Caesar caesar = new Caesar();
    private final ModePrinter modePrinter = new ModePrinter();


    public void start() {
        modePrinter.printModeMenu();
        while(true) {
            int modeInput = modeValidator.validatedMode(typeConverts.stringToInt(input.stringInput()));

            if (modeInput == 3){
                return;
            }
            else if (modeInput != -1) {
                processUserChoice(modeInput);
            }
            modePrinter.printModeMenu();

        }
    }

    private void processUserChoice(int modeInput) {
        System.out.println("please enter filepath");
        String filePath = input.stringInput();

        if(fileValidation.validateFile(filePath)) {
            caesar.caesarMenu(modeInput,filePath);
        }
    }
}
