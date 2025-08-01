package shon.encryptor.interfaces;

import shon.encryptor.enums.Modes;

public interface Write {
    void write(String data, String path, Modes modes) throws Throwable;

}
