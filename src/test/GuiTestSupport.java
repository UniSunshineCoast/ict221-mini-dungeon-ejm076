package dungeon.engine;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;

public class GuiTestSupport {

    @BeforeAll
    public static void initJavaFX() {
        // Forces JavaFX to initialize by creating a dummy panel
        new JFXPanel(); // Starts JavaFX toolkit in background thread
        Platform.setImplicitExit(false);
    }
}
