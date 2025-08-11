package shon.encryptor.abstracts;

import shon.encryptor.algorithms.Caesar;
import shon.encryptor.algorithms.Multiplication;
import shon.encryptor.algorithms.XOR;
import shon.encryptor.menus.Selection;
import shon.encryptor.exceptions.SelectionException;
import shon.encryptor.utils.TimerHandler;

public abstract class Cipher {

    final private Caesar caesar;
    final private XOR xor;
    final private Multiplication multiplication;
    final private Selection selection;
    public Cipher(Caesar caesar, XOR xor, Multiplication multiplication, Selection selection) {
        this.caesar = caesar;
        this.xor = xor;
        this.multiplication = multiplication;
        this.selection = selection;
    }


    public void encryption(String algorithmPrompt,String filePath) {
        try {
            long startTime = TimerHandler.start();
            switch (algorithmPrompt) {
                case "CAESAR" -> caesar.encrypt(filePath);
                case "XOR" -> xor.encrypt(filePath);
                case "REVERSE" -> decryption(selection.algorithm(), filePath);
                case "MULTIPLICATION" -> multiplication.encrypt(filePath);
                default -> System.out.println("Invalid Algorithm Prompt, try again...");
            }
            long stopTime = TimerHandler.stop();
            TimerHandler.getDurationMillis(startTime,stopTime);


        } catch(SelectionException e) {
            System.out.println(e);
        }
    }

    public void decryption(String algorithmPrompt,String filePath) {
        try {
            long startTime = TimerHandler.start();
            switch (algorithmPrompt) {
                case "CAESAR" -> caesar.decrypt(filePath);
                case "XOR" -> xor.decrypt(filePath);
                case "REVERSE" -> encryption(selection.algorithm(),filePath);
                case "MULTIPLICATION" -> multiplication.decrypt(filePath);
                default -> System.out.println("Invalid Algorithm Prompt, try again...");
            }
            long stopTime = TimerHandler.stop();
            TimerHandler.getDurationMillis(startTime,stopTime);
        } catch(SelectionException e) {
            System.out.println(e);
        }
    }
}
