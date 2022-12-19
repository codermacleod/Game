import game.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GameTest {
    @Test
    public void testRandomGetsWordFromWordList() {
        Game game = new Game();
        assertEquals(true, game.getWordList().contains(game.getWordToGuess()));
    }
//    @Test public void testGetsWordToGuess() {
//        Game makersGame = new Game("MAKERS");
//        assertEquals("MAKERS", makersGame.getWordToGuess());
//        }
}