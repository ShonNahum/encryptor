package shon.encryptor.abstracts;

import shon.encryptor.enums.Modes;
import shon.encryptor.interfaces.Read;
import shon.encryptor.interfaces.Write;

    public abstract class IO implements Read, Write {
    @Override
    public String read(String path) throws Throwable {
        return path;
    }

    @Override
    public void write(String data, String path, Modes modes) throws Throwable {}
}
