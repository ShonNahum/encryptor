package shon.encryptor.algorithms;

import shon.encryptor.abstracts.AbstractCipher;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.utils.Constants;

import static shon.encryptor.utils.MathHandler.generateOddKey;

public class Multiplication extends AbstractCipher {

    @Override
    protected Object generateKey() {
        return generateOddKey(Constants.BYTE_RANGE);
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
        StringBuilder result = new StringBuilder();
        for (char ch : data.toCharArray()) {
            result.append((char)(ch * (int) key));
        }
        return result.toString();
    }
}
