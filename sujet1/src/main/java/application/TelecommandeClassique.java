package application;

public class TelecommandeClassique implements Telecommande {

    private SystemeOuverture systemeOuvertureAssocie;


    @Override
    public void associer(SystemeOuverture systemeOuverture) {
        this.systemeOuvertureAssocie = systemeOuverture;
    }

    @Override
    public void ouvrirPorte(SystemeOuverture systemeOuverture) throws OuvertureImpossibleException {

        if (this.systemeOuvertureAssocie != systemeOuverture) {
            throw new OuvertureImpossibleException();
        }
        else {
            systemeOuverture.deverouillerPorte();
        }
    }
}
