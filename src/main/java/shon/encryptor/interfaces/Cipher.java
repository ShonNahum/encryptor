package shon.encryptor.interfaces;


import shon.encryptor.exceptions.CipherException;

public interface Cipher
{
    String encrypt(String data);
    String decrypt(String data, String decryptKey) throws CipherException;
}
