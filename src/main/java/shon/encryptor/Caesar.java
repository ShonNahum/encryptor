package shon.encryptor;


public class Caesar implements Algorithems{
    Utils utils = new Utils();

    @Override
    public String encrypt(String data) {
        int shiftKey = utils.randomKey();
        return logic(data,shiftKey,Mode.ENCRYPT);
    }

    @Override
    public String decrypt(String data,int shiftKey) {
        return logic(data,shiftKey,Mode.DECRYPT);

    }

    private String logic(String data,int shiftKey,Mode mode){

        return data;

    }


}


