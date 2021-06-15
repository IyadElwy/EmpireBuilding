package GUI.Scenes;

import GUI.Constants;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class WelcomeScene extends Scene {

    public WelcomeScene(Pane layout) {
        super(layout, Constants.GAME_WINDOW_SIZE_X,
                Constants.GAME_WINDOW_SIZE_Y);
    }
}
