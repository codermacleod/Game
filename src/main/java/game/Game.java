package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {

    private ArrayList<String> wordList = new ArrayList<String>(Arrays.asList("Volvo", "BMW", "Ford", "Mazda"));
    private String wordToGuess;
    private String alteredWordToGuess;

    private StringBuilder newAlteredWordToGuess = new StringBuilder();
    private int counter = 10;
    private String letterGuess;

    public Game() {
        System.out.println("Empty Game Constructor");
    }
//    public Game(String wordToGuess, String letterGuess) {
//        this.wordToGuess = wordToGuess;
//        this.letterGuess = letterGuess;
//    }
    public ArrayList<String> getWordList() {
        return wordList;
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getLetterGuess() {
        return letterGuess;
    }

    public void setLetterGuess(String letterGuess) {
        this.letterGuess = letterGuess;
    }

    public String getWordToGuess() {
        Random rand = new Random();
        int randomNum = rand.nextInt(0, wordList.size());
        wordToGuess = wordList.get(randomNum);
        alteredWordToGuess = wordToGuess.charAt(0) + "_".repeat(wordToGuess.length() - 1);
        newAlteredWordToGuess.append(alteredWordToGuess);
        return alteredWordToGuess;
    }

    public String compareWord(String letterGuess) {
        // counter down by one
        counter--;
        // does wordToGuess contain letterGuess
        if (wordToGuess.contains(letterGuess)) {
            //get index to change
            int indexToReplace = wordToGuess.indexOf(letterGuess);

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.substring(i, i+1).equals(letterGuess)){
                    newAlteredWordToGuess.replace(i,i+1, letterGuess);
                }
            }
            return newAlteredWordToGuess.toString();
        }
        return alteredWordToGuess;
    }
}