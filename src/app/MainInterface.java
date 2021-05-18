package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MainInterface extends Remote {
    void addRoomOut(String name, int boden , double groeße) throws RemoteException;
    String allRoomsNameOut() throws RemoteException;
    String BuildingName() throws RemoteException;
}
