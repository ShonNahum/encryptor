package shon.encryptor;

public class Handle {
    public Handle() {

    }

    public int stringToInt(String stringInput) {
        try {
            return Integer.parseInt(stringInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return -1;
        }
    }

    public int validatedOption(int option) {

        if (option == 1 || option == 2 || option == 3) {
            return option;
        } else {
            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            return -1;
        }
    }
}

