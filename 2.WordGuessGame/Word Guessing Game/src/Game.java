import java.util.*;

public class Game {
    private final ArrayList<String> words= new ArrayList<>(Arrays.asList("java" , "salad"));
    public ArrayList<String> guessesWord = new ArrayList<>();
    int attempts;
    protected Player player;

    public void play( Scanner scan) {
        startGame(scan);
        if (hasPlayerWon()){
            System.out.printf("🌟 Great job, %s! You nailed %d out of %d words! 🔥\n",player.getName(), guessesWord.size(), words.size());
            System.out.println("=========================================");
        }
        System.out.printf("📊 Well done, %s! You guessed %d out of %d words correctly.\n",
                player.getName(), guessesWord.size(), words.size());
        System.out.println("=========================================");
    }
    private void startGame(Scanner scan) {
        player = new Player(scan);
        int numberOfAttemptsAllowed;
        ArrayList<Integer>randomIndexes = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            randomIndexes.add(i);
        }
        Collections.shuffle(randomIndexes);
        for (Integer randomIndex : randomIndexes) {
            String word = words.get(randomIndex);
            char[] guessedWord = new char[word.length()];
            numberOfAttemptsAllowed = 3 + word.length();
            Arrays.fill(guessedWord, '_');
            attempts = 0;
            System.out.println("\n📌 New word incoming! Get ready to guess:");
            System.out.println("🔤 " + String.valueOf(guessedWord));

            while (!(isWordHasGuessed(word, guessedWord)) && attempts < numberOfAttemptsAllowed) {
                char charGuess = getPlayerGuess(guessedWord , scan);
                attempts++;
                checkIsRightGuess(word, charGuess, guessedWord);

                if (isWordHasGuessed(word , guessedWord)) {
                    guessesWord.add(word);
                    System.out.println("\n🎉🎉🎉 Congratulations! You guessed the word! 🎉🎉🎉");
                    System.out.println("🏆 The word was: " + word + "\n");
                }
                else if (attempts == numberOfAttemptsAllowed - 1)
                    System.out.println("⚠️ Only ONE guess left! Make it count! 🚨");
                else if (attempts >= numberOfAttemptsAllowed) {
                    System.out.println("\n===========================");
                    System.out.println("💀 Game Over! You're out of guesses.");
                    System.out.println("📝 The correct word was: " + word);
                    System.out.println("===========================\n");
                }
            }
        }
    }

    private boolean isWordHasGuessed(String word , char[] guessedWord) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != guessedWord[i]) {
                return false;
            }
        }
        return true;
    }



    private void checkIsRightGuess(String word , char inputChar , char[] guessedWord) {
        boolean isRightGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == inputChar) {
                isRightGuess = true;
                guessedWord[i] =inputChar;
            }
        }
        if (isRightGuess)
            System.out.println("✅ Nice! That letter is correct. Keep going! 💪");
        else
            System.out.println("❌ Oops! That letter is not in the word. Try again.");

    }

    private char getPlayerGuess(char[] guessedWord , Scanner scan) {
        System.out.println(String.valueOf(guessedWord));
        System.out.println("Enter your guess: ");
        String guess = scan.nextLine().toLowerCase();
        return guess.charAt(0);
    }

    public static boolean isPlayAgain (Scanner scan){
        System.out.println("Would you like to play again? (Y/N)");
        return scan.nextLine().equalsIgnoreCase("Y");
    }

    private boolean hasPlayerWon() {
        if (words.size() != guessesWord.size())
            return false;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!(word.equals(guessesWord.get(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
