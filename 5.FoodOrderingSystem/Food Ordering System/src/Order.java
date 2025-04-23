import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private static int nextID;
    private final int ID;
    private String status;
    private Customer customer;
    private final List<Food> orderList = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();

    public Order( Customer customer ) {
        ID = nextID++;
        status = "Pending";
        setCustomer(customer);
        orders.add(this);
    }

    public void creatOrderList(Scanner scan) {
        boolean isDone = false;
        while (!isDone) {
            Food.showFoodMenu();
            System.out.println("\uD83D\uDC49 Please enter the number of the food item you want to add to your order: ");
            int foodID = scan.nextInt();
            Food food = Food.getFoodWithID(foodID);
            orderList.add(food);
            assert food != null;
            System.out.printf("The order was placed: %s\n", food.getName());
            System.out.println("Do you want to add food (Yes or No)?");
            status = scan.next();
            if (status.equalsIgnoreCase("no")) {
                isDone = true;
            }
        }
    }

    public void printDetailedOrder() {
        System.out.println("🧾 Order ID: " + ID);
        System.out.println("👤 Customer: " + customer.getName());
        System.out.println("📦 Items:");
        System.out.println("╔════════════════════╦══════════╦════════════════════════════╗");
        System.out.println("║      Item Name     ║  Price   ║        Description         ║");
        System.out.println("╠════════════════════╬══════════╬════════════════════════════╣");

        for (Food item : orderList) {
            System.out.printf("║ %-18s ║ $%-7.2f ║ %-26s ║\n",
                    item.getName(), item.getPrice(), item.getDescription());
            System.out.println("╠════════════════════╬══════════╬════════════════════════════╣");
        }
        System.out.println("╠════════════════════╬══════════╬════════════════════════════╣");
        System.out.printf ("║ %-18s ║ $%-7.2f ║ %s %-16s ║\n", "Total", calculateTotal(), "🚦 Status:", status);
        System.out.println("╚════════════════════╩══════════╩════════════════════════════╝");
        System.out.println("Status: " + getStatus());
        System.out.println("~~~~~~~~~~ End of Invoice ~~~~~~~~~~\n");
    }

    public double calculateTotal() {
        double total = 0;
        for (Food food : orderList) {
            total += food.getPrice();
        }
        return total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public int getID() {
        return ID;
    }

    public static Order getOrderWithID(int orderID) {
        for (Order order : orders) {
            if (order.getID() == orderID) {
                return order;
            }
        }
        System.out.println("Order not found.");
        return null;
    }
}
