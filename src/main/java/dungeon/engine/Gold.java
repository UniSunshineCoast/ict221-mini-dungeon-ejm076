package dungeon.engine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gold extends Cell {
    private boolean collected = false;

    public Gold() {
        Image img = new Image(getClass().getResourceAsStream("/images/gold.png"));
                ImageView view = new ImageView(img);
        view.setFitWidth(30);
        view.setFitHeight(30);
        this.getChildren().add(view);
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        if (!collected) {
            player.addGold(1);
            collected = true;
            this.getChildren().clear();
        }
    }
}
