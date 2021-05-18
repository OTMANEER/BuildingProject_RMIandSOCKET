package exempleSocket;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{

    public static void main(String[] args) {
        Socket s;
            try {
                s = new Socket("localhost",1998);
                OutputStream is = s.getOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(is);
                Toto c = new Toto(10);
                os.writeObject(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


}
