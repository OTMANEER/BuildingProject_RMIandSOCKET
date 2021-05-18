package app;

import java.rmi.RemoteException;

public class BuildingMain {

    public static void main(String [] args) throws RemoteException {

        Building eins = new Building("Schule");
        eins.addRoom("Klasse 1",2,75.5);
        eins.addRoom("Klasse 2",3,85.5);
        eins.addRoom("Klasse 3",4,105.5);
        System.out.println(eins.allRoomsName());
        System.out.print("Größe aller Räume: ");
        System.out.println(eins.totalSizeAllRooms());
    }
}
