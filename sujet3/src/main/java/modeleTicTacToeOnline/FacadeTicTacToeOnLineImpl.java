package modeleTicTacToeOnline;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FacadeTicTacToeOnLineImpl implements FacadeTicTacToeOnLine {


    private Map<String,Partie> partiesEnAttente;

    private Map<String,Partie> partieEnCours;

    public FacadeTicTacToeOnLineImpl() {
        this.partieEnCours = new HashMap<>();
        this.partiesEnAttente = new HashMap<>();
    }

    @Override
    public String creerPartie(String j1, String j2) throws NomsIdentiquesException {
        if (j1.equals(j2)) {
            throw new NomsIdentiquesException();
        }
        Partie partie = new Partie(j1,j2);
        // Stockage de la partie dans la structure des parties en attente
        this.partiesEnAttente.put(partie.getIdPartie(),partie);
        return partie.getIdPartie();


    }

    @Override
    public void rejoindrePartie(String invite, String identifiantPartie) throws PartieInconnueException, InviteInnattenduException {

        Partie partie = this.partiesEnAttente.get(identifiantPartie);

        if (Objects.isNull(partie)) {
            throw new PartieInconnueException();
        }

        partie.verifierInvite(invite);

        this.partiesEnAttente.remove(identifiantPartie);
        this.partieEnCours.put(partie.getIdPartie(),partie);

    }

    @Override
    public void jouer(String idPartie, String nomJoueur, int x, int y)
            throws PartieTermineeException, CaseNonValideException, CoupDejaJoueException,
            PartieInconnueException, PasTonTourException {

        Partie partie = this.getPartieEnCoursByid(idPartie);
        partie.jouer(nomJoueur,x,y);
    }



    private Partie getPartieEnCoursByid(String idPartie) throws PartieInconnueException {
        Partie partie = this.partieEnCours.get(idPartie);

        if (Objects.isNull(partie)) {
            throw new PartieInconnueException();
        }
        return partie;
    }


    @Override
    public String getVainqueur(String idPartie) throws PasDeVainqueurException, PartieInconnueException {

        Partie partie = this.getPartieEnCoursByid(idPartie);
        return partie.getVainqueur();
    }

    @Override
    public boolean partieTerminee(String idPartie) throws PartieInconnueException {
        Partie partie = this.getPartieEnCoursByid(idPartie);
        return partie.partieTerminee();
    }

    @Override
    public String getJoueurCourant(String idPartie) throws PartieInconnueException {
        Partie partie = this.getPartieEnCoursByid(idPartie);
        return partie.getJoueurCourant();
    }

    @Override
    public int[][] getPlateau(String idPartie) throws PartieInconnueException {
        Partie partie = this.getPartieEnCoursByid(idPartie);
        return partie.getPlateau();
    }

}
