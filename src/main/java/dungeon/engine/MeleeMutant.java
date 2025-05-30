package dungeon.engine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MeleeMutant extends Cell {
    private boolean active = true;

    public MeleeMutant() {
        Image img = new Image(getClass().getResourceAsStream("/images/melee_mutant.png"));
        ImageView view = new ImageView(img);
        view.setFitWidth(30);
        view.setFitHeight(30);
        this.getChildren().add(view);
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        if (active) {
            player.reduceHp(2);
            player.addScore(5);
            active = false;
            this.getChildren().clear();
        }
    }
}
