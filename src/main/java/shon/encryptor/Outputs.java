package shon.encryptor;

public class Outputs {
        private static Outputs instance; // static = class variable, not object!

        private Outputs(){}
        public static Outputs GetInstance() {
            if (instance == null) {
                instance = new Outputs();
            }
            return instance;
        }

    public void printStartMenu() {
        System.out.println(
                "\n=== Menu ===\n" +
                        "[1] Encryption\n" +
                        "[2] Decryption\n" +
                        "[3] Exit\n"
        );
    }
}
