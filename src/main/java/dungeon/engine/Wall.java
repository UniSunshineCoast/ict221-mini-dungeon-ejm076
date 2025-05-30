package dungeon.engine;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Cell {

    public Wall() {
        Rectangle block = new Rectangle(60, 60);
        block.setFill(Color.DIMGRAY);
        this.getChildren().add(block);
        this.getChildren().add(new Label("🧱"));
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        // Do nothing. Movement is blocked before this is called.
    }
}
