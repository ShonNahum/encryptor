package shon.encryptor.abstracts;
import java.util.List;

public abstract class MenuPrinter {

    protected void printMode(List<String> options, String menuKind) {
        System.out.printf("=== %s Menu ===%n",menuKind);
        for (String option : options ) {
            System.out.println(option);
        }
        System.out.println("Please write one of the options above");
    }


}
