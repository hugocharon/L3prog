package application;

public class SmartPhone  implements Telecommande, Telephone{

    private SystemeOuverture systemeOuvertureGere;

    @Override
    public void associer(SystemeOuverture systemeOuverture) {
        this.systemeOuvertureGere = systemeOuverture;
    }

    @Override
    public void ouvrirPorte(SystemeOuverture systemeOuverture) throws OuvertureImpossibleException {
        if (this.systemeOuvertureGere != systemeOuverture) {
            throw new OuvertureImpossibleException();
        }
        else {
            systemeOuverture.deverouillerPorte();
        }
    }

    @Override
    public void telephoner() {
        System.out.println("Youhou ça sonne !!!");
    }
}
