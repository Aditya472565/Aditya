// Initialize the game state
let randomNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;

// Get elements from DOM
const userGuessInput = document.getElementById('userGuess');
const submitButton = document.getElementById('submitGuess');
const message = document.getElementById('message');
const attemptsElement = document.getElementById('attempts');
const resetButton = document.getElementById('resetGame');

// Function to handle the game logic
function checkGuess() {
  const userGuess = parseInt(userGuessInput.value);
  
  // Validate input
  if (isNaN(userGuess) || userGuess < 1 || userGuess > 100) {
    message.textContent = 'Please enter a number between 1 and 100.';
    return;
  }
  
  attempts++;
  attemptsElement.textContent = attempts;

  if (userGuess === randomNumber) {
    message.textContent = `Congratulations! You've guessed the number in ${attempts} attempts.`;
    submitButton.disabled = true;
    resetButton.style.display = 'block';
  } else if (userGuess < randomNumber) {
    message.textContent = 'Too low! Try again.';
  } else {
    message.textContent = 'Too high! Try again.';
  }

  userGuessInput.value = '';
}

// Function to reset the game
function resetGame() {
  randomNumber = Math.floor(Math.random() * 100) + 1;
  attempts = 0;
  attemptsElement.textContent = attempts;
  userGuessInput.value = '';
  message.textContent = '';
  submitButton.disabled = false;
  resetButton.style.display = 'none';
}

// Event listeners
submitButton.addEventListener('click', checkGuess);
resetButton.addEventListener('click', resetGame);
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        // Set up the game variables
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int userGuess = 0;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
        
        // Game loop
        while (userGuess != numberToGuess) {
            attempts++;
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
            }
        }
        
        // Close the scanner object
        scanner.close();
    }
}
