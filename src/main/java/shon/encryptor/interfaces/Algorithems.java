package shon.encryptor.interfaces;

public interface Algorithems
{
    String encrypt(String data);
    String decrypt(String data,int key);
}
