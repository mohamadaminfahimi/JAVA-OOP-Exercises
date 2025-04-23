import java.util.Scanner;

public class Staff extends User {
    public Staff(Scanner scan) {
        super(scan);
    }
    
    public void viewOrders() {
        for (Order order:Order.orders){
            order.printDetailedOrder();
        }
    }

    public void changeStatus(Scanner scan) {
        System.out.print("\uD83C\uDD94 Please enter the Order ID you want to update: ");
        int orderID = scan.nextInt();
        System.out.print("\uD83D\uDD04 Enter the new status for this order: ");
        String status = scan.nextLine();
        searchOrders(orderID).setStatus(status);
    }

    public Order searchOrders(int ID) {
        return Order.getOrderWithID(ID);
    }

    public void addFood(String foodName, double foodPrice, String foodDescription) {
       new Food(foodName, foodPrice, foodDescription);
    }
}

