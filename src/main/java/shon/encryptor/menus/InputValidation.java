package shon.encryptor.menus;

import shon.encryptor.exceptions.SelectionException;

import static java.lang.System.exit;

public class InputValidation {

    public String modeInputValidation(String modeInput) {
        try {
            String mode = switch (modeInput) {
                case "ENCRYPT", "DECRYPT" -> mode;
                case "EXIT" -> {
                    exit(0);
                    yield "";
                }
                default -> throw new SelectionException("Invalid mode input");

            };
            return mode;
        }
    }
}
