package org.example.proxy;

public class RealFox implements Fox {
    @Override
    public void sound(int password) {
        System.out.println("Your password: " + password + " \nI am a real fox. Yap-yap-yap");
    }
}
