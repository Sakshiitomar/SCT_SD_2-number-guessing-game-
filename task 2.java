import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Number between 1 and 100
        Scanner scanner = new Scanner(System.in);
        boolean guessedCorrectly = false;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've picked a number between 1 and 100.");
        System.out.println("You have 3 attempts to guess it!");

        // Loop for up to 3 valid attempts
        while (attempts < 3 && !guessedCorrectly) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                attempts++; // only increment for valid integer input

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number!");
                    guessedCorrectly = true;
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // skip invalid input, don't count as attempt
            }
        }

        scanner.close();

        // Show outcome
        if (guessedCorrectly) {
            System.out.println("Result: You guessed the correct number!");
        } else {
            System.out.println("Result: You did not guess the correct number.");
            System.out.println("The number was: " + targetNumber);
        }
        System.out.println("Game over. Thanks for playing!");
    }
}