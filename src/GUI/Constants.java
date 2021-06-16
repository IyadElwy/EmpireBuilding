package GUI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;

import java.io.File;

public class Constants {

    public static final double GAME_WINDOW_SIZE_X =
            Screen.getPrimary().getBounds().getMaxX() - 5;
    public static final double GAME_WINDOW_SIZE_Y =
            Screen.getPrimary().getBounds().getMaxY() - 35;

    public static Media openingMusic = new Media(new File("src/GUI/Resources" +
            "/openingWindowsSound.mp3").toURI().toString());
    public static Media clickButton = new Media(new File("src/GUI/Resources/" +
            "sword_button_click.mp3").toURI().toString());

    public static void playMusic(Media media) {
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static void playEffect(Media media) {
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }


}
