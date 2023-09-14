import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; 
        int totalRounds = 3;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + maxAttempts + " attempts per round.");
        System.out.println("There will be " + totalRounds + " rounds. Let's begin!");

        for (int round = 1; round <= totalRounds; round++) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");

            while (!hasGuessedCorrectly && attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Try a lower number.");
                } else {
                    hasGuessedCorrectly = true;
                    int roundScore = maxAttempts - attempts + 1;
                    score += roundScore;
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    System.out.println("Round " + round + " score: " + roundScore);
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Round " + round + ": You've run out of attempts. The number was " + numberToGuess);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + score);

        scanner.close();
    }
}
