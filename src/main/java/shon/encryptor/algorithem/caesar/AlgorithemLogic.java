package shon.encryptor.algorithem.caesar;

import java.io.IOException;

import static shon.encryptor.utils.FilesHelper.*;


public class AlgorithemLogic {


    public void caesarAlgorithem(int shiftKey,boolean encrypt) throws IOException {
        StringBuilder result = new StringBuilder();
        String textBefore = fileReader();
        char shifted;
        for (char character : textBefore.toCharArray()) {
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
