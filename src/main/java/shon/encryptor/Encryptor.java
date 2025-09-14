package shon.encryptor;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.exceptions.FileException;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.utils.CipherHandler;
import shon.encryptor.utils.Constants;
import shon.encryptor.menus.UserSelection;
import shon.encryptor.utils.InputHandler;

import shon.encryptor.utils.FileHandler;


public class Encryptor {
    private final FileHandler fileHandler = new FileHandler();
    private final InputHandler inputHandler = InputHandler.getInstance();
    private final UserSelection userSelection = new UserSelection(inputHandler);
    private final CipherHandler cipherHandler = new CipherHandler(); // only he know the algorithms

    public void run() {
        while(true) {
            System.out.println("""
            ==========================
             Starting Encryptor..."
            ==========================
            """);

            try  {
                String decryptKey = null;

                String mode = userSelection.chooseMode();
                if (Constants.EXIT.equals(mode)) {
                    System.out.println("Exiting Encryptor :(");
                    break;
                }

                String algorithm = userSelection.chooseAlgorithm();

                //Handle Reverse (its not good... only cipherHandler need to know it)
                if (Constants.REVERSE.equals(algorithm)){ //what happen after type twice reverse recurtion
                     algorithm = userSelection.chooseAlgorithm();
                    if (Constants.ENCRYPT.equals(mode)) {
                        mode = Constants.DECRYPT;
                    } else {
                        mode = Constants.ENCRYPT;
                    }
                }

                String filePath = userSelection.chooseFilePath(); // {FIXED} check if path is valid here

                if (Constants.DECRYPT.equals(mode)) {
                    decryptKey = userSelection.chooseDecryptKey();
                }


                byte[] fileData = fileHandler.read(filePath);// {FIXED} convert to String is stupid, if its binary file?.. change to array of bytes
                byte[] processedData = cipherHandler.dataProcessor(
                        mode,
                        algorithm,
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