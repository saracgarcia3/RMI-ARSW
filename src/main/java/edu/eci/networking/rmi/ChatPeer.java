package edu.eci.networking.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatPeer extends Remote {
    void sendMessage(String msg) throws RemoteException;
    String getName() throws RemoteException;
}
