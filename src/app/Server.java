package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Building b1 = null;
        Scanner scanner = new Scanner(System.in);
        ServerSocket socket=null;
        int s=0,s1=0,s2=0;
        int counter = 0;
        int counter1 = 0;
        int inputChoice=-1;
        try {
            socket = new ServerSocket(1998);
            System.out.println("Waiting for connexion...");
            Socket ss = socket.accept();
            System.out.println("Connected");
            do{
                InputStream is = ss.getInputStream();
                OutputStream os = ss.getOutputStream();
                PrintWriter out = new PrintWriter(os,true);
                DataOutputStream dout = new DataOutputStream(ss.getOutputStream());

                s=0;
            System.out.println("Waiting for your choice building 1 or 2");
            s =is.read();
            System.out.println("Building:"+s);
            if(s==1 && counter==0){
                counter++;
                b1= new Building("First");
                b1.addRoom("go",10,123.1);
                b1.addRoom("kit",12,2);
                b1.addRoom("bed",12,2);
                b1.addRoom("go",10,123.1);
                b1.addRoom("kit",12,2);
                b1.addRoom("bed",12,2);
                s=-1;
            }else if(s==2&& counter1==0){
                counter1++;
                b1= new Building("Second");
                b1.addRoom("Cawk",10,123.1);
                b1.addRoom("Smoot",12,2);
                b1.addRoom("Red",12,2);
                b1.addRoom("Cawk",10,123.1);
                b1.addRoom("Smoot",12,2);
                b1.addRoom("Red",12,2);
                s=-1;
            }

            out.println("You have two methods");
            out.println("1-Print Rooms");
            out.println("2-Add a Room");
            out.println("-Type 1/2:");
            s1 = is.read();
                System.out.println("Nb: "+s1);
             if (s1 ==1) {
                 System.out.println("Invocation of Print Rooms Method");
                 out.println("Invocation of Print Rooms Method\n");
                 byte[] toSend = toByteArray(b1);
                 System.out.println("Object Size:"+toSend.length+" Bytes");
                 dout.writeInt(toSend.length);
                 dout.write(toSend,0,toSend.length);
                 System.out.println("Done");
                 s1=-1;
             }
             if(s1 == 2){
                 out.println("Invocation of addRoom Method\n");
                 System.out.println("Waiting for room information...");
                 ObjectInputStream ib = new ObjectInputStream(is);
                 Message m = (Message) ib.readObject();
                 out.println("We received the following informations:  name="+m.getName() +" , floor="+m.getFloor() +" , size="+ m.getSize());

                 System.out.println("Object Received.");
                 System.out.println("We are working to add it");
                 assert b1 != null;
                 b1.addRoom(m.getName(),m.getFloor(),m.getSize());
                 System.out.println("your room is added!");
                 out.println("your room is added!" );
                 s1=-1;
             }

                out.println(" 1- to Continue.");
                out.println(" 0- to Exit");
                out.println("Choose a correct number: ");
                inputChoice =is.read();
                System.out.println("Input Choice: "+inputChoice);
            }while (inputChoice == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            assert socket != null;
            socket.close();
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
            oos.flush(); // put off all the data to BOS
            bytes =bos.toByteArray();
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
