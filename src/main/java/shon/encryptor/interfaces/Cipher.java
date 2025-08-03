package shon.encryptor.interfaces;

public interface Cipher
{
    void encrypt(String data) throws Throwable;
    void decrypt(String data) throws Throwable;
}
