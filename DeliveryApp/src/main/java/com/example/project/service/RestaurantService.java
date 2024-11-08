package com.example.project.service;

import com.example.project.model.Restaurant;
import com.example.project.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    // Constructor injection for RestaurantRepository
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // Adds sample restaurants
    public void addSampleRestaurant() {
        restaurantRepository.addSampleRestaurant();
    }

    // Returns all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    // Saves a restaurant
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}