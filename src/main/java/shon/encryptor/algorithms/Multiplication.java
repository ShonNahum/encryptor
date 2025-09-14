package shon.encryptor.algorithms;

import shon.encryptor.abstracts.AbstractCipher;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.utils.Constants;

import static shon.encryptor.utils.MathHandler.divideByByte;
import static shon.encryptor.utils.MathHandler.generateOddKey;

public class Multiplication extends AbstractCipher {
    public static Object encryptionKey;

    @Override
    protected Object generateKey() {
        encryptionKey = generateOddKey(Constants.BYTE_RANGE);
        return encryptionKey;
    }

    @Override
    public byte[] encrypt(byte[] data) {
        return super.encrypt(data);
    }

    @Override
    public byte[] decrypt(byte[] data, String decryptKey) throws CipherException { // #TODO
        return super.decrypt(data, decryptKey);
    }
    @Override
    protected byte[] logic(byte[] data, Object encryptionKey, String mode) {
        byte[] result = new byte[data.length];
        for(int i=0; i < data.length; i++) {
            result[i] = (byte) (data[i] * (int) encryptionKey );
        }
        return result;
    }
}
