package dungeon.engine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RangedMutant extends Cell {
    private boolean active = true;

    public RangedMutant() {
        Image img = new Image(getClass().getResourceAsStream("/images/ranged_mutant.png"));
        ImageView view = new ImageView(img);
        view.setFitWidth(30);
        view.setFitHeight(30);
        this.getChildren().add(view);
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    // Called when player steps directly onto this tile
    @Override
    public void onEnter(Player player, GameEngine engine) {
        if (active) {
            player.addScore(2); // No HP lost for defeating directly
            active = false;
            this.getChildren().clear();
        }
    }

    // Called every move in GameEngine
    public void tryRangedAttack(Player player) {
        if (!active) return;

        int dx = Math.abs(player.getX() - getX());
        int dy = Math.abs(player.getY() - getY());

        // Check within 2 tiles (horizontal or vertical only)
        if ((dx == 0 && dy <= 2) || (dy == 0 && dx <= 2)) {
            if (Math.random() < 0.5) {
                player.reduceHp(2);
                System.out.println("Ranged mutant attacked the player!");
            }
        }
    }
}
