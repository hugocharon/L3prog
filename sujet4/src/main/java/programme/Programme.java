package programme;

import facade.Discussion;
import facade.DonneesIncompletesException;
import facade.FacadeMessagerie;
import facade.PseudoDejaPrisException;

import java.util.Collection;

public class Programme {


    public static void main(String[] args) throws PseudoDejaPrisException, DonneesIncompletesException {

        FacadeMessagerie facadeMessagerie = null;

        facadeMessagerie.inscription("Yohan","MotdePasse");

        facadeMessagerie.inscription("Fred","MotdePasseFred");

        String cle = facadeMessagerie.connexion("Yohan","MotdePasse");

        facadeMessagerie.envoyerMessage(cle,"Fred","C'est génial ce module ! ");
        facadeMessagerie.deconnexion(cle);

        String cleFred = facadeMessagerie.connexion("Fred","MotdePasseFred");

        Collection<Discussion> discussionsFred = facadeMessagerie.getAllDiscussions(cleFred);
        facadeMessagerie.deconnexion(cleFred);







    }
}
