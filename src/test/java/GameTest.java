import game.Game;
import game.WordChooser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    @Test
    public void testGetsWordToGuessWithRandomWord() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

        Game game = new Game(mockedChooser);

        assertEquals(game.getHiddenWord().toString(), "D________");
    }
    @Test
    public void testGetsInitialRemainingAttempts(){
        Game game = new Game();
        assertEquals(10,game.getAttempts());
    }

    @Test public void testGuessLetterRightAndDisplayGuessedLetter() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);

        assertEquals(game.guessLetter('K'), true);
        assertEquals(game.compareWord('K'), "M_K___");
    }
    @Test public void testGuessLetterWrong() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);

        assertEquals(game.guessLetter('O'), false);
        assertEquals(game.compareWord('O'), "M_____");
    }

    @Test public void testShouldLoseGameIfNoAttemptsLeft(){
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);
        for (int i = 0; i < 10; i++) {
            assertEquals(game.guessLetter('O'), false);
        }
    }
    @Test public void testIsWon() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("TEA");

        Game game = new Game(mockedChooser);
        game.compareWord('T');
        game.compareWord('E');
        game.compareWord('A');

        assertEquals(game.getHiddenWord().toString(), "TEA");
    }

    @Test public void testIsWonWithSpecialWord() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("COOL");

        Game game = new Game(mockedChooser);
        game.compareWord('C');
        game.compareWord('O');
        game.compareWord('L');

        assertEquals(game.getHiddenWord().toString(), "COOL");
    }

}