package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.security.spec.RSAOtherPrimeInfo;

public class Server {
    public static void main(String[] args) {
        Building b1 = null;
        Building b2 = null;
        int s=0,s1=0,s2=0;
        try {
            b1 = new Building("Building1");
            b1.addRoom("tata",5,19.21);
            b1.addRoom("uoup",5,19.21);
            b1.addRoom("tareata",5,19.21);
            b2 = new Building("Building2");
            b2.addRoom("lowla",4,11.5);
            b2.addRoom("nana",4,11.5);
            b2.addRoom("kdf",4,11.5);

            ServerSocket socket = new ServerSocket(1998);
            System.out.println("Waiting for connexion...");
            Socket ss = socket.accept();
            InputStream is = ss.getInputStream();
            OutputStream os = ss.getOutputStream();
            System.out.println("Connexion OK!");
                System.out.println("Waiting for your choice building 1 or 2");
                s =is.read();
            System.out.println(s);
            s1 = is.read();
            Building b = new Building("SASA");
            b.addRoom("ot",10,123.1);
            ByteArrayOutputStream btt = new ByteArrayOutputStream();
          //  ObjectOutputStream objectOutputStream = new ObjectOutputStream(btt);

                byte[] yourBytes = btt.toByteArray();
                System.out.println(yourBytes.length);
                DataOutputStream dataOutputStream = new DataOutputStream(ss.getOutputStream());
                os.write(yourBytes.length); // write length of the object
             /*   dataOutputStream.write(yourBytes);*/

           /*     objectOutputStream.writeObject(b);// ONE
                objectOutputStream.flush();
*/

        } catch (Exception e) {
            System.out.println("Errors!!!!!!!!");
        }
    }
}
