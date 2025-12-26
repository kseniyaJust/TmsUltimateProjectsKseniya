package org.example.facade;

import org.example.facade.restaurant.BothRestaurant;
import org.example.facade.restaurant.NonVegRestaurant;
import org.example.facade.restaurant.VegRestaurant;

public class HotelKeeperImplemintation implements HotelKeeper{
    @Override
    public String getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        return v.getMenus();
    }

    @Override
    public String getNonVegMenu() {
        NonVegRestaurant n = new NonVegRestaurant();
        return n.getMenus();
    }

    @Override
    public String getBothMenu() {
        BothRestaurant b = new BothRestaurant();
        return b.getMenus();
    }
}
