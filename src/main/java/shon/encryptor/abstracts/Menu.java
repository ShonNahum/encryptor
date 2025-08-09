package shon.encryptor.abstracts;


import java.util.Map;

public abstract class Menu {




    protected void printMode(Map<?, ?> modes, String menuKind) {
        System.out.printf("=== %s Menu ===%n",menuKind);
        for (Object key : modes .keySet()) {
            System.out.println(key);
        }
        System.out.println("Please write one of the options above");
    }
}
