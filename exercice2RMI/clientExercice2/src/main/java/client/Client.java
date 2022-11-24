package client;

import dto.Message;
import dto.ParametresIncorrectsException;
import dto.PseudoDejaPrisException;
import dto.UtilisateurDTO;
import service.Hello;
import service.ServiceEnregistrement;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(8890);
            Hello service = (Hello) registry.lookup("MonService");

            ServiceEnregistrement serviceEnregistrement = (ServiceEnregistrement) registry.lookup("serviceUtilisateurs");

            Scanner scanner = new Scanner(System.in);

            System.out.println("pseudo :");
            String pseudo = scanner.next();
            System.out.println("password :");
            String mdp = scanner.next();
            serviceEnregistrement.inscription2(pseudo, mdp);

            Collection<UtilisateurDTO> personnes = serviceEnregistrement.getPersonnesInscrites();


            for (UtilisateurDTO u : personnes) {
                System.out.println(u.getPseudo());
            }

        }catch (AccessException accessException) {
            accessException.printStackTrace();
        } catch (NotBoundException notBoundException) {
            notBoundException.printStackTrace();
        } catch (ParametresIncorrectsException parametresIncorrectsException) {
            parametresIncorrectsException.printStackTrace();
        } catch (PseudoDejaPrisException pseudoDejaPrisException) {
            pseudoDejaPrisException.printStackTrace();
        } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }

    }
}
