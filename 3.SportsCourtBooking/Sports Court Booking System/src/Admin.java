import java.util.Scanner;

public class Admin {

    public void addCourt(Scanner scan) {
        var court = new Court(scan);
        System.out.printf("%s added successfully." , court.getName());
    }

    private void releaseCourt(Scanner scan) {
        if (Court.courts.isEmpty()){
            System.out.println("There is no court.");
            return;
        }
        Court.showAllCourt();
        System.out.printf("Enter the number of the court who you want release that (1 , %d): " , Court.courts.size());
        int numberOfCourt = scan.nextInt() - 1;
        scan.nextLine();
        Court.courts.get(numberOfCourt).release();
    }

    public void removeCourt(Scanner scan) {
        if (Court.courts.isEmpty()){
            System.out.println("There is no court.");
            return;
        }
        Court.showAllCourt();
        System.out.printf("Enter the number of the court who you want remove that (1 , %d): " , Court.courts.size());
        int numberOfCourt = scan.nextInt() - 1;
        scan.nextLine();
        Court.courts.get(numberOfCourt).removeCourt();
    }

    public void showAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n🎩 Admin Menu 🎩");
            System.out.println("1. ➕ Add a Court");
            System.out.println("2. 🗑 Remove a Court");
            System.out.println("3. 🔓 Release a Booked Court");
            System.out.println("4. 📋 View All Courts");
            System.out.println("5. 🔙 Back to Main Menu");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addCourt(scanner);
                    break;

                case "2":
                    removeCourt(scanner);
                    break;

                case "3":
                    releaseCourt(scanner);
                    break;

                case "4":
                    Court.showAllCourt();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("⚠ Invalid option. Please try again.");
            }
        }
    }
}
