package org.example.builder;

public class House {
    String typeHouse;
    String typeDoor;
    String typeWindow;
    String typeRoof;
    int countRooms;


    public House(String typeHouse, String typeDoor, String typeWindow, String typeRoof, int countRooms) {
        this.typeHouse = typeHouse;
        this.typeDoor = typeDoor;
        this.typeWindow = typeWindow;
        this.typeRoof = typeRoof;
        this.countRooms = countRooms;
    }


    @Override
    public String toString() {
        return "House: { " + typeHouse + ", "
                + countRooms + ", "
                + typeDoor + ", "
                + typeWindow + ", "
                + typeRoof + "} ";


    }
}
