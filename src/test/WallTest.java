package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WallTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testWallBlocksPlayer() {
        Player player = new Player(0, 0);
        GameEngine engine = new GameEngine(10);
        Wall wall = new Wall();

        wall.onEnter(player, engine);

        assertEquals(10, player.getHp());
    }
}
