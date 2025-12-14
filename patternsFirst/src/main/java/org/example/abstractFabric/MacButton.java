package org.example.abstractFabric;

public class MacButton implements Button {
    public MacButton() {
        System.out.println("Mac Button created");
        paint();
    }

    @Override
    public void paint() {
        System.out.println("Painted Mac Button");
    }
}
