import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        }
    }
}


class Cart {
    private String[] products;
    private int[] quantities;
    private double[] prices;
    private int count;

    public Cart() {
        products = new String[50];
        quantities = new int[50];
        prices = new double[50];
        count = 0;
    }

    public void addProduct(String productName, int quantity, double price) {
        products[count] = productName;
        quantities[count] = quantity;
        prices[count] = price * quantity;
        count++;
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\nYour Cart:");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i] + " - Quantity: " + quantities[i] + " - Price: $" + prices[i]);
        }
        System.out.println("Total Amount: $" + calculateTotal());
    }
}



public class ECommerce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create categorized products
        Product[] laptops = {
            new Product("Dell Inspiron", 750.00, 5),
            new Product("MacBook Pro", 1200.00, 3),
            new Product("HP Spectre", 950.00, 4),
            new Product("Lenovo ThinkPad", 850.00, 6),
        };

        Product[] smartphones = {
            new Product("iPhone 13", 999.00, 10),
            new Product("Samsung Galaxy S21", 799.00, 8),
            new Product("Google Pixel 6", 699.00, 12),
            new Product("OnePlus 9", 729.00, 7),
        };

        Product[] headphones = {
            new Product("Sony WH-1000XM4", 350.00, 10),
            new Product("Bose QuietComfort 45", 399.00, 5),
            new Product("Apple AirPods Pro", 249.00, 15),
            new Product("JBL Tune 750BT", 99.00, 20),
        };

        Cart cart = new Cart();

        System.out.println("Welcome to the eCommerce System!");
        while (true) {
            System.out.println("\nAvailable Products:");

            // Display categorized products
            System.out.println("Laptops:");
            for (int i = 0; i < laptops.length; i++) {
                System.out.println((i + 1) + ". " + laptops[i].getName() + " - $" + laptops[i].getPrice() + " - Stock: " + laptops[i].getStock());
            }

            System.out.println("\nSmartphones:");
            for (int i = 0; i < smartphones.length; i++) {
                System.out.println((i + laptops.length + 1) + ". " + smartphones[i].getName() + " - $" + smartphones[i].getPrice() + " - Stock: " + smartphones[i].getStock());
            }

            System.out.println("\nHeadphones:");
            for (int i = 0; i < headphones.length; i++) {
                System.out.println((i + laptops.length + smartphones.length + 1) + ". " + headphones[i].getName() + " - $" + headphones[i].getPrice() + " - Stock: " + headphones[i].getStock());
            }

            System.out.println("\nChoose an option:");
            System.out.println("1. Add to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Buy");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the product number to add to cart:");
                int productNumber = scanner.nextInt();
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();

                Product selectedProduct = null;
                if (productNumber > 0 && productNumber <= laptops.length) {
                    selectedProduct = laptops[productNumber - 1];
                } else if (productNumber > laptops.length && productNumber <= laptops.length + smartphones.length) {
                    selectedProduct = smartphones[productNumber - laptops.length - 1];
                } else if (productNumber > laptops.length + smartphones.length && productNumber <= laptops.length + smartphones.length + headphones.length) {
                    selectedProduct = headphones[productNumber - laptops.length - smartphones.length - 1];
                }

                if (selectedProduct != null) {
                    if (quantity > 0 && quantity <= selectedProduct.getStock()) {
                        selectedProduct.reduceStock(quantity);
                        cart.addProduct(selectedProduct.getName(), quantity, selectedProduct.getPrice());
                        System.out.println("Added " + quantity + " " + selectedProduct.getName() + "(s) to the cart.");
                    } else {
                        System.out.println("Invalid quantity. Try again.");
                    }
                } else {
                    System.out.println("Invalid product number. Try again.");
                }
            } else if (choice == 2) {
                cart.displayCart();
            } else if (choice == 3) {
                if (cart.calculateTotal() == 0) {
                    System.out.println("Your cart is empty. Please add items to the cart first.");
                } else {
                    cart.displayCart();
                    double total = cart.calculateTotal();
                    System.out.println("\nChoose a payment method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. Debit Card");
                    System.out.println("3. Cash on Delivery");

                    int paymentChoice = scanner.nextInt();
                    if (paymentChoice == 1 || paymentChoice == 2) {
                        System.out.println("Enter card number:");
                        String cardNumber = scanner.next();
                        System.out.println("Payment of $" + total + " is successful using card ending with " +
                                cardNumber.substring(cardNumber.length() - 4) + ".");
                    } else if (paymentChoice == 3) {
                        System.out.println("Payment of $" + total + " will be collected upon delivery.");
                    } else {
                        System.out.println("Invalid payment method. Returning to menu.");
                    }
                    break; // Exit after successful payment
                }
            } else if (choice == 4) {
                System.out.println("Thank you for shopping with us!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
    }
}
