package shon.encryptor.interfaces;


import shon.encryptor.exceptions.CipherException;

public interface Cipher
{
    byte[] encrypt(byte[] data);
    byte[] decrypt(byte[] data, String decryptKey) throws CipherException;
}
