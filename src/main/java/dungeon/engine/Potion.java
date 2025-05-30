package dungeon.engine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Potion extends Cell {
    private boolean used = false;

    public Potion() {
        Image img = new Image(getClass().getResourceAsStream("/images/potion.png"));
        ImageView view = new ImageView(img);
        view.setFitWidth(30);
        view.setFitHeight(30);
        this.getChildren().add(view);
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        if (!used) {
            player.addHp(2);
            used = true;
            this.getChildren().clear();
        }
    }
}
