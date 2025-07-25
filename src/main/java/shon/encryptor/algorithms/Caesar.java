package shon.encryptor.algorithms;


import shon.encryptor.generators.KeyGenerator;
import shon.encryptor.inputs.Inputs;
import shon.encryptor.convertions.TypeConverts;
import shon.encryptor.ModeMenu.enums.Mode;
import shon.encryptor.algorithms.interfaces.Algorithm;

import static shon.encryptor.filesHelper.FileReader.fileReader;
import static shon.encryptor.filesHelper.FileWriter.fileWriter;

public class Caesar implements Algorithm {

    KeyGenerator keyGenerator = new KeyGenerator();
    Inputs input  = Inputs.getInstance();
    TypeConverts typeConverts = new TypeConverts();

    @Override
    public String encrypt(String data) {
        int shiftKey = keyGenerator.generateKey();
        return CaesarLogic(data,shiftKey, Mode.ENCRYPT);
    }

    @Override
    public String decrypt(String data,int shiftKey) {
        return CaesarLogic(data,shiftKey,Mode.DECRYPT);

    }

    private String CaesarLogic(String data,int shiftKey,Mode mode){
        StringBuilder newData = new StringBuilder();
        char shifted;
        if (mode == Mode.DECRYPT) {
            shiftKey = -shiftKey;
        }

        for (char ch : data.toCharArray()) {
            shifted = (char)(ch + shiftKey);
            newData.append(shifted);
        }

            return newData.toString();

    }

    public void CaesarMenu(int choiceInput,String filePath){
        switch(choiceInput) {
            case 1:
                String encrypData = encrypt(fileReader(filePath));
                fileWriter(encrypData, Mode.ENCRYPT, filePath);
                break;
            case 2:
                System.out.println("please enter decryption key");
                String decryptKey = input.stringInput();
                String decrypData = decrypt(fileReader(filePath), typeConverts.stringToInt(decryptKey));
                fileWriter(decrypData, Mode.DECRYPT, filePath);
                break;

            default:
                System.out.println("invalid value, Enter one of the visually choices");
                break;
        }
    }


}


