package shon.encryptor.ModeMenu;

import shon.encryptor.algorithms.Caesar;
import shon.encryptor.convertions.TypeConverts;
import shon.encryptor.filesHelper.FileValidation;
import shon.encryptor.inputs.Inputs;

public class ModeStarter {

    private final TypeConverts typeConverts = new TypeConverts();
    private final ModeValidator modeValidator = new ModeValidator();
    private final Inputs input  = Inputs.getInstance();
    private final ModePrinter modePrinter = new ModePrinter();
    private final FileValidation fileValidation = new FileValidation();
    private  final Caesar caesar = new Caesar();

    public void start() {
        modePrinter.printModeMenu();
        while(true) {
            int modeInput = modeValidator.validatedModeOption(typeConverts.stringToInt(input.stringInput()));

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
