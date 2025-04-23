import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
            Game game = new Game();
            game.play(scan);
        } while (Game.isPlayAgain(scan));
    }
}