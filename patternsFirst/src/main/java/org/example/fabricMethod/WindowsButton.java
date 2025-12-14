package org.example.fabricMethod;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Window's button characteristic");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Windows button says - Hello from Windows");
    }
}
