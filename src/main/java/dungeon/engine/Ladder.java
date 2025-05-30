package dungeon.engine;

import javafx.scene.control.Label;

public class Ladder extends Cell {

    public Ladder() {
        this.getChildren().add(new Label("🪜"));
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        player.addScore(20); // optional
    }
}
