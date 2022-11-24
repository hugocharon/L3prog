package application;

public class Programme {


    public static void main(String[] args) {

        Porte porte1 = new Porte("Porte1");

        SystemeOuverture systemeOuverturePorte1 = new SystemeOuverture(porte1);


        Porte porte2 = new Porte("Porte2");

        SystemeOuverture systemeOuverturePorte2 = new SystemeOuverture(porte2);


        TelecommandeClassique telecommandeClassique = new TelecommandeClassique();
        telecommandeClassique.associer(systemeOuverturePorte1);
        TelephoneClassique telephoneClassique = new TelephoneClassique();

        SmartPhone smartPhone = new SmartPhone();
        smartPhone.associer(systemeOuverturePorte1);

        Habitant habitant1 = new Habitant(telephoneClassique,telecommandeClassique);
        Habitant habitant2 = new Habitant(smartPhone,smartPhone);


        try {
            habitant1.ouvrir(systemeOuverturePorte1);
            habitant2.ouvrir(systemeOuverturePorte1);
            habitant1.ouvrir(systemeOuverturePorte2);

        } catch (OuvertureImpossibleException e) {
            System.err.println("Ouverture impossible");
        }


    }
}
