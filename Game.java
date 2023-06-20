import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/** A number guessing game. */
public class Game {
  public static void main(String[] args) {
    System.out.println("Welcome to the Guessing Game!");

    Scanner input = new Scanner(System.in);

    try {
      // Get user's name
      System.out.println("Enter your name:");
      String name = input.nextLine();
      // Test that everything works
      System.out.println(
        name + ", I'm thinknig of a number between 0 and 100."
      );

      // Create an instance of the Random object
      Random rand = new Random();

      // Call method nextInt and pass in upper range (exclusive)
      int number = rand.nextInt(101);
      int guesses = 0;
      
      // Start while loop. Condition: userGuess != number
      // Checks for userGuess against number (too low, too high, equals)
      // Increment guesses for each iteration
      boolean guessIsCorrect = false;
      while (!guessIsCorrect) {
        System.out.println("Enter your guess:");

        int userGuess;
        try {
          userGuess = input.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Guess is not a number.");
          input.nextLine();
          continue;
        }

        // if (userGuess < 10) {
        //   throw new Exception("Test message");
        // }

        guesses += 1;

        if (userGuess < number) {
          System.out.println("Too low");
        } else if (userGuess > number ) {
          System.out.println("Too high");
        } else {
          guessIsCorrect = true;
          System.out.println("Congratulations!, You guessed my number in " + guesses + " tries!");
        }
      }
    } catch(Exception e) {
      System.out.println(e);
      System.out.println("---"); 
      System.out.println(e.getMessage());
      System.out.println("---");
      System.out.println(e.getStackTrace().toString());
    } finally {
      input.close();
    }
  }
}
