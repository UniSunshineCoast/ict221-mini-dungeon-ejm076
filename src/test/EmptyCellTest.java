package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmptyCellTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testEmptyCellNoEffect() {
        Player player = new Player(0, 0);
        GameEngine engine = new GameEngine(10);
        EmptyCell cell = new EmptyCell();

        cell.onEnter(player, engine);

        assertEquals(10, player.getHp());
        assertEquals(0, player.getGold());
    }
}
