import com.example.project.RestaurantController;
import com.example.project.model.Dish;
import com.example.project.model.Restaurant;
import com.example.project.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RestaurantControllerTest {
    private RestaurantService restaurantService;
    private RestaurantController restaurantController;

    @BeforeEach
    public void setup() {
        restaurantService = Mockito.mock(RestaurantService.class);
        restaurantController = new RestaurantController(restaurantService);
    }

    @Test
    public void testShowOrderPage() {
        Dish dish1 = new Dish("Dish1", 10.0);
        Dish dish2 = new Dish("Dish2", 15.0);
        Restaurant restaurant = new Restaurant("Test Restaurant", Arrays.asList(dish1, dish2));
        when(restaurantService.getAllRestaurants()).thenReturn(Arrays.asList(restaurant));

        ModelAndView mav = restaurantController.showOrderPage();
        assertEquals(Arrays.asList(dish1, dish2), mav.getModel().get("dishes"));
    }

    @Test
    public void testNextRestaurant() {
        Dish dish1 = new Dish("Dish1", 10.0);
        Dish dish2 = new Dish("Dish2", 15.0);
        Restaurant restaurant1 = new Restaurant("Test Restaurant 1", Arrays.asList(dish1, dish2));
        Restaurant restaurant2 = new Restaurant("Test Restaurant 2", Arrays.asList(dish1, dish2));
        when(restaurantService.getAllRestaurants()).thenReturn(Arrays.asList(restaurant1, restaurant2));

        restaurantController.nextRestaurant();
        ModelAndView mav = restaurantController.nextRestaurant();

        assertEquals(restaurant1.getName(), mav.getModel().get("restaurantName"));
        assertEquals(restaurant1.getMenu(), mav.getModel().get("dishes"));
    }

    @Test
    public void testSubmitOrder() {
        List<String> dishes = Arrays.asList("Dish1|10.0", "Dish2|15.0");
        ModelAndView mav = restaurantController.submitOrder("Test", "User", dishes);
        assertEquals(25.0, mav.getModel().get("total"));
        assertEquals("Test", mav.getModel().get("name"));
        assertEquals("User", mav.getModel().get("surname"));
    }

    @Test
    public void testSubmitOrderTotal() {
        List<String> dishes = Arrays.asList("Dish1|10.0", "Dish2|15.0");
        ModelAndView mav = restaurantController.submitOrder("Test", "User", dishes);
        assertEquals(25.0, mav.getModel().get("total"));
    }

    @Test
    public void testSubmitOrderNameSurname() {
        List<String> dishes = Arrays.asList("Dish1|10.0", "Dish2|15.0");
        ModelAndView mav = restaurantController.submitOrder("Test", "User", dishes);
        assertEquals("Test", mav.getModel().get("name"));
        assertEquals("User", mav.getModel().get("surname"));
    }

}