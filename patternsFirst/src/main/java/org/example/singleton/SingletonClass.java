package org.example.singleton;

public final class SingletonClass {

    private static SingletonClass instance;
    public String value;

    private SingletonClass(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonClass getInstance(String value) {
        if (instance == null) {
            instance = new SingletonClass(value);
        }
        return instance;
    }

}
