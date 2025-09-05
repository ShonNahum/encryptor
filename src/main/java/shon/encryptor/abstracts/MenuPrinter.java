package shon.encryptor.abstracts;
import java.util.List;

public abstract class MenuPrinter {

    protected void printMenu(List<String> options, String menuKind) {
        System.out.printf("%n=== %s Menu ===%n",menuKind);
        for (String option : options ) {
            System.out.println(option);
        }
        System.out.println("Please write one of the options above");
    }




}
