package shon.encryptor.algorithms;

import shon.encryptor.abstracts.AbstractCipher;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.utils.Constants;

import static shon.encryptor.utils.MathHandler.generateRandomNumber;

public class Caesar extends AbstractCipher {

    @Override
    protected Object generateKey() {
        final int SHIFT_RANGE = 20;
        return generateRandomNumber(SHIFT_RANGE);
    }

    @Override
    public String encrypt(String data) {
        return super.encrypt(data);
    }

    @Override
    public String decrypt(String data, String decryptKey) throws CipherException {
        return super.decrypt(data, decryptKey);
    }

    @Override
    protected String logic(String data, Object key, String mode) {
            int shiftkey = (int) key;
            StringBuilder result = new StringBuilder();
            if (Constants.DECRYPT.equals(mode)) {
                shiftkey = -shiftkey;
            }
            for (char ch : data.toCharArray()) {
                result.append((char) (ch + shiftkey));
            }
            return result.toString();
    }
}
