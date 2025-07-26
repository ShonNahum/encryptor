package shon.encryptor.ModeMenu;

public class ModeValidator {
    public ModeValidator() {

    }

    public int validatedModeOption(int option) {

        if (option == 1 || option == 2 || option == 3) {
            return option;
        } else {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return -1;
        }
    }

}


