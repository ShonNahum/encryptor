package shon.encryptor.cipher;


import shon.encryptor.exceptions.CipherException;

public interface Cipher
{
    byte[] encrypt(byte[] data);
    byte[] decrypt(byte[] data, String decryptKey) throws CipherException;

    Object parseKey(String key) throws CipherException;
}
