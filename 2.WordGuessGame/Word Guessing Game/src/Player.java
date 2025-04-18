import java.util.Scanner;

public class Player {
    private final String name;
    public Player(Scanner scan) {
        System.out.println("=======================================");
        System.out.println("🌟 Welcome to the Game! Let's get started.");
        System.out.println("=======================================");
        System.out.println("🎮 Please enter your name, Player:");
        name = scan.nextLine();
        System.out.println("=======================================");
        System.out.printf("🎉 Welcome, %s! Good luck and have fun! 🚀\n", name);
        System.out.println("=======================================");
    }


    public String getName() {
        return name;
    }
}
