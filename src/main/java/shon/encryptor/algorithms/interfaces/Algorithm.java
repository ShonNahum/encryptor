package shon.encryptor.algorithms.interfaces;

public interface Algorithm
{
    String encrypt(String data);
    String decrypt(String data,int key);
}
