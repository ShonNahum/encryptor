package shon.encryptor;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.utils.CipherHandler;
import shon.encryptor.utils.Constants;
import shon.encryptor.menus.UserSelection;
import shon.encryptor.utils.InputHandler;

import shon.encryptor.utils.FileHandler;

import java.util.Map;


public class Encryptor {
    private final FileHandler fileHandler = new FileHandler();
    private final InputHandler inputHandler = InputHandler.getInstance();
    private final UserSelection userSelection = new UserSelection(inputHandler);
    private final CipherHandler cipherHandler = new CipherHandler(userSelection); //  {FIXED} only he know the algorithms

    public void run() {
        while(true) {
            Map<String,String> selection;
            System.out.println("""
            ==========================
             Starting Encryptor..."
            ==========================
            """);

            try  {
                String decryptKey = null;

                String algorithm = userSelection.chooseAlgorithm();

                String mode = userSelection.chooseMode();
                if (Constants.EXIT.equals(mode)) {
                    System.out.println("Exiting Encryptor :(");
                    break;
                }
                selection = cipherHandler.reverseAlgoValidator(algorithm,mode); // {FIXED} CipherHandle handle Reverse
                algorithm = selection.get("ALGORITHM");
                mode = selection.get("MODE");

                String filePath = userSelection.chooseFilePath(); // {FIXED} check if path is valid here

                if (Constants.DECRYPT.equals(mode) && !Constants.MULTIPLICATION.equals(algorithm)) {
                    decryptKey = userSelection.chooseDecryptKey();
                }


                byte[] fileData = fileHandler.read(filePath);// {FIXED} convert to String is stupid, if its binary file?.. change to array of bytes
                byte[] processedData = cipherHandler.dataProcessor(
                        algorithm,
                        mode,
                        fileData,
                        decryptKey
                );
                fileHandler.write(processedData, filePath, mode);
            }
            catch (SelectionException | FileException | CipherException e ){
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}