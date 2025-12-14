package org.example.abstractFabric;

public class MacCheckBox implements CheckBox {
    public MacCheckBox() {
        System.out.println("Mac CheckBox created");
        paint();
    }

    @Override
    public void paint() {
        System.out.println("Painted Mac CheckBox");
    }
}
