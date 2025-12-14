package org.example.builder;

public class WoodHouseBuilder implements HouseBuilder {

    String typeHouse;
    String typeDoor;
    String typeWindow;
    String typeRoof;
    int countRooms;

    @Override
    public void setTypeHouse() {
        this.typeHouse = "wooden house";
    }

    @Override
    public void setRooms() {
        this.countRooms = 4;
    }

    @Override
    public void setRoofType() {
        this.typeRoof = "wooden roof";
    }

    @Override
    public void setDoorType() {
        this.typeDoor = "wooden doors";
    }

    @Override
    public void setWindowType() {
        this.typeWindow = "wooden windows";
    }

    @Override
    public House build() {
        return new House(typeHouse, typeDoor, typeWindow, typeRoof, countRooms);
    }
}
