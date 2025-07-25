package shon.encryptor.convertions;

public class TypeConverts {

    public int stringToInt(String stringInput) {
        try {
            return Integer.parseInt(stringInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return -1;
        }
    }
}
