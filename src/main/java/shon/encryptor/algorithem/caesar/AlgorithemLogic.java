package shon.encryptor.algorithem.caesar;

import java.io.IOException;

import static shon.encryptor.utils.FilesHelper.*;


public class AlgorithemLogic {
    private static AlgorithemLogic instance;

    private AlgorithemLogic(){}

    public static AlgorithemLogic getInstance(){
        if (instance == null) {
            instance = new AlgorithemLogic();
        }
        return instance;
    }

    public void caesarAlgorithem(int shiftKey,boolean encrypt) throws IOException {
        StringBuilder result = new StringBuilder();
        char shifted;
        for (char character : fileReader().toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                if (encrypt) {
                    shifted = (char) ((character - base + shiftKey) % 26 + base);
                }
                else {
                    shifted = (char) ((character - base - shiftKey) % 26 + base);
                }
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        System.out.print("\n" + result + "\n");
        fileWriter(result,encrypt);
    }



}
