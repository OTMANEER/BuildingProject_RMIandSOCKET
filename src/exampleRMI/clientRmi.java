package exampleRMI;
import java.rmi.Naming;

public class clientRmi {
    public static void main(String[] args) {
        try {
           ODI i=(ODI)Naming.lookup("rmi://localhost:1099/od");
           for (int iu=0;iu<10;iu++){
               System.out.println(i.getRandom());
           }
            System.out.println(i.getCalls());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
