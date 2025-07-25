package shon.encryptor;

public interface Algorithems
{
    String encrypt(String data);
    String decrypt(String data,int shiftKey);
}
