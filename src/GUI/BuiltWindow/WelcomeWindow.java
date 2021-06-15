package GUI.BuiltWindow;

import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Scenes.WelcomeScene;

public class WelcomeWindow {

    private WelcomeScene welcomeScene;

    public WelcomeWindow() {
        MyBorderPane welcomeSceneLayout = new MyBorderPane();
        MyLabel welcomeLabel = new MyLabel("Welcome To Empire Building");
        MyButton startGameButton = new MyButton("Start\nGame");
        welcomeSceneLayout.setTop(welcomeLabel);
        welcomeSceneLayout.setCenter(startGameButton);
        this.welcomeScene = new WelcomeScene(welcomeSceneLayout);
    }

    public WelcomeScene getWelcomeScene() {
        return welcomeScene;
    }

}
