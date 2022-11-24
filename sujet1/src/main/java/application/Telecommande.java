package application;

public interface Telecommande {

    void associer(SystemeOuverture systemeOuverture);
    void ouvrirPorte(SystemeOuverture systemeOuverture) throws OuvertureImpossibleException;
}
