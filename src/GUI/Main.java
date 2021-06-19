package GUI;

import GUI.BuiltWindow.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        setting the primary stage to the variable window to be able to change
//        scenes
        window = primaryStage;


//        Setting the first scene to the welcome scene and setting the title
        window.setScene(new WelcomeWindow().getWelcomeScene());
        window.setTitle("Empire Building");
        window.setMinWidth(Constants.GAME_WINDOW_SIZE_X);
        window.setMinHeight(Constants.GAME_WINDOW_SIZE_Y);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
