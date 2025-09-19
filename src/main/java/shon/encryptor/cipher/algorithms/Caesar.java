package shon.encryptor.cipher.algorithms;

import shon.encryptor.cipher.AbstractCipher;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.constants.Constants;

import static shon.encryptor.math.MathHandler.generateRandomNumber;

public class Caesar extends AbstractCipher {

    @Override
    protected Object generateKey() {
        final int SHIFT_RANGE = 20;
        return generateRandomNumber(SHIFT_RANGE);
    }

    @Override
    public byte[] encrypt(byte[] data) {
        return super.encrypt(data);
    }

    @Override
    public byte[] decrypt(byte[] data, String decryptKey) throws CipherException {
        return super.decrypt(data, decryptKey);
    }

    @Override
    protected byte[] logic(byte[] data, Object key, String mode) {
        int shiftkey = (int) key;
        if (Constants.DECRYPT.equals(mode)) {
            shiftkey = -shiftkey;
        }

        byte[] result = new byte[data.length];
        for(int i=0; i < data.length; i++) {
            result[i] = (byte) (data[i] + shiftkey);
        }
        return result;
    }
}
