package shon.encryptor.conveters;


public class ConvertHandler {
    public static int StringToInt(String stringValue) throws NumberFormatException {
        return Integer.parseInt(stringValue);
    }
    public static int StringToByte(String stringValue) throws NumberFormatException {
        return Byte.parseByte(stringValue);
    }


}
