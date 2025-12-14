package org.example.abstractFabric;

public class WinButton implements Button {
    public WinButton() {
        System.out.println("Win Button created");
        paint();
    }

    @Override
    public void paint() {
        System.out.println("Painted Win Button");
    }
}
