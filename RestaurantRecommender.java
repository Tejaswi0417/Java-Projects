package OOPs;

import java.util.Scanner;

public class RestaurantRecommender {

    // Restaurant data
    static class Restaurant {
        String cuisine;
        String price;
        String atmosphere;
        double rating;

        Restaurant(String cuisine, String price, String atmosphere, double rating) {
            this.cuisine = cuisine;
            this.price = price;
            this.atmosphere = atmosphere;
            this.rating = rating;
        }
    }

    // Knowledge base
    static Restaurant[] restaurants = {
        new Restaurant("Italian", "Moderate", "Romantic", 4.5),
        new Restaurant("Vegetarian", "Low", "Casual", 4.0),
        new Restaurant("Seafood", "High", "Formal", 4.7)
    };

    // Inference engine
   public static String referRestuarant(String cuisine, String price, String atmosphere, double rating) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.cuisine.equalsIgnoreCase(cuisine) && restaurant.price.equalsIgnoreCase(price)) {
                return "Based on your input, we recommend visiting: " + getRestaurantName(restaurant);
            }
            if (restaurant.atmosphere.equalsIgnoreCase(atmosphere) && restaurant.rating >= rating) {
                return "Based on your input, we recommend visiting: " + getRestaurantName(restaurant);
            }
        }
        return "Sorry, we could not find any restaurant that matches your criteria.";
    }

    // Get restaurant name based on its properties
    public static String getRestaurantName(Restaurant restaurant) {
        if (restaurant.cuisine.equals("Italian")) return "The Red House";
        if (restaurant.cuisine.equals("Vegetarian")) return "The Green Kitchen";
        if (restaurant.cuisine.equals("Seafood")) return "The Blue Seafood";
        return "Unknown Restaurant";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Restaurant Recommender");
        System.out.println("Please answer the following questions to receive a recommendation.");
        System.out.println();

        System.out.println("What type of cuisine do you prefer? \n 1. Italian \n 2. Vegetarian \n 3. Seafood");
        String cuisine = scanner.nextLine();

        System.out.println("What price range are you comfortable with?\n 1. High \n 2. Moderate \n 3. Low");
        String price = scanner.nextLine();

        System.out.println("What kind of atmosphere do you prefer?\n 1. Romantic \n 2. Casual \n 3. Formal");
        String atmosphere = scanner.nextLine();

        System.out.println("What minimum rating do you require?\n 1. 4.0 \n 2. 4.5 \n 3. 4.7");
        double rating = Double.parseDouble(scanner.nextLine());

        // Normalize inputs for consistency
        if (cuisine.equals("1")) cuisine = "Italian";
        if (cuisine.equals("2")) cuisine = "Vegetarian";
        if (cuisine.equals("3")) cuisine = "Seafood";

        if (price.equals("1")) price = "High";
        if (price.equals("2")) price = "Moderate";
        if (price.equals("3")) price = "Low";

        if (atmosphere.equals("1")) atmosphere = "Romantic";
        if (atmosphere.equals("2")) atmosphere = "Casual";
        if (atmosphere.equals("3")) atmosphere = "Formal";

        // Get recommendation
        String recommendation = infer(cuisine, price, atmosphere, rating);
        System.out.println(recommendation);

        scanner.close();
    }
}

