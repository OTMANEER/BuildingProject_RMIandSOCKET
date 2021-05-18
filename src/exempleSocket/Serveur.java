package exempleSocket;

import app.Building;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1998);
            System.out.println("J'attend la connexion d'un client");
            Socket ss = s.accept();
            InputStream is = ss.getInputStream();// one bit
            ObjectInputStream iss = new ObjectInputStream(is);
            Toto t = (Toto)iss.readObject();
            System.out.println("taille est:"+t.taille);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
