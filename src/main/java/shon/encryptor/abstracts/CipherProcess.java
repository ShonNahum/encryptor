package shon.encryptor.abstracts;

public abstract class CipherProcess {
    public void encryption(String algorithmPrompt,String filePath) throws Throwable { // all this can be abstract and in the main just call to it, and i can use the dict from the first menu to call that
        switch (algorithmPrompt) {
            case "CAESAR" -> caesar.encrypt(filePath);
            case "XOR" -> xor.encrypt(filePath);
//            case "REVERSE" -> start(,filePath);
            case "MULTIPLICATION" -> multiplication.encrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }

    public void decryption(String algorithmPrompt,String filePath) throws Throwable {
        switch (algorithmPrompt) {
            case "CAESAR" -> caesar.decrypt(filePath);
            case "XOR" -> xor.decrypt(filePath);
//            case "REVERSE" -> start(,filePath);
            case "MULTIPLICATION" -> multiplication.decrypt(filePath);
            default -> System.out.println("Invalid Algorithm Prompt, try again...");
        }
    }
}
