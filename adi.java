
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        // Setup
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int userGuess = 0; // Variable to store user's guess
        int attempts = 0; // Variable to count attempts
        
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
        
        // Game loop
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt(); // Read user input
            attempts++; // Increment attempts
            
            // Check the guess
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
            }
        }
        
        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
