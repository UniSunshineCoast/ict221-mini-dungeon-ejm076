package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrapTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testTrapDamagesPlayer() {
        Player player = new Player(0, 0);
        GameEngine engine = new GameEngine(10);
        Trap trap = new Trap();

        trap.onEnter(player, engine);

        assertTrue(player.getHp() < 10);
    }
}
