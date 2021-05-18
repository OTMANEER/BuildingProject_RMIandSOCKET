package exempleSocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{

    public static void main(String[] args) {
        Socket s;
            try {
                s = new Socket("localhost",1998);
                //InputStream is = s.getInputStream();

                byte[] data = new byte[1024];
                DataInputStream dIn = new DataInputStream(s.getInputStream());
                   int result =  dIn.read(data); // read the message

               // int received = is.read();
                Toto t =(Toto) toObject(data);
                System.out.println(t.taille);
                System.out.println("OOOK");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
        return obj;
    }
}

