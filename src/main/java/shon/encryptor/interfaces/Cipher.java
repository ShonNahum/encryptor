package shon.encryptor.interfaces;

public interface Cipher
{
    String encrypt(String data);
    String decrypt(String data, int decryptKey);
}
