package shon.encryptor.IO;


import shon.encryptor.exceptions.FileException;

public interface Write {
    void write(byte[] data, String path, String modes) throws FileException;

}
