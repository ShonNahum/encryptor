package shon.encryptor.menus;
import shon.encryptor.abstracts.Cipher;
import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;


import java.util.Map;

public class Menu extends Cipher {

    public Menu(Caesar caesar, XOR xor, Multiplication multiplication,Selection selection) {
        super(caesar,xor,multiplication,selection);
    }

    public void start(Map<String,String> userSelection,String filePath) {
        String algorithmSelection = userSelection.get("ALGORITHM");
        String ModeSelection = userSelection.get("MODE");

        if("ENCRYPT".equals(ModeSelection)) {
            encryption(algorithmSelection,filePath);
        }
        else {
            decryption(algorithmSelection,filePath);
        }

    }
}
