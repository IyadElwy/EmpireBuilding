package GUI;

import GUI.BuiltWindow.WelcomeWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        setting the primary stage to the variable window to be able to change
//        scenes
        window = primaryStage;

//        The welcome window
        WelcomeWindow welcomeWindow = new WelcomeWindow();


//        Setting the first scene to the welcome scene
        window.setScene(welcomeWindow.getWelcomeScene());
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
