import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    showMainMenu();
    }

    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n🎡 Welcome to the Theme Park!");
            System.out.println("1. 👨‍💼 I'm a Admin");
            System.out.println("2. 👤 I'm an Visitor");
            System.out.println("3. 👑 I'm a VIP Visitor");
            System.out.println("4. ❌ Exit");

            System.out.print("👉 Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // برای حذف \n اضافی

            switch (choice) {
                case 1:
                    System.out.println("🔐 Redirecting to Admin Menu...");
                    Admin.showAdminMenu();
                    break;

                case 2:
                    Visitor visitor = new Visitor();
                    System.out.println("🎢 Redirecting to Visitor Menu...");
                    Visitor.showVisitorMenu(visitor);
                    break;

                case 3:
                    VIPVisitor vipVisitor = new VIPVisitor();
                    vipVisitor.getPriorityAccess();
                    System.out.println("🎢 Redirecting to VIPVisitor Menu...");
                    Visitor.showVisitorMenu(vipVisitor);
                    break;

                case 4:
                    System.out.println("👋 Thank you for visiting the Theme Park!");
                    return;

                default:
                    System.out.println("❗ Invalid input. Please enter 1, 2, or 3.");
            }
        }
    }
}