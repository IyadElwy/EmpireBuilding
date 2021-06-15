package GUI;

import javafx.stage.Screen;

public class Constants {

    public static final double GAME_WINDOW_SIZE_X =
            Screen.getPrimary().getBounds().getMaxX();
    public static final double GAME_WINDOW_SIZE_Y =
            Screen.getPrimary().getBounds().getMaxY() - 20;
}
