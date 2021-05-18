package app;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int rep=0;
        int rep1=0;
        Socket socket = null;
        int inputChoice=-1;

        try {
            socket = new Socket("localhost",1998);

            do{
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataInputStream dIn = new DataInputStream(socket.getInputStream());
            System.out.println("You have two building, Choose one type 1 or 2");
            do {
                System.out.print("give a correct building number: ");

                rep = scanner.nextInt();
            }while((rep!=1) && (rep!=2));
            outputStream.write(rep);
            rep=-1;
            System.out.println("----------------------------------------------");
            System.out.println(bfr.readLine());
            System.out.println("");
            System.out.println(bfr.readLine());
            System.out.println(bfr.readLine());
            System.out.println(bfr.readLine());
            do { System.out.print("give a correct number: ");
                scanner.nextLine();
                rep1 = scanner.nextInt();
            }while((rep1!=1) && (rep1!=2));
            outputStream.write(rep1);
                System.out.println("Sent "+rep1);
            if(rep1 == 1){
                System.out.println("--------------------------------------------");
                System.out.println(bfr.readLine());
                System.out.println("-----------------------------------------------------");

                int length = dIn.readInt();// the length here is data.length
                byte[] data = new byte[length];
                int result =  dIn.read(data,0,length); // read the message
                Building t =(Building) toObject(data);
                System.out.println(t.getRooms());
                rep1=-1;
                data = null;
            }
            if(rep1 == 2){
                System.out.println("-----------------------------------------------------");
                System.out.println(bfr.readLine());
                System.out.println("-----------------------------------------------------");
                System.out.println("To add A room we need the following informations.");
                String name;
                int floor;
                double size;
                System.out.print("Name of Room: ");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.print("Floor:");
                floor = scanner.nextInt();
                System.out.print("Size:");
                size = scanner.nextDouble();
                Message message = new Message(name,floor,size);
                System.out.println(bfr.readLine());
                ObjectOutputStream ob = new ObjectOutputStream(outputStream);
                ob.writeObject(message);
                System.out.println(bfr.readLine());
                rep1=-1;
            }
                System.out.println(bfr.readLine());
                System.out.println(bfr.readLine());
                System.out.println(bfr.readLine());


                do {
                    System.out.print("give a correct number: ");
                    inputChoice = scanner.nextInt();
                }while((inputChoice!=0) && (inputChoice!=1));
                outputStream.write(inputChoice);
                rep=-1;
                rep1=-1;
            }while(inputChoice==1);
       } catch (Exception e) {
            e.printStackTrace();
        }finally {
            assert socket != null;
            socket.close();
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
