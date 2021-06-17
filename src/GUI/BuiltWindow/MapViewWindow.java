package GUI.BuiltWindow;

import GUI.Constants;
import GUI.CustomControllers.MyButton;
import GUI.Layouts.MyGridPane;
import GUI.Main;
import GUI.Scenes.MyScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;

public class MapViewWindow {

    private final MyScene mapViewScene;

    public MapViewWindow() {

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/mapGame.jpg")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(Constants.GAME_WINDOW_SIZE_X,
                        Constants.GAME_WINDOW_SIZE_Y + 20, false,
                        false, false, false));

        MyGridPane mapViewSceneLayout = new MyGridPane();
        mapViewSceneLayout.setBackground(new Background(backgroundImage));


        MyButton cairoButton = new MyButton("cairo");
        cairoButton.setPrefWidth(400);
        cairoButton.setPrefHeight(180);
        cairoButton.setOpacity(0);
        cairoButton.setOnMouseEntered(e -> {
            Constants.playEffect(Constants.clickButton);
        });
        cairoButton.setOnAction(e -> {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());
        });

        MyButton romeButton = new MyButton("rome");
        romeButton.setPrefWidth(400);
        romeButton.setPrefHeight(150);
        romeButton.setOpacity(0);
        romeButton.setOnMouseEntered(e -> {
            Constants.playEffect(Constants.clickButton);
        });
        romeButton.setOnAction(e -> {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());
        });


        MyButton spartaButton = new MyButton("sparta");
        spartaButton.setPrefWidth(330);
        spartaButton.setPrefHeight(220);
        spartaButton.setOpacity(0);
        spartaButton.setOnMouseEntered(e -> {
            Constants.playEffect(Constants.clickButton);
        });
        spartaButton.setOnAction(e -> {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());

        });

        MyButton settingsButton = new MyButton("settings");
        settingsButton.setPrefWidth(400);
        settingsButton.setPrefHeight(320);
        settingsButton.setOpacity(0);
        settingsButton.setOnMouseEntered(e -> {
            Constants.playEffect(Constants.clickButton);
        });
        settingsButton.setOnAction(e -> {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new SettingsWindow().getSettingsScene());
        });


        mapViewSceneLayout.add(Constants.spaceButton(), 0, 0);
        mapViewSceneLayout.add(Constants.spaceButton(), 0, 1);
        mapViewSceneLayout.add(settingsButton, 0, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 0, 3);
        mapViewSceneLayout.add(Constants.spaceButton(), 1, 0);
        mapViewSceneLayout.add(cairoButton, 1, 1);
        mapViewSceneLayout.add(Constants.spaceButton(), 1, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 1, 3);
        mapViewSceneLayout.add(Constants.spaceButton(), 2, 0);
        mapViewSceneLayout.add(Constants.spaceButton(), 2, 1);
        mapViewSceneLayout.add(Constants.spaceButton(), 2, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 2, 3);
        mapViewSceneLayout.add(romeButton, 3, 0);
        mapViewSceneLayout.add(Constants.spaceButton(), 3, 1);
        mapViewSceneLayout.add(spartaButton, 3, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 3, 3);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 0);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 1);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 2);
        mapViewSceneLayout.add(Constants.spaceButton(), 4, 3);



        this.mapViewScene = new MyScene(mapViewSceneLayout);
    }

    public MyScene getMapViewScene() {
        return mapViewScene;
    }
}
