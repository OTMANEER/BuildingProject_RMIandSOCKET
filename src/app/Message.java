package app;

import java.io.Serializable;

public class Message implements Serializable {
    String name;
    int floor;
    double size;
    String Description;

    public Message(String name) {
        this.name = name;
    }

    public Message(String name, int floor, double size) {
        this.name = name;
        this.floor = floor;
        this.size = size;
    }

    public Message(String name, int floor, double size, String description) {
        this.name = name;
        this.floor = floor;
        this.size = size;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
