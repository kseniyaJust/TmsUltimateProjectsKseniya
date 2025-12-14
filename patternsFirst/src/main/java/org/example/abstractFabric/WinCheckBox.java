package org.example.abstractFabric;

public class WinCheckBox implements CheckBox {
    public WinCheckBox() {
        System.out.println("Win CheckBox created");
        paint();
    }

    @Override
    public void paint() {
        System.out.println("Painted Win CheckBox");
    }
}
