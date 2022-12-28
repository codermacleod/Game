package game;

import java.util.Random;

public class WordChooser {
    public final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};
    public String getRandomWordFromDictionary(){
        Random rand = new Random();
        int randomNum = rand.nextInt(0, (DICTIONARY.length-1));
        return DICTIONARY[randomNum];
    }
}
