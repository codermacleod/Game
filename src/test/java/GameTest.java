import game.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GameTest {
    @Test
    public void testRandomGetsWordFromWordList() {
        Game game = new Game();
        assertEquals(true, game.getWordList().contains("Volvo"));
    }
    @Test
    public void testGetsInitialRemainingAttempts(){
        Game game = new Game();
        assertEquals(10,game.getAttempts());
    }
}