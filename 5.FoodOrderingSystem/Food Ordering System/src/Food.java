import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Food {
    private int foodID;
    private static int nextFoodID = 1;
    private final String name;
    private double price;
    private String description;
    private boolean isAvailable;
    public static final List<Food> foods = new  ArrayList<>();

    public Food(String foodName, double foodPrice, String foodDescription) {
        this.name = foodName;
        this.price = foodPrice;
        this.description = foodDescription;
        setAvailable(true);
        foods.add(this);
        setFoodID(nextFoodID++);
    }

    public static void showFoodMenu() {
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                 🍽️  Welcome to Our Menu!                          ║");
        System.out.println("╠════╦════════════════════╦══════════╦═══════════════╦══════════════╣");
        System.out.println("║ No ║        Name        ║  Price   ║  isAvailable  ║ Description  ║");
        System.out.println("╠════╬════════════════════╬══════════╬═══════════════╬══════════════╣");
        int index = 1;
        for (Food food : foods) {
            System.out.printf("║ %-2d ║ %-18s ║ $%-7.2f ║ %-13s ║ %-12s ║\n",
                    index++,
                    food.getName(),
                    food.getPrice(),
                    food.isAvailable(),
                    food.getDescription().length() > 12
                            ? food.getDescription().substring(0, 11) + "…"
                            : food.getDescription());
            System.out.println("╬════╬════════════════════╬══════════╬═══════════════╬══════════════╣");
        }
        System.out.println("════════════════════════════════════════════════════════════════════");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Scanner scan) {
        if (price > 0) {
            System.out.print("💲 Enter new price for " + this.getName() + ": ");
            this.price = scan.nextDouble();
        }
        else {
            System.out.println("❌ invalid price entered!");
            setPrice(scan);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Scanner scan) {
        if (description != null && !description.trim().isEmpty()) {
            System.out.print("📝 Enter new description for " + this.getName() + ": ");
            this.description = scan.nextLine().trim().toLowerCase();
        } else {
            System.out.println("❌ Description cannot be empty!");
            setDescription(scan);
        }
    }

    public String isAvailable() {
        if (isAvailable) {
            return "Available";
        }
        return "Not Available";
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public static Food getFoodWithID(int foodID) {
        for (Food food : foods) {
            if (food.getFoodID() == foodID) {
                return food;
            }
        }
        System.out.println("no food with ID " + foodID + " found");
        return null;
    }
}
