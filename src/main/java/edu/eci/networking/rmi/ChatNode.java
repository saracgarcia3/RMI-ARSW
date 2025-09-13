package edu.eci.networking.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatNode {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: ChatNode <nombre> <puerto> [<hostRemoto> <puertoRemoto> <nombreRemoto>]");
            return;
        }

        String name = args[0];
        int port = Integer.parseInt(args[1]);
        String url = "rmi://localhost:" + port + "/" + name;

        try {
            Registry registry = LocateRegistry.createRegistry(port);
            ChatPeerImpl peer = new ChatPeerImpl(name);
            Naming.rebind(url, peer);
            System.out.println("Peer " + name + " publicado en " + url);

            ChatPeer remote = null;
            if (args.length == 5) {
                String hostRemote = args[2];
                String portRemote = args[3];
                String nameRemote = args[4];
                String remoteUrl = "rmi://" + hostRemote + ":" + portRemote + "/" + nameRemote;
                remote = (ChatPeer) Naming.lookup(remoteUrl);
                System.out.println("Conectado a " + nameRemote + " en " + remoteUrl);
            }

            Scanner sc = new Scanner(System.in);
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("/quit")) {
                    break;
                }
                if (remote != null) {
                    remote.sendMessage(name + ": " + line);
                }
            }
            sc.close();

        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
