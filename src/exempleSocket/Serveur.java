package exempleSocket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1998);
            System.out.println("J'attend la connexion d'un client");
            Socket ss = s.accept();
            Toto t = new Toto(101);
            byte[] toSend = toByteArray(t);
            System.out.println(toSend.length);
            DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
            dout.write(toSend);
        } catch (Exception e) {
            System.out.println("Fails");
        }
    }

    public static byte[] toByteArray(Object obj) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return bytes;
    }
}
