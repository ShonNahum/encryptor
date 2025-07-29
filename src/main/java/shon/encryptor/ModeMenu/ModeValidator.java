package shon.encryptor.ModeMenu;

public class ModeValidator {
    public ModeValidator() {

    }

    public int validatedModeOption(int option) {
        // USE SWITCH CASE
        // READ ABOUT YEILD RETURN
        // no need validate class for that, its part of the menu
        if (option == 1 || option == 2 || option == 3) {
            return option;
        } else {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return -1;
        }
    }

}


