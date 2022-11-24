package modeleExercice2RMI;

import dto.ParametresIncorrectsException;
import dto.PseudoDejaPrisException;

import java.util.Collection;

public interface FacadeEnregistrement {


    void inscription(String pseudo, String mdp) throws PseudoDejaPrisException, ParametresIncorrectsException;

    void inscription2(String pseudo, String mdp) throws PseudoDejaPrisException, ParametresIncorrectsException;

    Collection<Utilisateur> getPersonnesInscrites();

}
