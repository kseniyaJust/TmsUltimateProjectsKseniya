package org.example.facade.restaurant;

import org.example.facade.Hotel;

public class NonVegRestaurant implements Hotel {
    @Override
    public String getMenus() {
        return "Menu of Non-Vegetarian Restaurant";
    }
}
