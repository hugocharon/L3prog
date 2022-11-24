package service;


import dto.Message;
import dto.ParametresIncorrectsException;
import dto.PseudoDejaPrisException;
import dto.UtilisateurDTO;

import javax.swing.text.Utilities;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

public interface ServiceEnregistrement extends Remote {


   void inscription(String pseudo, String mdp) throws PseudoDejaPrisException,
           ParametresIncorrectsException, RemoteException;

   void inscription2(String pseudo, String mdp) throws PseudoDejaPrisException,
           ParametresIncorrectsException, RemoteException;

   Collection<UtilisateurDTO> getPersonnesInscrites() throws RemoteException;



}
