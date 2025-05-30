package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testInitialValues() {
        Player player = new Player(0, 0);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertEquals(10, player.getHp());
        assertEquals(0, player.getGold());
    }

    @Test
    public void testMoveAndGold() {
        Player player = new Player(0, 0);
        player.moveTo(2, 3);
        assertEquals(2, player.getX());
        assertEquals(3, player.getY());

        player.addGold(5);
        assertEquals(5, player.getGold());

        player.reduceHp(4);
        assertEquals(6, player.getHp());
    }
}
