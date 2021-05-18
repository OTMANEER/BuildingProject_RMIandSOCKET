package exampleRMI;

import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.util.*;



public class OD extends UnicastRemoteObject implements ODI {
    private Random alea;
    private int calls;

    public OD() throws RemoteException {
         //log("Ctor");
        alea = new Random();
        calls=0;
    }

    @Override
    public int getRandom() throws RemoteException {
     //   log("getRandom() "+this);
        calls++;
        return alea.nextInt();
    }

    @Override
    public int getCalls() throws RemoteException {
       // log("getCalls "+this);
        return calls;
    }
}
