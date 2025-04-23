import java.util.ArrayList;
import java.util.Scanner;

public class Court {
    private String name;
    private String location;
    private String typeOfCourt;
    private  Boolean isBooked;
    public static final ArrayList<Court> courts = new ArrayList<>();
    private final String[] sportTypes = {"Football", "Basketball", "Tennis", "Volleyball"};


    public Court(Scanner scan) {
        setName(scan);
        setLocation(scan);
        setTypeOfCourt(scan);
        isBooked = false;
        courts.add(this);
    }

    public void release() {
        if (!this.isBooked) {
            System.out.println("Court is already not booked");
            return;
        }
        this.isBooked = false;
        System.out.println("Court is released.");
    }

    public void bookCourt(Player player) {
        if (this.isBooked) {
            System.out.println("Court is already booked");
            return;
        }
        this.isBooked = true;
        System.out.printf("Court is booked by %s\n." , player.getPlayerName());
    }

    public static void showAllCourt() {
        for (int i = 0; i < courts.size(); i++) {
            System.out.printf("%d . 📍 Name: %-10s | 📌 Location: %-10s | 🏅 Type: %-10s | 📆 Booked: %s\n",
                    i , courts.get(i).name, courts.get(i).location, courts.get(i).typeOfCourt, courts.get(i).isBooked ? "Yes" : "No");

        }
        if (courts.isEmpty()) {
            System.out.println("There is no court.");
        }
    }

    private void setName(Scanner scan) {
        System.out.print("Please enter the name of the court: ");
        this.name = scan.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setLocation(Scanner scan) {
        System.out.print("Please enter the location of the court : ");
        this.location = scan.nextLine();
    }

    public void setTypeOfCourt(Scanner scan) {
        System.out.println("\n🏅 Choose new sport type:");
        for (int i = 0; i < sportTypes.length; i++) {
            System.out.println((i + 1) + ". " + sportTypes[i]);
        }
        int typeChoice;
        do {
            System.out.print("Select a number: ");
            typeChoice = scan.nextInt() - 1;
        } while (!(0 <= typeChoice && typeChoice < sportTypes.length));

        this.typeOfCourt = sportTypes[typeChoice];
    }

    public void removeCourt() {
        courts.remove(this);
    }
}
