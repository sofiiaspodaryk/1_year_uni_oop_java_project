package com.example.project.repository;

import com.example.project.model.Dish;
import com.example.project.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>();

    // Returns all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }

    // Adds sample restaurants
    public void addSampleRestaurant() {
        List<Dish> kfcDishes = new ArrayList<>();
        kfcDishes.add(new Dish("Chicken Bucket", 10.0));
        kfcDishes.add(new Dish("French fries", 4.0));
        kfcDishes.add(new Dish("Coca-Cola", 2.0));
        save(new Restaurant("KFC", kfcDishes));

        List<Dish> mcdonaldsDishes = new ArrayList<>();
        mcdonaldsDishes.add(new Dish("Big Mac", 5.5));
        mcdonaldsDishes.add(new Dish("Cheeseburger", 5.0));
        mcdonaldsDishes.add(new Dish("Nugets", 4.5));
        mcdonaldsDishes.add(new Dish("Fries", 3.5));
        save(new Restaurant("Mcdonald's", mcdonaldsDishes));

        List<Dish> dominosDishes = new ArrayList<>();
        dominosDishes.add(new Dish("Pizza", 8.0));
        dominosDishes.add(new Dish("Salad", 6.0));
        dominosDishes.add(new Dish("Juice", 3.0));
        save(new Restaurant("Domino's", dominosDishes));
    }

    // Saves a restaurant
    public void save(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}