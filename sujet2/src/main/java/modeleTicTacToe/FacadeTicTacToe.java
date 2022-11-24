package modeleTicTacToe;

public interface FacadeTicTacToe {

    /**
     * Permet de créer une partie entre les joueurs j1 et j2
     * @param j1 : nom du joueur 1
     * @param j2 : nom du joueur 2
     * @throws NomsIdentiquesException : les deux noms sont identiques (j1 et j2)
     */
    void creerPartie(String j1, String j2) throws NomsIdentiquesException;


    /**
     * Permet au joueur courant de jouer en (x,y)
     * @param x : indice de la ligne
     * @param y : y indice de la colonne
     */
    void jouer(int x, int y) throws PartieTermineeException, CaseNonValideException, CoupDejaJoueException;


    /**
     * Permet de retourner le vainqueur de la partie si ce dernier existe
     * @return le nom du vainqueur
     * @throws PasDeVainqueurException : Il n'y a pas encore de vainqueur
     */
    String getVainqueur() throws PasDeVainqueurException;

    /**
     * Permet de savoir si la partie est terminée
     * @return vrai si (tous les coups joués) ou (un vainqueur). Faux sinon
     */

    boolean partieTerminee();

    /**
     * Permet de récupérer l'identifiant du joueur courant
     * @return ID du joueur courant
     */
    String getJoueurCourant();


    /**
     * Permet de récupére la matrice représentant l'état du plateau
     * @return matrice du plateau
     */
    int[][] getPlateau();

}
