package shon.encryptor;


import static shon.encryptor.FileReader.fileReader;
import static shon.encryptor.FileWriter.fileWriter;

public class Caesar implements Algorithems{
    private static Caesar instance = new Caesar();

    Utils utils = new Utils();
    Inputs input  = Inputs.getInstance();
    Caesar caesar = Caesar.getInstance();
    TypeConverts typeConverts = new TypeConverts();


    private Caesar() {}

    public static Caesar getInstance() {
        return instance;
    }


    @Override
    public String encrypt(String data) {
        int shiftKey = utils.randomKey();
        return CaesarLogic(data,shiftKey,Mode.ENCRYPT);
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
                String encrypData = caesar.encrypt(fileReader(filePath));
                fileWriter(encrypData, Mode.ENCRYPT, filePath);
                break;
            case 2:
                System.out.println("please enter decryption key");
                String decryptKey = input.stringInput();
                String decrypData = caesar.decrypt(fileReader(filePath), typeConverts.stringToInt(decryptKey));
                fileWriter(decrypData, Mode.DECRYPT, filePath);
                break;

            default:
                System.out.println("invalid value, Enter one of the visually choices");
                break;
        }
    }


}


