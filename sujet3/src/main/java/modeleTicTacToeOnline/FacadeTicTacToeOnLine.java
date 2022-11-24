package modeleTicTacToeOnline;

public interface FacadeTicTacToeOnLine {

    /**
     * Permet de créer une partie entre les joueurs j1 et j2
     * @param j1 : nom du joueur 1
     * @param j2 : nom du joueur 2
     * @return : identifiant aléatoire de la partie qui vient d'être créée
     * @throws NomsIdentiquesException : les deux noms sont identiques (j1 et j2)
     */
    String creerPartie(String j1, String j2) throws NomsIdentiquesException;


    void rejoindrePartie(String invite, String identifiantPartie) throws PartieInconnueException,
            InviteInnattenduException;



    /**
     * Permet au joueur courant de jouer en (x,y)
     * @param idPartie : identifiant de la partie
     * @param nomJoueur : nom du joueur qui veut jouer
     * @param x : indice de la ligne
     * @param y : y indice de la colonne
     * @throws PartieTermineeException : on essaie de jouer alors que c'est fini
     * @throws CaseNonValideException : Visiblement (x,y) n'existe pas
     * @throws CoupDejaJoueException : Visiblement (x,y) a déjà été joué par le passé
     * @throws PartieInconnueException : l'identifiant ne correspond à aucune partie en cours
     * @throws PasTonTourException : le joueur qui essaie de jouer n'est pas celui attendu
     */
    void jouer(String idPartie, String nomJoueur, int x, int y) throws
            PartieTermineeException, CaseNonValideException, CoupDejaJoueException,
            PartieInconnueException, PasTonTourException;


    /**
     * Permet de retourner le vainqueur de la partie si ce dernier existe
     * @return le nom du vainqueur
     * @throws PasDeVainqueurException : Il n'y a pas encore de vainqueur
     * @param idPartie
     */
    String getVainqueur(String idPartie) throws PasDeVainqueurException, PartieInconnueException;

    /**
     * Permet de savoir si la partie est terminée
     * @return vrai si (tous les coups joués) ou (un vainqueur). Faux sinon
     * @param idPartie
     */

    boolean partieTerminee(String idPartie) throws PartieInconnueException;

    /**
     * Permet de récupérer l'identifiant du joueur courant
     * @return ID du joueur courant
     * @param idPartie
     */
    String getJoueurCourant(String idPartie) throws PartieInconnueException;


    /**
     * Permet de récupére la matrice représentant l'état du plateau
     * @return matrice du plateau
     * @param idPartie
     */
    int[][] getPlateau(String idPartie) throws PartieInconnueException;

}
