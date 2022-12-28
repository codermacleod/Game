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
    }
    @Test public void testGuessLetterWrong() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockedChooser);

        assertEquals(game.guessLetter('O'), false);
    }
}