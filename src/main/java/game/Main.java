package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Start the game
        Game game = new Game();
        //Instantiating or Constructing the object with default
        Scanner letter = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("The first word to guess is: " + game.getAlteredWordToGuess());

        while (game.getCounter() > 0) {
            if (game.getWordToGuess().equals(game.getNewAlteredWordToGuess().toString())){
                System.out.printf("You are simply awesome!\nYou guessed the word, '%s' correctly!\n",game.getNewAlteredWordToGuess());
                break;
            }
            System.out.println("You have " + game.getCounter() + " attempts to guess the word.");
            //Get letter guess from user input:
            String letterGuess = letter.nextLine();
            game.setLetterGuess(letterGuess);
            System.out.println(game.compareWord(game.getLetterGuess()));
        }
    }
}
