import java.util.List;
import java.util.Scanner;

public class Admin {
    private static final Scanner scanner = new Scanner(System.in);
    private final String name;
    public static Scanner scan = new Scanner(System.in);

    public Admin() {
        System.out.print("👤 Enter your name: ");
        this.name = scan.nextLine();
    }

    public static void showAdminMenu() {
        Admin admin = new Admin();

        while (true) {
            System.out.println("🎉 Welcome, " + admin.getName() + " as Admin 👨‍💼");

            System.out.println("\n🎛️ Admin Menu - Theme Park System");
            System.out.println("1. ➕ Add New Ride");
            System.out.println("2. 📋 View All Rides");
            System.out.println("3. ▶️ Start a Ride");
            System.out.println("4. ❌ Exit");

            System.out.print("👉 Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine(); // برای خالی کردن بافر

            switch (choice) {
                case 1:
                    var r = new Ride();
                    System.out.println("✅ Ride \"" + r.getName() + "\" added successfully!");
                    break;

                case 2:
                    System.out.println("📋 List of all rides:");
                    List<Ride> rides = Ride.rideList;
                    if (rides.isEmpty()) {
                        System.out.println("🚫 No rides available.");
                    } else {
                        for (Ride ride : rides) {
                            System.out.println("🎢 " + ride.getName() + " | Capacity: " + ride.getCapacity() + " | Duration: " + ride.getDuration() + " min");
                        }
                    }
                    break;

                case 3:
                    List<Ride> rideList = Ride.rideList;
                    if (rideList.isEmpty()) {
                        System.out.println("🚫 No rides to start.");
                        break;
                    }

                    System.out.println("🎢 Choose a ride to start:");
                    for (int i = 0; i < rideList.size(); i++) {
                        System.out.println((i + 1) + ". " + rideList.get(i).getName());
                    }

                    System.out.print("👉 Enter ride number: ");
                    int rideIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (rideIndex >= 0 && rideIndex < rideList.size()) {
                        rideList.get(rideIndex).startRide();
                    } else {
                        System.out.println("❗ Invalid ride selection.");
                    }
                    break;
                case 4:
                    System.out.println("👋 Exiting admin panel. See you!");
                    return;

                default:
                    System.out.println("❗ Invalid option. Please try again.");
                    break;
            }

        }

    }

    public String getName () {
        return this.name;
    }
}
