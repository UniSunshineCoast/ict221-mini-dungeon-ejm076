package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    public void testWinCondition() {
        Player player = new Player(0, 0);
        GameEngine engine = new GameEngine(10);
        Ladder ladder = new Ladder();

        engine.getMap()[0][0] = ladder;
        ladder.onEnter(player, engine);

        assertTrue(engine.hasWon());
    }
}
