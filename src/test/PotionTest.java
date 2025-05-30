package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PotionTest extends dungeon.engine.GuiTestSupport {

    @Test
    public void testPotionHealsPlayer() {
        Player player = new Player(0, 0);
        player.reduceHp(5);
        GameEngine engine = new GameEngine(10);

        Potion potion = new Potion();
        potion.onEnter(player, engine);

        assertTrue(player.getHp() > 5 && player.getHp() <= 10);
    }
}
