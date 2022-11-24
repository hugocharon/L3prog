package service;


import dto.Message;

import java.rmi.RemoteException;

public class HelloImpl implements Hello {
    @Override
    public String hello() throws RemoteException {
        return "H . E . L . L . O !!!!!";
    }

    @Override
    public Message salut(String nom) throws RemoteException {
        Message message = new Message("Salut "+nom);
        return message;
    }


}
