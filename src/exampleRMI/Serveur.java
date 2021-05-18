package exampleRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        OD o = null;
        try {
            o = new OD();
            LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/od",o);
        System.out.println("C est bon "+o);
        } catch (Exception e) {
            System.out.println("Erreur");
            e.printStackTrace();
        }
    }
}
