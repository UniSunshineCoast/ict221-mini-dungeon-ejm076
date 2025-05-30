package dungeon.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangedMutantTest {

    @Test
    public void testRangedMutantShootsPlayer() {
        Player player = new Player(5, 5);
        GameEngine engine = new GameEngine(10);
        RangedMutant mutant = new RangedMutant();
        mutant.setPosition(5, 2); // 3 tiles north

        int oldHp = player.getHp();
        mutant.tryRangedAttack(player);

        assertTrue(player.getHp() <= oldHp && player.getHp() >= oldHp - 2);
    }
}
