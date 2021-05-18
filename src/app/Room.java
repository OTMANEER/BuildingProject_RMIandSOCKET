package app;//import java.util.ArrayList;

public class Room {

    private final String name;
    private final int floor;
    private double size;

    public Room(String name, int etage, double groeße){
        this.name=name;
        this.floor =etage;
        this.size =groeße;
    }

    public String getName(){
        return name;

    }

    public int getFloor(){
        return floor;
    }

    public double getSize(){
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String toString(){
        return "app.Room: " + this.getName()+" , Etage: "+this.getFloor()+" , Size: "+this.getSize()+" Quadratmeter\n";

    }
}
