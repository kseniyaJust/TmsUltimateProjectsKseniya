package org.example.proxy;

public class ProxyFox implements Fox {
    RealFox realFox;

    @Override
    public void sound(int password) {
        if (password == 1234) {
            realFox = new RealFox();
            realFox.sound(password);
        } else {
            System.out.println("What does the fox say? Ring-ding-ding-ding-dingeringeding");
        }
    }
}
