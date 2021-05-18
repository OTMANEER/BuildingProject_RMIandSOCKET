package app;

import java.io.Serializable;
import java.util.ArrayList;

public class Building implements Serializable {
	
    private String name;
    private ArrayList<Room> rooms;

    public Building(String name){
        super();
        this.name=name;
        rooms = new ArrayList<Room>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public Room searchRoom(String raumName){
        for(Room r : rooms){
            if(r.getName().equals(raumName)){
                return r;
            }
        }
        return null;
    }

    public void addRoom(String name, int boden , double groeße){
        if(this.rooms != null)
        rooms.add(new Room(name,boden,groeße));
    }

    public String allRoomsName(){
        StringBuilder s= new StringBuilder();
        for(Room r : rooms){
            s.append(r.getName()).append(" ");
        }
        return s.toString();
    }

    public double totalSizeAllRooms(){
        double gesamt=0.0;
        for(Room r : rooms){
        	gesamt += r.getSize();
        }
        return gesamt;
    }
}
