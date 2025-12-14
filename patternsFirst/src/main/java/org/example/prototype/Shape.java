package org.example.prototype;

import java.util.Objects;

public abstract  class Shape {
    private int x;
    private int y;
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y =y;
        this.color = color;
    }

    public Shape(Shape target){
        this.x = target.x;
        this.y = target.y;
        this.color = target.color;
    }
    public abstract Shape cloneShape();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
}
