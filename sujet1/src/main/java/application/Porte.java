package application;

public class Porte {

    private String nom;

    public Porte(String nom) {
        this.nom = nom;
    }


    public void ouvrir(){
        System.out.println("Porte "+ nom + " ouverte !!!!");
    }
}
