package shon.encryptor.interfaces;

import shon.encryptor.exceptions.SelectionException;

public interface Cipher
{
    String encrypt(String data) throws SelectionException;
    String decrypt(String data, int decryptKey);
}
