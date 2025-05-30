package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoldTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testGoldPickup() {
        Player player = new Player(0, 0);
        GameEngine engine = new GameEngine(10);
        Gold gold = new Gold();

        gold.onEnter(player, engine);

        assertEquals(1, player.getGold());
        assertEquals(2, player.getScore());  // ✅ Fix this line!
    }
}
