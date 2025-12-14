package org.example;

import org.example.abstractFabric.GUIFactory;
import org.example.abstractFabric.MacFactory;
import org.example.abstractFabric.Winfactory;
import org.example.fabricMethod.Dialog;
import org.example.fabricMethod.HtmlDialog;
import org.example.fabricMethod.WinDialog;
import org.example.builder.BrickHouseBuilder;
import org.example.builder.HouseBuilder;
import org.example.builder.WoodHouseBuilder;
import org.example.prototype.Circle;
import org.example.prototype.Rectangle;
import org.example.prototype.Shape;
import org.example.proxy.Fox;
import org.example.proxy.ProxyFox;
import org.example.singleton.SingletonClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Singleton
        System.out.println("SINGLETON \nIf you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:");
        SingletonClass singleton = SingletonClass.getInstance("FOO");
        SingletonClass anotherSingleton = SingletonClass.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
        System.out.println();

        //FabricMethod
        System.out.print("FABRIC METHOD\n Enter number of fabric: ");
        int numberFabric = scanner.nextInt();
        System.out.println();
        Dialog dialog;
        if (numberFabric == 1) {
            dialog = new WinDialog();
        } else {
            dialog = new HtmlDialog();
        }
        dialog.render();
        System.out.println();

        //AbstractFabric

        System.out.print("ABSTRACT FABRIC\n Enter number of fabric: ");
        int numberAbstractFabric = scanner.nextInt();
        System.out.println();

        GUIFactory factory;
        if (numberAbstractFabric == 1) {
            factory = new Winfactory();
        } else {
            factory = new MacFactory();
        }
        factory.createButton();
        factory.createCheckBox();
        System.out.println();

        //Builder
        System.out.print("BUILDER\n Enter number of builder: ");
        int numberBuilder = scanner.nextInt();
        System.out.println();

        HouseBuilder builder;
        if (numberBuilder == 1) {
            builder = new BrickHouseBuilder();
        } else {
            builder = new WoodHouseBuilder();
        }
        builder.setTypeHouse();
        builder.setDoorType();
        builder.setWindowType();
        builder.setRoofType();
        builder.setRooms();

        System.out.println(builder.build().toString());
        System.out.println();

        //Prototype

        System.out.println("PROTOTYPE");
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle(10, 20, "red", 15);
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.cloneShape();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle("blue", 10, 20);

        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
        System.out.println();

        //Proxy

        System.out.print("PROXY \nEnter password: ");
        int password = scanner.nextInt();
        System.out.println();

        Fox fox = new ProxyFox();
        fox.sound(password);

    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.cloneShape());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}