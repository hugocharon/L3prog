package modeleExercice2RMI;

public class Utilisateur {
    private String pseudo;

    private String mdp;


    public Utilisateur(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public boolean checkPassword(String mdp) {
        return this.mdp.equals(mdp);
    }

}
