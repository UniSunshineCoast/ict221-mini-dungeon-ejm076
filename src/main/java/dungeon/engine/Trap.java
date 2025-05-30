package dungeon.engine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Trap extends Cell {
    private boolean triggered = false;

    public Trap() {
        Image img = new Image(getClass().getResourceAsStream("/images/trap.png"));
        ImageView view = new ImageView(img);
        view.setFitWidth(30);
        view.setFitHeight(30);
        this.getChildren().add(view);
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        if (!triggered) {
            player.reduceHp(3);
            triggered = true;
            this.getChildren().clear();
        }
    }
}
