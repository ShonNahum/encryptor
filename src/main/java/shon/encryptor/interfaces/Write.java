package shon.encryptor.interfaces;

import shon.encryptor.enums.Mode;

public interface Write {
    void write(String data, String path, Mode mode) throws Exception;

}
