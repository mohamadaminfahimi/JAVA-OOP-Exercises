import java.util.Scanner;

public class Player {
    private final String name;

    public Player(Scanner scan) {
        System.out.println("Please enter your name: ");
        name = scan.nextLine();
    }

    private void bookCourt(Scanner scan) {
        if (Court.courts.isEmpty()) {
            System.out.println("there is no court.");
            return;
        }
        Court.showAllCourt();
        System.out.printf("Enter the number of the court(1 , %d): " , Court.courts.size());
        int numberOfCourt = scan.nextInt() - 1;
        scan.nextLine();
        Court.courts.get(numberOfCourt).bookCourt(this);
    }

    public String getPlayerName() {
        return name;
    }

    public void showPlayerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n🎮 Player Menu 🎮");
            System.out.println("1. 🏟 View Available Courts");
            System.out.println("2. 🎫 Book a Court");
            System.out.println("3. 🔙 Back to Main Menu");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Court.showAllCourt();
                    break;

                case "2":
                    bookCourt(scanner);
                    break;

                case "3":
                    return;

                default:
                    System.out.println("⚠ Invalid option. Please try again.");
            }
        }
    }
}
