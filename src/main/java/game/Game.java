package game;

import java.util.ArrayList;

public class Game {
    ArrayList<Character> guessedLetters = new ArrayList<>();
    private StringBuilder hiddenWord = new StringBuilder();
    private String wordToGuess;
    private int attempts = 10;
    private char letterGuess;
    WordChooser wordChooser = new WordChooser();
    public Game() {
        this.wordToGuess = wordChooser.getRandomWordFromDictionary();
    }
    public Game(WordChooser mockedChooser) {
        this.wordToGuess = mockedChooser.getRandomWordFromDictionary();
    }

    //    public Game(String wordToGuess, String letterGuess) {
//        this.wordToGuess = wordToGuess;
//        this.letterGuess = letterGuess;
//    }
//    public ArrayList<String> getWordList() {
//        return wordList;
//    }
    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setLetterGuess(char letterGuess) {
        this.letterGuess = letterGuess;
    }
    public char getLetterGuess() {
        return letterGuess;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public StringBuilder getHiddenWord() {
        //First setup of hidden word:
        if (hiddenWord.length() == 0) {
            hiddenWord.append(getWordToGuess().charAt(0));
            //Add underscores:
            for (int i = 1; i < wordToGuess.length(); i++) {
                hiddenWord.append("_");
            }
        }
        return hiddenWord;
    }

    public String compareWord(char letterGuess) {
        // does wordToGuess contain letterGuess
        if ((wordToGuess.contains(String.valueOf(letterGuess))) && !guessedLetters.contains(letterGuess)) {
            // counter down by one
            attempts--;
            //Add letter to guessedLetters array:
            guessedLetters.add(letterGuess);
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.substring(i, i+1).equals(String.valueOf(letterGuess))){
                    hiddenWord.replace(i,i+1, String.valueOf(letterGuess));
                }
            }
            System.out.println("Nice guess!");
        } else if (guessedLetters.contains(letterGuess)) {
            System.out.println("You've already guessed this letter. Please try again.");
        }
        else {
            System.out.println("Unlucky!");
            // counter down by one
            attempts--;
            guessedLetters.add(letterGuess);
        }
        return hiddenWord.toString();
    }

    public boolean guessLetter(char letterGuess){
        return wordToGuess.contains(String.valueOf(letterGuess));
    }
}