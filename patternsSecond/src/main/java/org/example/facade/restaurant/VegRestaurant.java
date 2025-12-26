package org.example.facade.restaurant;

import org.example.facade.Hotel;

public class VegRestaurant implements Hotel {
    @Override
    public String getMenus() {
        return "Menu of Vegetarian Restaurant";
    }
}
