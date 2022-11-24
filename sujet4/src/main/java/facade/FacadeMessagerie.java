package facade;

import java.util.Collection;

public interface FacadeMessagerie {
    void inscription(String yohan, String motdePasse) throws PseudoDejaPrisException, DonneesIncompletesException;

    String connexion(String yohan, String motdePasse);

    void envoyerMessage(String cle, String utilisateur, String message);

    void deconnexion(String cle);

    Collection<Discussion> getAllDiscussions(String cle);
}
