import java.util.Scanner;

public class Customer extends User{
    private Order order;

    public Customer(Scanner scan) {
        super(scan);
    }

    public void viewMeno(){
        Food.showFoodMenu();
    }

    public void creatOrder(Scanner scan) {
        order = new Order(this);
        order.creatOrderList(scan);
    }

    public void viewOrder() {
        if (order != null)
            order.printDetailedOrder();
        else
            System.out.println("Order not found");
    }

    public void viewOrderStatus() {
        System.out.println(order.getStatus());
    }
}