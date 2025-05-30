package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameEngineTest {


    @Test
    public void testValidMovement() {
        GameEngine engine = new GameEngine(10);
        boolean moved = engine.movePlayer(1, 0);

        assertTrue(moved);
        assertEquals(1, engine.getPlayer().getX());
    }

    @Test
    public void testBlockedByWall() {
        GameEngine engine = new GameEngine(10);
        engine.getMap()[0][1] = new Wall();

        boolean moved = engine.movePlayer(1, 0);
        assertFalse(moved);
        assertEquals(0, engine.getPlayer().getX());
    }
}
