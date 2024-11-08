package com.example.project.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Client client = new Client();
    Courier courier = new Courier();
    String restaurant;
    List <Dish> dishes=new ArrayList<>();
    double price;

    public Client getPerson() {
        return client;
    }
    public void setPerson(Client client) {
        this.client = client;
    }

    public Courier getCourier() {
        return courier;
    }
    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
    public void addDishes(Dish dish) {
     List<Dish> dishes = getDishes();
     dishes.add(dish);
     setDishes(dishes);
    }
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
