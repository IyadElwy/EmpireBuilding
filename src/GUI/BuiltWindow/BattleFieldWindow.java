package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyImageView;
import GUI.CustomControllers.MyTextArea;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class BattleFieldWindow {
    private final MyScene scene;
    public static MyButton mapButton;
    public static MyTextArea battleLogTextArea;
    public static MyButton defendingArmyStatusButton;
    public static MyButton attackingArmyStatusButton;
    public static MyButton chooseNextAttackButton;

    public BattleFieldWindow() {
        MyBorderPane borderPane = new MyBorderPane();
        MyHbox hboxForMap = new MyHbox();
        MyBorderPane battleFieldPane = new MyBorderPane();
        MyVbox armyImgsLeft = new MyVbox();
        MyVbox armyImgsRight = new MyVbox();
        MyHbox bottomPane = new MyHbox();
        MyVbox battleLogPane = new MyVbox();
        MyHbox armyStatusPane = new MyHbox();
        MyHbox nextAttackPane = new MyHbox();
        MyVbox takeActionPane = new MyVbox();

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/battleGroundjpg.jpg")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(Constants.GAME_WINDOW_SIZE_X,
                        Constants.GAME_WINDOW_SIZE_Y + 20, false,
                        false, false, false));
        borderPane.setBackground(new Background(backgroundImage));

        hboxForMap.setAlignment(Pos.TOP_RIGHT);
        hboxForMap.setPadding(new Insets(10, 50, 50, 50));
        battleLogPane.setAlignment(Pos.BOTTOM_LEFT);
        battleLogPane.setPadding(new Insets(10, 10, 10, 10));
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        nextAttackPane.setPadding(new Insets(10, 10, 10, 10));


        mapButton = new MyButton("Map");
        mapButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        mapButton.setTextFill(Color.DARKGOLDENROD);
        mapButton.setMinSize(50, 50);
        mapButton.setOpacity(0.8);
        mapButton.setOnAction(e -> {
            Controller.mapButtonPressedBattleField();
        });

        battleLogTextArea = new MyTextArea("");
        battleLogTextArea.setEditable(false);
        battleLogTextArea.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 15));
        battleLogTextArea.setStyle("-fx-text-inner-color: #6A1412");
        battleLogTextArea.setOpacity(0.8);

        defendingArmyStatusButton = new MyButton("Defending\nArmy\nStatus");
        defendingArmyStatusButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 25));
        defendingArmyStatusButton.setTextFill(Color.DARKGOLDENROD);
        defendingArmyStatusButton.setMinSize(50, 50);
        defendingArmyStatusButton.setOpacity(0.8);
        defendingArmyStatusButton.setOnAction(e -> {
            Controller.showDefendingArmyStatus();
        });

        attackingArmyStatusButton = new MyButton("Attacking\nArmy\nStatus");
        attackingArmyStatusButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 25));
        attackingArmyStatusButton.setTextFill(Color.DARKGOLDENROD);
        attackingArmyStatusButton.setMinSize(50, 50);
        attackingArmyStatusButton.setOpacity(0.8);
        attackingArmyStatusButton.setOnAction(e -> {
            Controller.showAttackingArmyStatus();
        });

        chooseNextAttackButton = new MyButton("Choose Next Attack");
        chooseNextAttackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 29.6));
        chooseNextAttackButton.setTextFill(Color.DARKGOLDENROD);
        chooseNextAttackButton.setMinSize(50, 100);
        chooseNextAttackButton.setOpacity(0.8);
        chooseNextAttackButton.setOnAction(e -> {
            Controller.chooseNextAttack();

        });

        Image cavalryLeft = new Image(new File("src/GUI/Resources/" +
                "CavalryYemin.png").toURI().toString());
        MyImageView cavalryLeftImg = new MyImageView();
        cavalryLeftImg.setImage(cavalryLeft);
        cavalryLeftImg.setFitHeight(180);
        cavalryLeftImg.setFitWidth(180);

        Image cavalryRight = new Image(new File("src/GUI/Resources/" +
                "CavalryShemal.png").toURI().toString());
        MyImageView cavalryRightImg = new MyImageView();
        cavalryRightImg.setImage(cavalryRight);
        cavalryRightImg.setFitHeight(180);
        cavalryRightImg.setFitWidth(180);

        Image archeryLeft = new Image(new File("src/GUI/Resources/" +
                "ArcheryYemin.png").toURI().toString());
        MyImageView archeryLeftImg = new MyImageView();
        archeryLeftImg.setImage(archeryLeft);
        archeryLeftImg.setFitHeight(180);
        archeryLeftImg.setFitWidth(180);

        Image archeryRight = new Image(new File("src/GUI/Resources/" +
                "ArcheryShemal.png").toURI().toString());
        MyImageView archeryRightImg = new MyImageView();
        archeryRightImg.setImage(archeryRight);
        archeryRightImg.setFitHeight(180);
        archeryRightImg.setFitWidth(180);

        Image infantryLeft = new Image(new File("src/GUI/Resources/" +
                "InfantryYemin.png").toURI().toString());
        MyImageView infantryLeftImg = new MyImageView();
        infantryLeftImg.setImage(infantryLeft);
        infantryLeftImg.setFitHeight(180);
        infantryLeftImg.setFitWidth(180);

        Image infantryRight = new Image(new File("src/GUI/Resources/" +
                "InfantryShemal.png").toURI().toString());
        MyImageView infantryRightImg = new MyImageView();
        infantryRightImg.setImage(infantryRight);
        infantryRightImg.setFitHeight(180);
        infantryRightImg.setFitWidth(180);


        armyImgsLeft.getChildren().addAll(infantryLeftImg, cavalryLeftImg,
                archeryLeftImg);
        armyImgsRight.getChildren().addAll(infantryRightImg, cavalryRightImg,
                archeryRightImg);

        battleFieldPane.setLeft(armyImgsLeft);
        battleFieldPane.setRight(armyImgsRight);


        hboxForMap.getChildren().addAll(
                mapButton);
        battleLogPane.getChildren().add(battleLogTextArea);
        armyStatusPane.getChildren().addAll(defendingArmyStatusButton, Constants.spaceButton3(),
                attackingArmyStatusButton);
        nextAttackPane.getChildren().addAll(chooseNextAttackButton);

        borderPane.setTop(hboxForMap);
        borderPane.setCenter(battleFieldPane);
        takeActionPane.getChildren().addAll(armyStatusPane, nextAttackPane);
        bottomPane.getChildren().addAll(battleLogPane, Constants.spaceButton2(),
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                takeActionPane);
        borderPane.setBottom(bottomPane);

        this.scene = new MyScene(borderPane);
    }

    public MyScene getScene() {
        return scene;
    }
}