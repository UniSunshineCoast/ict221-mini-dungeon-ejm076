package dungeon.engine;

public class EmptyCell extends Cell {

    public EmptyCell() {
        this.setPrefSize(60, 60);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Override
    public void onEnter(Player player, GameEngine engine) {
        // No effect
    }
}
