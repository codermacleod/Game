package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Start the game
        Game game = new Game();
        //Instantiating or Constructing the object with default
        Scanner letter = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("The first word to guess is: " + game.getHiddenWord());

        while (true) {
            if (game.getWordToGuess().equals(game.getHiddenWord().toString())){
                System.out.printf("You are simply awesome!\nYou guessed the word, '%s' correctly!\n",game.getHiddenWord());
                break;
            }
            if (game.getAttempts() == 0){
                System.out.println("You're out of guesses!");
                break;
            }
            System.out.println("You have " + game.getAttempts() + " attempts to guess the word.");
            //Get letter guess from user input:
            char letterGuess = letter.nextLine().toUpperCase().charAt(0);
            game.setLetterGuess(letterGuess);
            System.out.println(game.compareWord(game.getLetterGuess()));
        }
    }
}

