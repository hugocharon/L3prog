package exercice1;

import java.rmi.RemoteException;

public class HelloImpl implements Hello {
    @Override
    public String hello() throws RemoteException {
        return "H . E . L . L . O !!!!!";
    }
}
