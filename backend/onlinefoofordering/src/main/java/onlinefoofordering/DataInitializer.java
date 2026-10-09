package onlinefoofordering;

import onlinefoofordering.model.FoodItem;
import onlinefoofordering.model.Order;
import onlinefoofordering.model.Restaurant;
import onlinefoofordering.model.User;
import onlinefoofordering.repository.FoodItemRepository;
import onlinefoofordering.repository.OrderRepository;
import onlinefoofordering.repository.RestaurantRepository;
import onlinefoofordering.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final FoodItemRepository foodItemRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public DataInitializer(RestaurantRepository restaurantRepository,
                           FoodItemRepository foodItemRepository,
                           OrderRepository orderRepository,
                           UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodItemRepository = foodItemRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Seed default demo user
        if (userRepository.count() == 0) {
            User demoUser = new User("Rahul Sharma", "demo@example.com", "password123", "+1 555-0199", "CUSTOMER");
            userRepository.save(demoUser);
        }

        if (restaurantRepository.count() > 0) {
            return; // Data already seeded
        }

        // Restaurant 1: Pizza Bella
        Restaurant r1 = new Restaurant(
                "Pizza Bella",
                "Authentic wood-fired pizzas made with fresh Italian ingredients.",
                "Italian",
                "123 Napoli Way, City Center",
                4.8,
                "https://images.unsplash.com/photo-1513104890138-7c749659a591"
        );
        r1.addFoodItem(new FoodItem("Margherita Pizza", "Fresh mozzarella, San Marzano tomatoes, and basil.", 12.99, "Pizza", "https://images.unsplash.com/photo-1604382355076-af4b0eb60143", r1));
        r1.addFoodItem(new FoodItem("Pepperoni Feast", "Double pepperoni with melted provolone and mozzarella.", 15.99, "Pizza", "https://images.unsplash.com/photo-1628840042765-356cda07504e", r1));
        r1.addFoodItem(new FoodItem("Garlic Parmesan Breadsticks", "Crispy on the outside, soft inside with marinara dip.", 6.49, "Sides", "https://images.unsplash.com/photo-1549611016-3a70d82b5040", r1));
        restaurantRepository.save(r1);

        // Restaurant 2: Burger Nation
        Restaurant r2 = new Restaurant(
                "Burger Nation",
                "Gourmet smash burgers, loaded fries, and thick shakes.",
                "American",
                "456 Broadway Avenue",
                4.6,
                "https://images.unsplash.com/photo-1550547660-d9450f859349"
        );
        r2.addFoodItem(new FoodItem("Classic Cheeseburger", "Angus beef patty, aged cheddar, lettuce, pickles & secret sauce.", 10.99, "Burger", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd", r2));
        r2.addFoodItem(new FoodItem("Crispy Chicken Burger", "Southern fried chicken breast, spicy mayo & pickles.", 11.99, "Burger", "https://images.unsplash.com/photo-1625813506062-0aeb1d7a094b", r2));
        r2.addFoodItem(new FoodItem("Loaded Truffle Fries", "Crispy fries drizzled with truffle oil and parmesan.", 6.99, "Sides", "https://images.unsplash.com/photo-1573080496219-bb080dd4f877", r2));
        restaurantRepository.save(r2);

        // Restaurant 3: Spice Route
        Restaurant r3 = new Restaurant(
                "Spice Route",
                "Rich and aromatic curries, tandoori grills, and fresh naan bread.",
                "Indian",
                "789 Curry Lane",
                4.9,
                "https://images.unsplash.com/photo-1585937421612-70a008356fbe"
        );
        r3.addFoodItem(new FoodItem("Butter Chicken with Naan", "Tender chicken in a velvety spiced tomato butter sauce.", 14.99, "Curry", "https://images.unsplash.com/photo-1603894584373-5ac82b2ae398", r3));
        r3.addFoodItem(new FoodItem("Paneer Tikka Masala", "Grilled cottage cheese cubes in rich spiced gravy.", 13.99, "Curry", "https://images.unsplash.com/photo-1631452180519-c014fe946bc7", r3));
        r3.addFoodItem(new FoodItem("Hyderabadi Dum Biryani", "Fragrant basmati rice layered with aromatic spices and chicken.", 16.49, "Rice", "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8", r3));
        restaurantRepository.save(r3);

        // Seed Sample Orders
        Order order1 = new Order("Rahul Sharma", "demo@example.com", "Flat 302, Green Valley Apartments", 35.47, "DELIVERED", "2x Margherita Pizza, 1x Garlic Breadsticks");
        Order order2 = new Order("Priya Patel", "priya@example.com", "B-12, Sunrise Residency", 29.98, "PREPARING", "2x Butter Chicken with Naan");
        orderRepository.save(order1);
        orderRepository.save(order2);
    }
}
