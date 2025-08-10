package shon.encryptor.abstracts;

import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;

public abstract class Cipher {

    final private Caesar caesar;
    final private XOR xor;
    final private Multiplication multiplication;

    public Cipher(Caesar caesar, XOR xor, Multiplication multiplication) {
        this.caesar = caesar;
        this.xor = xor;
        this.multiplication = multiplication;
    }


    public void encryption(String algorithmPrompt,String filePath) {
        switch (algorithmPrompt) {
            case "CAESAR" -> caesar.encrypt(filePath);
            case "XOR" -> xor.encrypt(filePath);
//            case "REVERSE" -> start(,filePath);
            case "MULTIPLICATION" -> multiplication.encrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }

    public void decryption(String algorithmPrompt,String filePath) {
        switch (algorithmPrompt) {
            case "CAESAR" -> caesar.decrypt(filePath);
            case "XOR" -> xor.decrypt(filePath);
//            case "REVERSE" -> start(,filePath);
            case "MULTIPLICATION" -> multiplication.decrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }
}
