package game;

public class Game {

    private StringBuilder hiddenWord = new StringBuilder();
//    private ArrayList<String> wordList = new ArrayList<String>(Arrays.asList("Volvo", "BMW", "Ford", "Mazda"));
    private String wordToGuess;
//    private String alteredWordToGuess;
    
    private int attempts = 10;
    private String letterGuess;

    public Game() {
        WordChooser wordChooser = new WordChooser();
        this.wordToGuess = wordChooser.getRandomWordFromDictionary();
    }
//    public Game(String wordToGuess) {
//        this.wordToGuess = wordToGuess;
//    }
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

    public String getLetterGuess() {
        return letterGuess;
    }

    public void setLetterGuess(String letterGuess) {
        this.letterGuess = letterGuess.toUpperCase();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }


    public StringBuilder getHiddenWord() {
        //Add first letter:
        if (hiddenWord.length() == 0) {
            hiddenWord.append(getWordToGuess().charAt(0));
            //Add underscores:
            for (int i = 1; i < wordToGuess.length(); i++) {
                hiddenWord.append("_");
            }
        }
        return hiddenWord;
    }

    public String compareWord(String letterGuess) {
        // counter down by one
        attempts--;
        // does wordToGuess contain letterGuess
        if (wordToGuess.contains(letterGuess)) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.substring(i, i+1).equals(letterGuess)){
                    hiddenWord.replace(i,i+1, letterGuess);
                }
            }
        }
        return hiddenWord.toString();
    }
}