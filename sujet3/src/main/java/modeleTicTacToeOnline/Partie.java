package modeleTicTacToeOnline;

import java.util.UUID;

public class Partie {

    private String[] joueurs;
    private int indiceJoueurCourant;

    private int [][] plateau;

    private int nbCoupsJoues;


    private int[] tableauScore;

    private String idPartie;
    /*
    tableauScore[0]= plateau[0][0] + plateau[0][1] + plateau[0][2]
    tableauScore[1]= plateau[1][0] + plateau[1][1] + plateau[1][2]
    tableauScore[2]= plateau[2][0] + plateau[2][1] + plateau[2][2]
    tableauScore[3]= plateau[0][0] + plateau[1][0] + plateau[2][0]
    tableauScore[4]= plateau[0][1] + plateau[1][1] + plateau[2][1]
    tableauScore[5]= plateau[0][2] + plateau[1][2] + plateau[2][2]
    tableauScore[6]= plateau[0][0] + plateau[1][1] + plateau[2][2]
    tableauScore[7]= plateau[0][2] + plateau[1][1] + plateau[2][0]
     */
    public Partie(String joueur1, String joueur2) {
        this.joueurs = new String[]{joueur1,joueur2};
        this.indiceJoueurCourant =0;
        this.plateau = new int[3][3];
        this.nbCoupsJoues = 0;
        this.tableauScore = new int[8];
        this.idPartie = UUID.randomUUID().toString();
    }

    public String getIdPartie() {
        return idPartie;
    }

    public void jouer(String nomJoueur, int x, int y) throws PartieTermineeException, CaseNonValideException, CoupDejaJoueException, PasTonTourException {

        if (!this.getJoueurCourant().equals(nomJoueur)) {
            throw new PasTonTourException();
        }

        if (this.partieTerminee()) {
            throw new PartieTermineeException();
        }

        if (x <0 || x>2 || y<0 || y>2) {
            throw new CaseNonValideException();
        }


        if (this.plateau[x][y] != 0) {
            throw new CoupDejaJoueException();
        }

        this.nbCoupsJoues++;
        this.plateau[x][y] = this.indiceJoueurCourant == 0?1:4;
        this.indiceJoueurCourant = (this.indiceJoueurCourant+1)%2;

        this.majScore(x,y);

    }

    private void majScore(int x, int y) {

        if ((x+y)%2 == 0) {
            this.tableauScore[x] = this.plateau[x][y]+ this.plateau[x][(y+1)%3]+ this.plateau[x][(y+2)%3];
            this.tableauScore[y+3] = this.plateau[x][y]+ this.plateau[(x+1)%3][y]+ this.plateau[(x+2)%3][y];
            this.tableauScore[6] = plateau[0][0] + plateau[1][1] + plateau[2][2];
            this.tableauScore[7] = plateau[2][0] + plateau[1][1] + plateau[0][2];
        }

        else {
            this.tableauScore[x] = this.plateau[x][y]+ this.plateau[x][(y+1)%3]+ this.plateau[x][(y+2)%3];
            this.tableauScore[y+3] = this.plateau[x][y]+ this.plateau[(x+1)%3][y]+ this.plateau[(x+2)%3][y];
        }

    }

    public String getVainqueur() throws PasDeVainqueurException {

        for (int x : this.tableauScore) {
            if (x == 12)
                return joueurs[1];
            if (x==3)
                return joueurs[0];
        }

        throw new PasDeVainqueurException();
    }

    public boolean partieTerminee() {
        if (nbCoupsJoues == 9)
            return true;

        try {
            this.getVainqueur();
            return true;
        } catch (PasDeVainqueurException e) {
            return false;
        }
    }

    public String getJoueurCourant() {
        return this.joueurs[indiceJoueurCourant];

    }

    public int[][] getPlateau() {
        return this.plateau;
    }

    public void verifierInvite(String invite) throws InviteInnattenduException {

        if (!this.joueurs[1].equals(invite)) {
            throw new InviteInnattenduException();
        }
    }
}
