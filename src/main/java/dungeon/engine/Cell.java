package dungeon.engine;

import javafx.scene.layout.StackPane;

public abstract class Cell extends StackPane {
    private int x;
    private int y;

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public abstract void onEnter(Player player, GameEngine engine);
}
