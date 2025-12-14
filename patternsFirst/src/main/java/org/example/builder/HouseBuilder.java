package org.example.builder;

public interface HouseBuilder {
    void setTypeHouse();

    void setRooms();

    void setRoofType();

    void setDoorType();

    void setWindowType();

    House build();
}
