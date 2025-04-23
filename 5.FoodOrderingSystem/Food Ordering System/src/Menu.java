import java.util.Scanner;

public abstract class Menu {

    public static void showMainMenu() {
        int choice;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     🍽️ Food Ordering App     ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. 👤 Login as Customer      ║");
            System.out.println("║ 2. 🧑‍🍳 Login as Staff         ║");
            System.out.println("║ 3. ❌ Exit                   ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("👉 Please enter your choice (1-3): ");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("✅ Customer selected.");
                    Customer customer = new Customer(scan);
                    Menu.showCustomerMenu(scan, customer);
                    break;
                case 2:
                    System.out.println("✅ Staff selected.");
                    Staff staff = new Staff(scan);
                    Menu.showStaffMenu(scan, staff);
                    break;
                case 3:
                    System.out.println("👋 Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }

    }

    public static void showCustomerMenu(Scanner scan , Customer customer) {
        int choice;
        while (true) {
            System.out.println("\n╔═══════════════════════════════╗");
            System.out.println("║      👤 Customer Menu         ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. 📋 View Food Menu          ║");
            System.out.println("║ 2. 🛒 Place a New Order       ║");
            System.out.println("║ 3. 📦 View My Order Details   ║");
            System.out.println("║ 4. 🔄 Check Order Status      ║");
            System.out.println("║ 5. ❌ Back to Main Menu       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("👉 Please enter your choice (1-5): ");


            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("🍔 Showing food menu...");
                    customer.viewMeno();
                    break;
                case 2:
                    System.out.println("🛒 Creating a new order...");
                    customer.creatOrder(scan);
                    break;
                case 3:
                    System.out.println("📦 Showing your order details...");
                    customer.viewOrder();
                    break;
                case 4:
                    System.out.println("🔄 Checking your order status...");
                    customer.viewOrderStatus();
                    break;
                case 5:
                    System.out.println("🔙 Returning to main menu...");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    public static void showStaffMenu(Scanner scan , Staff staff) {
        int choice;
        while (true) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║       🧑‍🍳 Staff Menu            ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 1. 📦 View All Orders          ║");
        System.out.println("║ 2. 🔄 Update Order Status      ║");
        System.out.println("║ 3. ➕ Add New Menu Item        ║");
        System.out.println("║ 4. 🔙 Back to Main Menu        ║");
        System.out.println("╚════════════════════════════════╝");

            System.out.print("👉 Please enter your choice (1-4): ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("📦 Displaying all orders...");
                    staff.viewOrders();
                    break;
                case 2:
                    System.out.println("🔄 Updating order status...");
                    staff.changeStatus(scan);
                    break;
                case 3:
                    System.out.println("➕ Adding new menu item...");
                    System.out.println("Enter name of the new food: ");
                    String foodName = scanner.next();
                    System.out.println("Enter price of the new food: ");
                    double foodPrice = scanner.nextDouble();
                    System.out.println("Enter description of the new food: ");
                    String foodDescription = scanner.next();
                    staff.addFood(foodName, foodPrice, foodDescription);
                    break;
                case 4:
                    System.out.println("🔙 Returning to main menu...");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }
}
