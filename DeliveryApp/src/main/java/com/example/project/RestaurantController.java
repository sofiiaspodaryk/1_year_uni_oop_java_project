package com.example.project;

import com.example.project.model.Restaurant;
import com.example.project.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {
    private int currentRestaurantIndex = 0;
    private final RestaurantService restaurantService;

    // Use constructor injection for RestaurantService
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Show the welcome page
    @GetMapping
    public ModelAndView showWelcomePage() {
        return new ModelAndView("index");
    }

    // Show the order page with the current restaurant's menu
    @GetMapping("/order")
    public ModelAndView showOrderPage() {
        restaurantService.addSampleRestaurant();

        ModelAndView mav = new ModelAndView("order");
        Restaurant restaurant = restaurantService.getAllRestaurants().get(currentRestaurantIndex);
        mav.addObject("restaurantName", restaurant.getName());
        mav.addObject("dishes", restaurant.getMenu());

        return mav;
    }

    // Move to the next restaurant and show its menu
    @PostMapping("/order")
    public ModelAndView nextRestaurant() {
        currentRestaurantIndex = (currentRestaurantIndex + 1) % restaurantService.getAllRestaurants().size();
        return showOrderPage();
    }

    // Submit the order and show the order details
    @PostMapping("/submit-order")
    public ModelAndView submitOrder(@RequestParam String name, @RequestParam String surname, @RequestParam List<String> dishes) {
        ModelAndView mav = new ModelAndView("submit-order");

        double total = 0;
        List<String> dishNames = new ArrayList<>();
        for (String dish : dishes) {
            String[] parts = dish.split("\\|");
            if (parts.length == 2) {
                dishNames.add(parts[0]);
                try {
                    total += Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    mav.addObject("error", "Failed to parse price: " + parts[1]);
                    return mav;
                }
            }
        }

        mav.addObject("dishes", dishNames);
        mav.addObject("total", total);
        mav.addObject("name", name);
        mav.addObject("surname", surname);
        return mav;
    }
}