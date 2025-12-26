package org.example.facade.restaurant;

import org.example.facade.Hotel;

public class BothRestaurant implements Hotel {
    @Override
    public String getMenus() {
        return "Menu of BothRestaurant";
    }
}
