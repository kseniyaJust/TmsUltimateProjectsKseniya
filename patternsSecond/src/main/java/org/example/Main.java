package org.example;

import org.example.adapter.LegacyPrinter;
import org.example.adapter.PrinterAdapter;
import org.example.chainsOfResponsobility.Level1SupportHandler;
import org.example.chainsOfResponsobility.Level2SupportHandler;
import org.example.chainsOfResponsobility.Level3SupportHandler;
import org.example.decorator.Coffee;
import org.example.decorator.MilkDecorator;
import org.example.decorator.PlainCoffee;
import org.example.decorator.SugarDecorator;
import org.example.facade.HotelKeeper;
import org.example.facade.HotelKeeperImplemintation;
import org.example.observer.Observer;
import org.example.observer.PhoneDisplay;
import org.example.observer.TVDisplay;
import org.example.observer.WeatherStation;
import org.example.strategy.BubbleSortStrategy;
import org.example.strategy.MergeSortStrategy;
import org.example.strategy.QuickSortStrategy;
import org.example.strategy.SortingContext;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Adapter

        System.out.println("Adapter: ");
        PrinterAdapter printerAdapter = new PrinterAdapter(new LegacyPrinter());
        printerAdapter.print();

        //Chains of responsibility
        System.out.println("\nChains of responsibility: ");
        Level1SupportHandler level1SupportHandler = new Level1SupportHandler();
        Level2SupportHandler level2SupportHandler = new Level2SupportHandler();
        Level3SupportHandler level3SupportHandler = new Level3SupportHandler();

        level1SupportHandler.setNextHandler(level2SupportHandler);
        level2SupportHandler.setNextHandler(level3SupportHandler);

        System.out.println("Enter severity of request (1,2,3): ");
        int severityUser = scanner.nextInt();

        level1SupportHandler.handleRequest(severityUser);
        //Decorator

        System.out.println("\nDecorator: ");
        //PlainCoffee
        Coffee coffee = new PlainCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());
        // Coffee with Milk
        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        System.out.println("Description: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getCost());
        // Coffee with Sugar and Milk
        Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new PlainCoffee()));
        System.out.println("Description: " + sugarMilkCoffee.getDescription());
        System.out.println("Cost: $" + sugarMilkCoffee.getCost());

        //Facade

        System.out.println("\nFacade: ");
        HotelKeeper keeper = new HotelKeeperImplemintation();

        String vegMenu = keeper.getVegMenu();
        String nonVegMenu = keeper.getNonVegMenu();
        String bothMenu = keeper.getBothMenu();
        System.out.println(vegMenu + "\t" + nonVegMenu + "\t" + bothMenu);

        //Observer

        System.out.println("\nObserver: ");
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        // Register observers
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        // Simulating weather changes
        weatherStation.setWeather("Sunny");
        weatherStation.setWeather("Rainy");
        weatherStation.setWeather("Cloudy");

        // Remove one observer
        weatherStation.removeObserver(tvDisplay);

        // Notify remaining observer
        weatherStation.setWeather("Windy");

        //Strategy
        System.out.println("\nStrategy:");
        System.out.print("Bubble ");
        SortingContext sortingContext = new SortingContext(new BubbleSortStrategy());
        sortingContext.performSort(new int[]{4,2,5,7,6,9});

        System.out.print("\nMerge ");
        sortingContext.setSortingStrategy(new MergeSortStrategy());
        sortingContext.performSort(new int[]{4,7,8,5,3,2,6});

        System.out.print("\nQuick ");
        sortingContext.setSortingStrategy(new QuickSortStrategy());
        sortingContext.performSort(new int[]{9,5,4,7,3,2,8});
    }
}