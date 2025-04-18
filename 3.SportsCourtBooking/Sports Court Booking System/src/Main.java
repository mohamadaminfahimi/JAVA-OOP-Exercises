import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        var admin = new Admin();
        showMainMenu(scan , admin);
    }

    public static void showMainMenu(Scanner scanner , Admin admin) {

        boolean exit = false;
        while (!exit) {

            System.out.println("🎾🏀 Welcome to Sports Court Booking System 🏐⚽");
            System.out.println("============================================");
            System.out.println("🔰 Choose your role:");
            System.out.println("1️⃣ Admin (مدیر)");
            System.out.println("2️⃣ Player (بازیکن)");
            System.out.println("3️⃣ Exit (خروج)");
            System.out.print("👉 Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    admin.showAdminMenu(scanner);
                    break;
                case 2:
                    var player = new Player(scanner);
                    player.showPlayerMenu(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("❌ Please choose a valid option.");
            }
        }
    }
}