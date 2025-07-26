package shon.encryptor;
import shon.encryptor.ModeMenu.ModeStarter;

public class Encryptor {
 // private final = Instance should not change (best practice) (ask yonke to explain better)
    private final ModeStarter modeStarter = new ModeStarter();


    public void startEncryptor() {
        modeStarter.start();
        }

}
