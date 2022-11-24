package application;

public class TelephoneClassique implements Telephone{
    @Override
    public void telephoner() {
        System.out.println("Youhou ça sonne, mais c'est un pauvre téléphone...");
    }
}
