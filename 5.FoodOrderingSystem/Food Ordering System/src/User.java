import java.util.Scanner;

public class User {

    private String name;

    public User(Scanner scan) {
        setName(scan);
    }

    public String getName() {
        return name;
    }

    public void setName(Scanner scan) {
        System.out.println("\uD83D\uDCDD Please enter your name:\n");
        this.name = scan.nextLine().trim().toUpperCase();
    }
}
