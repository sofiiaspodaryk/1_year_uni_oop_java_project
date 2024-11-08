package com.example.project.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    List<Dish> menu = new ArrayList<>();;

    public Restaurant(String name, List<Dish> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }
}