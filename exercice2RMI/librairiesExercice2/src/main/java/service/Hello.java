package service;


import dto.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {


    String hello() throws RemoteException;

    Message salut(String nom) throws RemoteException;


}
