package shon.encryptor.interfaces;

import shon.encryptor.exceptions.SelectionException;

public interface Cipher
{
    String encrypt(String data)g;
    String decrypt(String data, String decryptKey);
}
