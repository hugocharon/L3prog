package exercice1;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Launch {

    public static void main(String[] args) {

        try {
            Hello h = new HelloImpl();
            Hello stub= (Hello) UnicastRemoteObject.exportObject(h,0);
            Registry registry = LocateRegistry.getRegistry("localhost");
            registry.bind("MonService",stub);
            System.out.println("Service Hello enregistré !");

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
