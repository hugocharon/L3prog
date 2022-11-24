package application;

public class SystemeOuverture {


    private Porte porteeControlee;

    public SystemeOuverture(Porte porteeControlee) {
        this.porteeControlee = porteeControlee;
    }


    public void deverouillerPorte() {
        this.porteeControlee.ouvrir();
    }


}
