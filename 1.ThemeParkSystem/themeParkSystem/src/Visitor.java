import java.util.Scanner;

public class Visitor {
    private final String name;
    public static Scanner scan = new Scanner(System.in);

    public Visitor() {
        System.out.print("👤 Enter your name: ");
        this.name = scan.nextLine();
    }

    public static void showVisitorMenu(Visitor visitor) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎉 Welcome, " + visitor.getName() + "!");

        while (true) {
            System.out.println("\n🎢 Visitor Menu");
            System.out.println("1. 📋 View Available Rides");
            System.out.println("2. 🎟️ Join a Ride Queue");
            System.out.println("3. ❌ Exit to Main Menu");

            System.out.print("👉 Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // حذف \n

            switch (choice) {
                case 1:
                    if (Ride.rideList.isEmpty()) {
                        System.out.println("🚫 No rides available right now.");
                    } else {
                        System.out.println("📋 List of Rides:");
                        for (int i = 0; i < Ride.rideList.size(); i++) {
                            Ride ride = Ride.rideList.get(i);
                            System.out.println((i + 1) + ". 🎢 " + ride.getName() +
                                    " | Capacity: " + ride.getCapacity() +
                                    " | Duration: " + ride.getDuration() + " min");
                        }
                    }
                    break;

                case 2:
                    if (Ride.rideList.isEmpty()) {
                        System.out.println("🚫 No rides available to join.");
                        break;
                    }

                    System.out.println("📋 Choose a ride to join:");
                    for (int i = 0; i < Ride.rideList.size(); i++) {
                        System.out.println((i + 1) + ". " + Ride.rideList.get(i).getName());
                    }

                    System.out.print("Enter ride number: ");
                    int rideIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (rideIndex >= 0 && rideIndex < Ride.rideList.size()) {
                        Ride.rideList.get(rideIndex).addVisitor(visitor);
                    } else {
                        System.out.println("❗ Invalid ride selection.");
                    }
                    break;

                case 3:
                    System.out.println("👋 Returning to Main Menu...");
                    return;

                default:
                    System.out.println("❗ Invalid input. Try again.");
            }
        }
    }

    public String getName() {
        return name;
    }
}
