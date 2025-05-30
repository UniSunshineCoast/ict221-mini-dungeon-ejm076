package dungeon.gui;

import dungeon.engine.Cell;
import dungeon.engine.GameEngine;
import dungeon.engine.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML private GridPane gridPane;
    @FXML private Label hpLabel;
    @FXML private Label goldLabel;
    @FXML private Label stepsLabel;
    @FXML private Label scoreLabel;
    @FXML private TextArea logArea;
    @FXML private ListView<String> scoreList;

    private GameEngine engine;

    @FXML
    public void initialize() {
        engine = new GameEngine(10);
        updateGui();
        updateStats();
    }

    private void updateGui() {
        gridPane.getChildren().clear();
        Cell[][] map = engine.getMap();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                gridPane.add(map[y][x], x, y);
            }
        }
        gridPane.setGridLinesVisible(true);
    }

    private void updateStats() {
        Player p = engine.getPlayer();
        hpLabel.setText("HP: " + p.getHp());
        goldLabel.setText("Gold: " + p.getGold());
        stepsLabel.setText("Steps: " + p.getSteps());
        scoreLabel.setText("Score: " + p.getScore());

        if (p.getHp() <= 0) {
            log("You died! Game over.");
        } else if (p.getSteps() >= 100) {
            log("Out of steps! Game over.");
        } else if (engine.hasWon()) {
            log("You reached the ladder! Victory!");
        }
    }

    private void log(String msg) {
        logArea.appendText(msg + "\n");
    }

    @FXML public void moveUp()    { handleMove(0, -1); }
    @FXML public void moveDown()  { handleMove(0, 1); }
    @FXML public void moveLeft()  { handleMove(-1, 0); }
    @FXML public void moveRight() { handleMove(1, 0); }

    private void handleMove(int dx, int dy) {
        if (engine.movePlayer(dx, dy)) {
            log("Moved to (" + engine.getPlayer().getX() + "," + engine.getPlayer().getY() + ")");
        } else {
            log("Move blocked or game over.");
        }
        updateGui();
        updateStats();
    }

    @FXML
    public void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("Mini Dungeon Help");
        alert.setContentText("Move with arrow buttons.\nCollect gold 💰, avoid traps ☠️, drink potions 🧪, fight mutants 👹/🎯, reach the ladder 🪜!");
        alert.showAndWait();
    }

    @FXML
    public void resetGame() {
        initialize();
        log("Game reset.");
    }
}
