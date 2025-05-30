package dungeon.engine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameEngine {

    private final Cell[][] map;
    private final Player player;
    private int difficulty = 3;

    public GameEngine(int size) {
        map = new Cell[size][size];
        player = new Player(0, 0);

        // Fill map with empty cells
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Cell cell = new EmptyCell();
                cell.setPrefSize(60, 60);
                cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                cell.setPosition(x, y);
                map[y][x] = cell;
            }
        }

        // Maze-like wall layout that allows a clear path
        for (int x = 0; x < size; x++) {
            if (x != 0 && x != 1) place(new Wall(), x, 0);
            if (x != 9 && x != 8) place(new Wall(), x, 9);
        }

        for (int y = 0; y < size; y++) {
            if (y != 0 && y != 1) place(new Wall(), 0, y);
            if (y != 9 && y != 8) place(new Wall(), 9, y);
        }

        // Inner walls (not blocking main path)
        place(new Wall(), 2, 2);
        place(new Wall(), 2, 3);
        place(new Wall(), 3, 5);
        place(new Wall(), 4, 4);
        place(new Wall(), 5, 6);
        place(new Wall(), 6, 2);
        place(new Wall(), 6, 3);
        place(new Wall(), 7, 7);
        place(new Wall(), 8, 4);

        // Place game objects (ensuring they're not on walls)
        place(new Gold(), 1, 1);
        place(new Potion(), 2, 5);
        place(new Trap(), 4, 5);
        place(new MeleeMutant(), 5, 5);
        place(new RangedMutant(), 7, 5);
        place(new Ladder(), 9, 9);

        updatePlayerPosition();
    }

    private void place(Cell cell, int x, int y) {
        cell.setPrefSize(60, 60);
        cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        cell.setPosition(x, y);
        map[y][x] = cell;
    }

    public int getSize() {
        return map.length;
    }

    public Cell[][] getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean movePlayer(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;

        if (isInBounds(newX, newY) && player.getHp() > 0 && player.getSteps() < 100) {
            Cell target = map[newY][newX];

            if (target instanceof Wall) {
                return false; // Wall blocks movement
            }

            clearPlayerIcon();
            player.moveTo(newX, newY);
            player.incrementSteps();
            target.onEnter(player, this);
            updatePlayerPosition();
            runRangedMutantAttacks();
            return true;
        }

        return false;
    }

    private void runRangedMutantAttacks() {
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                Cell c = map[y][x];
                if (c instanceof RangedMutant) {
                    ((RangedMutant) c).tryRangedAttack(player);
                }
            }
        }
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < getSize() && y < getSize();
    }

    private void updatePlayerPosition() {
        int x = player.getX();
        int y = player.getY();

        Circle playerIcon = new Circle(10, Color.BLUE);
        map[y][x].getChildren().add(playerIcon);
    }

    private void clearPlayerIcon() {
        int x = player.getX();
        int y = player.getY();

        map[y][x].getChildren().removeIf(node -> node instanceof Circle);
    }

    public boolean hasWon() {
        return map[player.getY()][player.getX()] instanceof Ladder;
    }
}
