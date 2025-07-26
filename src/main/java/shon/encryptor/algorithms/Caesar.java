package shon.encryptor.algorithms;


import shon.encryptor.generators.KeyGenerator;
import shon.encryptor.inputs.Inputs;
import shon.encryptor.convertions.TypeConverts;
import shon.encryptor.ModeMenu.enums.Mode;
import shon.encryptor.algorithms.interfaces.Algorithm;

import static shon.encryptor.filesHelper.FileReader.fileReader;
import static shon.encryptor.filesHelper.FileWriter.fileWriter;

public class Caesar implements Algorithm {

    private final KeyGenerator keyGenerator = new KeyGenerator();
    private final Inputs input  = Inputs.getInstance();
    private final TypeConverts typeConverts = new TypeConverts();

    @Override
    public String encrypt(String data) {
        int shiftKey = keyGenerator.generateKey();
        return caesarLogic(data,shiftKey, Mode.ENCRYPT);
    }

    @Override
    public String decrypt(String data,int shiftKey) {
        return caesarLogic(data,shiftKey,Mode.DECRYPT);

    }

    private String caesarLogic(String data,int shiftKey,Mode mode){
        StringBuilder newData = new StringBuilder();
        if (mode == Mode.DECRYPT) {
            shiftKey = -shiftKey;
        }

        for (char ch : data.toCharArray()) {
            char shifted = (char)(ch + shiftKey);
            newData.append(shifted);
        }

            return newData.toString();

    }

    public void caesarMenu(int choiceInput,String filePath){
        switch(choiceInput) {
            case 1:
                String encryptedData = encrypt(fileReader(filePath));
                fileWriter(encryptedData, Mode.ENCRYPT, filePath);
                break;
            case 2:
                System.out.println("Please enter decryption key:");
                String decryptKey = input.stringInput();
                int validatedDecryptkey = typeConverts.stringToInt(decryptKey);
                if (validatedDecryptkey != -1) {
                    String decryptedData = decrypt(fileReader(filePath), validatedDecryptkey);
                    fileWriter(decryptedData, Mode.DECRYPT, filePath);
                }
                break;

            default:
                System.out.println("invalid value, Enter one of the visually choices");
                break;
        }
    }


}


