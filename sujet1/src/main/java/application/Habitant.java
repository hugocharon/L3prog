package application;

public class Habitant {

    private Telephone telephone;
    private Telecommande telecommande;

    public Telephone getTelephone() {
        return telephone;
    }


    public Telecommande getTelecommande() {
        return telecommande;
    }


    public Habitant(Telephone telephone, Telecommande telecommande) {
        this.telephone = telephone;
        this.telecommande = telecommande;
    }



    public void ouvrir(SystemeOuverture systemeOuverture) throws OuvertureImpossibleException {

        this.telecommande.ouvrirPorte(systemeOuverture);
    }
}
