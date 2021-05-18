package app;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rep=0;
        int rep1=0;
        Socket socket;
        try {
            socket = new Socket("localhost",1998);
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("You have two building, Choose one type 1 or 2");
            do {
                System.out.print("give a correct building number: ");
                rep = sc.nextInt();
            }while((rep!=1) && (rep!=2));
            outputStream.write(rep);
            System.out.print(" You have two methods choose (1-Print or 2- Add): "
            );
            do {
                sc.nextLine();
                rep1 = sc.nextInt();
                System.out.println(rep+" "+rep1);
            }while((rep1!=1) && (rep1!=2));
            outputStream.write(rep1);
          //  ByteArrayInputStream btti = new ByteArrayInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
           int length = .readInt();                    // read length of incoming message
            System.out.println(length);
       /*     byte[] message = new byte[length];
                 dIn.readFully(message, 0, message.length); // read the message
*/
           /*     Building building = (Building) objectInputStream.readObject();
                System.out.println(building.getName());*/

       } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
