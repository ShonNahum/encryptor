package shon.encryptor.interfaces;

import shon.encryptor.exceptions.FileException;

public interface Read {
    byte[] read(String path) throws FileException;

}
