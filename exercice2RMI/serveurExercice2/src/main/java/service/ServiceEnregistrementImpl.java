package service;

import dto.ParametresIncorrectsException;
import dto.PseudoDejaPrisException;
import dto.UtilisateurDTO;
import modeleExercice2RMI.FacadeEnregistrement;
import modeleExercice2RMI.FacadeEnregistrementImpl;
import modeleExercice2RMI.Utilisateur;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

public class ServiceEnregistrementImpl implements ServiceEnregistrement{

    private FacadeEnregistrement facadeEnregistrement = new FacadeEnregistrementImpl();

    @Override
    public void inscription(String pseudo, String mdp) throws PseudoDejaPrisException, ParametresIncorrectsException, RemoteException {
        this.facadeEnregistrement.inscription(pseudo,mdp);
    }

    @Override
    public void inscription2(String pseudo, String mdp) throws PseudoDejaPrisException, ParametresIncorrectsException, RemoteException {
        this.facadeEnregistrement.inscription2(pseudo,mdp);
    }

    @Override
    public Collection<UtilisateurDTO> getPersonnesInscrites() throws RemoteException {
        Collection<Utilisateur> utilisateurs = this.facadeEnregistrement.getPersonnesInscrites();
        ArrayList<UtilisateurDTO> resultat = new ArrayList<>();

        for (Utilisateur u : utilisateurs) {
            resultat.add(new UtilisateurDTO(u.getPseudo()));
        }

        return resultat;
    }
}
