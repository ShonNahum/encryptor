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
    private final Caesar caesar = new Caesar();
    private final XOR xor = new XOR();
    private final Multiplication multiplication = new Multiplication();
    private final UserSelection userSelection = new UserSelection(inputHandler);
    private final CipherHandler cipherHandler = new CipherHandler(caesar, xor, multiplication);

    public void run() {
        do {
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

                //Handle Reverse
                if (Constants.REVERSE.equals(algorithm)){
                     algorithm = userSelection.chooseAlgorithm();
                    if (Constants.ENCRYPT.equals(mode)) {
                        mode = Constants.DECRYPT;
                    } else {
                        mode = Constants.ENCRYPT;
                    }
                }

                String filePath = userSelection.chooseFilePath();

                if (Constants.DECRYPT.equals(mode)) {
                    decryptKey = userSelection.chooseDecryptKey();
                }


                String fileData = fileHandler.read(filePath);
                String processedData = cipherHandler.dataProcessor(
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
        } while (true);
    }
}