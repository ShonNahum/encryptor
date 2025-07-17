import java.io.IOException;
import java.util.Scanner;
import encryption.Encryption;
import decryption.Decryption;
import exit.Exit;

public class App {
    public static void main(String[] args) throws IOException {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Exit exit = new Exit();


        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose one of the options (enter the number)");
        System.out.println("[1] Encryption");
        System.out.println("[2] Decryption");
        System.out.println("[3] Exit]");

        int userChoice = myObj.nextInt();

        if (userChoice == 1) {
            encryption.caesarAlgorithemEncrypt();
        }
        else if (userChoice == 2) {
            System.out.println("Soon");
        }
        else if (userChoice == 3) {
            System.out.println("Soon");

        }
        else {
            System.out.println("invalid value");
        }
    }
}