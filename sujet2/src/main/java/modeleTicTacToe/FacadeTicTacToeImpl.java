package modeleTicTacToe;

import java.util.UUID;

public class FacadeTicTacToeImpl implements FacadeTicTacToe {


    private Partie partie;


    @Override
    public void creerPartie(String j1, String j2) throws NomsIdentiquesException {
        if (j1.equals(j2)) {
            throw new NomsIdentiquesException();
        }
        this.partie = new Partie(j1,j2);


    }

    @Override
    public void jouer(int x, int y) throws PartieTermineeException, CaseNonValideException, CoupDejaJoueException {
        this.partie.jouer(x,y);
    }


    @Override
    public String getVainqueur() throws PasDeVainqueurException {
        return this.partie.getVainqueur();
    }

    @Override
    public boolean partieTerminee() {
        return this.partie.partieTerminee();
    }

    @Override
    public String getJoueurCourant() {
        return this.partie.getJoueurCourant();
    }

    @Override
    public int[][] getPlateau() {
        return this.partie.getPlateau();
    }

}
