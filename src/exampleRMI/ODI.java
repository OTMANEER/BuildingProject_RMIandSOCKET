package exampleRMI;
import java.rmi.*;
import java.io.*;

public interface ODI extends Remote {
    public int getRandom() throws RemoteException ;
    public int getCalls() throws RemoteException ;
}
