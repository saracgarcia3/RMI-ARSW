package edu.eci.networking.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatPeerImpl extends UnicastRemoteObject implements ChatPeer {

    private String name;

    public ChatPeerImpl(String name) throws RemoteException {
        super();
        this.name = name;
    }

    @Override
    public void sendMessage(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
}
