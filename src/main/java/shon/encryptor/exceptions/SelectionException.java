package shon.encryptor.exceptions;

public class SelectionException extends Exception {
    public SelectionException(String message) {
        super(message);
    }
    public SelectionException(String message,Throwable e) {
        super(message,e);
    }
}
