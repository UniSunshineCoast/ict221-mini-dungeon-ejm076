package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeleeMutantTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testMeleeMutantAttacksPlayer() {
        Player player = new Player(0, 0);
        GameEngine engine = new GameEngine(10);
        MeleeMutant mutant = new MeleeMutant();

        mutant.onEnter(player, engine);

        assertTrue(player.getHp() < 10);
    }
}
