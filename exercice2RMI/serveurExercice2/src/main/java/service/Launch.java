package service;

import modeleExercice2RMI.FacadeEnregistrement;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Launch {
    public static void main(String[] args) {

        try {
            Hello h = new HelloImpl();

            ServiceEnregistrement serviceEnregistrement = new ServiceEnregistrementImpl();
            Hello stub= (Hello) UnicastRemoteObject.exportObject(h,0);
            ServiceEnregistrement stub2= (ServiceEnregistrement) UnicastRemoteObject.exportObject(serviceEnregistrement,0);

            Registry registry = LocateRegistry.createRegistry(8890);
            registry.bind("MonService",stub);

            System.out.println("Service Hello enregistré !");
            registry.bind("serviceUtilisateurs",stub2);

            System.out.println("Service serviceUtilisateurs enregistré !");

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
