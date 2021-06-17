package GUI.BuiltWindow;

import GUI.Constants;
import GUI.CustomControllers.MyButton;
import GUI.Layouts.MyHbox;
import GUI.Main;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class CityOrArmyWindow {
    private final MyScene cityOrArmyWindow;

    public CityOrArmyWindow() {
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));

        MyButton armyButton = new MyButton("Show Army");
        armyButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        armyButton.setPadding(new Insets(50, 50, 50, 50));
        armyButton.setTextFill(Color.DARKGOLDENROD);
        armyButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new ShowArmyWindow().getShowArmyScene());
        });

        MyButton cityButton = new MyButton("Show City");
        cityButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        cityButton.setPadding(new Insets(50, 50, 50, 50));
        cityButton.setTextFill(Color.DARKGOLDENROD);
        cityButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);

        });

        hbox.getChildren().addAll(armyButton, Constants.spaceButton(), cityButton);

        this.cityOrArmyWindow = new MyScene(hbox);
    }

    public MyScene getCityOrArmyWindow() {
        return cityOrArmyWindow;
    }
}
