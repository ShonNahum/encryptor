package shon.encryptor.cipher.algorithms;

import shon.encryptor.cipher.AbstractCipher;
import shon.encryptor.conveters.ConvertHandler;
import shon.encryptor.exceptions.CipherException;
import shon.encryptor.constants.Constants;

import static shon.encryptor.math.MathHandler.generateOddKey;

public class Multiplication extends AbstractCipher {
    public static Object encryptionKey;

    @Override
    protected Object generateKey() {
        encryptionKey = generateOddKey(Constants.BYTE_RANGE);
        return encryptionKey;
    }
    @Override
    public Object parseKey(String key) throws CipherException {
        try {
            return ConvertHandler.StringToByte(key);
        } catch (NumberFormatException e) {
            throw new CipherException(e.getMessage());
        }
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
        byte[] result = new byte[data.length];
        for(int i=0; i < data.length; i++) {
            result[i] = (byte) (data[i] * (int) key );
        }
        return result;
    }
}
