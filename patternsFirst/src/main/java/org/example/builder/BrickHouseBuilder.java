package org.example.builder;

public class BrickHouseBuilder implements HouseBuilder {

    String typeHouse;
    String typeDoor;
    String typeWindow;
    String typeRoof;
    int countRooms;

    @Override
    public void setWindowType() {
        this.typeWindow = "plastic windows";
    }

    @Override
    public void setDoorType() {
        this.typeDoor = "metal doors";
    }

    @Override
    public void setRoofType() {
        this.typeRoof = "brick roof";
    }

    @Override
    public void setRooms() {
        this.countRooms = 3;
    }

    @Override
    public void setTypeHouse() {
        this.typeHouse = "brick house";
    }

    @Override
    public House build() {
        return new House(typeHouse, typeDoor, typeWindow, typeRoof, countRooms);
    }
}
