package facade;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FacadeMessagerieImpl implements FacadeMessagerie{

    Map<String,Personne> personnes;


    public FacadeMessagerieImpl() {
        personnes = new HashMap<>();
    }

    @Override
    public void inscription(String yohan, String motdePasse) throws PseudoDejaPrisException,
            DonneesIncompletesException {

        if ( Objects.isNull(yohan) || Objects.isNull(motdePasse)
                || yohan.isBlank() || motdePasse.isBlank()) {
            throw new DonneesIncompletesException();
        }

        if (personnes.containsKey(yohan)) {
            throw new PseudoDejaPrisException();
        }

        Personne personne = new Personne(yohan,motdePasse);
        this.personnes.put(personne.getPseudo(),personne);

    }

    @Override
    public String connexion(String yohan, String motdePasse) {
        return null;
    }

    @Override
    public void envoyerMessage(String cle, String utilisateur, String message) {

    }

    @Override
    public void deconnexion(String cle) {

    }

    @Override
    public Collection<Discussion> getAllDiscussions(String cle) {
        return null;
    }
}
