package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyImageView;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyGridPane;
import GUI.Layouts.MyHbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class CityViewWindow {

    public static MyLabel cityNameLabel;
    public static MyLabel playerGoldAmountLabel;
    public static MyLabel playerFoodAmountLabel;
    public static MyLabel turnsLabel;

    private final MyScene cityViewScene;
    public static MyGridPane cityViewGridPane;

    public CityViewWindow() {
        Constants.playMusic(Constants.cityMusic);

        MyBorderPane borderPane = new MyBorderPane();
        MyHbox hboxForTopControllers = new MyHbox();
        cityViewGridPane = new MyGridPane();
        MyHbox bottomHbox = new MyHbox();

        hboxForTopControllers.setAlignment(Pos.CENTER);
        bottomHbox.setAlignment(Pos.CENTER);
        cityViewGridPane.setAlignment(Pos.CENTER);
        cityViewGridPane.setPadding(new Insets(30, 30, 30, 30));

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/city_background.jpg")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(Constants.GAME_WINDOW_SIZE_X,
                        Constants.GAME_WINDOW_SIZE_Y + 20, false,
                        false, false, false));
        borderPane.setBackground(new Background(backgroundImage));

        MyButton mapButton = new MyButton("Map");
        mapButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        mapButton.setTextFill(Color.DARKGOLDENROD);
        mapButton.setMinSize(30, 30);
        mapButton.setOpacity(0.8);
        mapButton.setOnAction(e -> {
            Controller.openMapFromCityView();
        });


        cityNameLabel = new MyLabel("City Name");
        cityNameLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        cityNameLabel.setTextFill(Color.MAROON);

        playerGoldAmountLabel = new MyLabel("Gold: 0000");
        playerGoldAmountLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        playerGoldAmountLabel.setTextFill(Color.MAROON);

        playerFoodAmountLabel = new MyLabel("Food: 0000");
        playerFoodAmountLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        playerFoodAmountLabel.setTextFill(Color.MAROON);

        turnsLabel = new MyLabel("Turns: 00");
        turnsLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        turnsLabel.setTextFill(Color.MAROON);


        MyButton buildButton = new MyButton("Build");
        buildButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        buildButton.setTextFill(Color.DARKGOLDENROD);
        buildButton.setMinSize(50, 50);
        buildButton.setOpacity(0.8);
        buildButton.setOnAction(e -> {
            Controller.buildButtonPressed();
        });

        MyButton armiesButton = new MyButton("Armies");
        armiesButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        armiesButton.setTextFill(Color.DARKGOLDENROD);
        armiesButton.setMinSize(50, 50);
        armiesButton.setOpacity(0.8);
        armiesButton.setOnAction(e -> {
            Controller.armiesButtonPressed();
        });

        MyButton defendingArmyButton = new MyButton("Defending Army");
        defendingArmyButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        defendingArmyButton.setTextFill(Color.DARKGOLDENROD);
        defendingArmyButton.setMinSize(50, 50);
        defendingArmyButton.setOpacity(0.8);
        defendingArmyButton.setOnAction(e -> {
            Controller.defendingArmyButtonPressed();
        });

        MyButton attackButton = new MyButton("Attack");
        attackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 30));
        attackButton.setTextFill(Color.DARKGOLDENROD);
        attackButton.setMinSize(50, 50);
        attackButton.setOpacity(0.8);
        attackButton.setOnAction(e -> {
            Controller.attackButtonPressed();
        });


        Image stables = new Image(new File("src/GUI/Resources/stables.png").toURI().toString());
        MyImageView stablesImg = new MyImageView();
        stablesImg.setImage(stables);
        stablesImg.setFitHeight(300);
        stablesImg.setFitWidth(300);

        Image barracks = new Image(new File("src/GUI/Resources/barracks.png").toURI().toString());
        MyImageView barracksImg = new MyImageView();
        barracksImg.setImage(barracks);
        barracksImg.setFitHeight(300);
        barracksImg.setFitWidth(300);

        Image archeryRange = new Image(new File("src/GUI/Resources/archery_range.png").toURI().toString());
        MyImageView archeryRangeImg = new MyImageView();
        archeryRangeImg.setImage(archeryRange);
        archeryRangeImg.setFitHeight(300);
        archeryRangeImg.setFitWidth(300);

        Image market = new Image(new File("src/GUI/Resources/market.png").toURI().toString());
        MyImageView marketImg = new MyImageView();
        marketImg.setImage(market);
        marketImg.setFitHeight(300);
        marketImg.setFitWidth(300);

        Image farm = new Image(new File("src/GUI/Resources/farm.png").toURI().toString());
        MyImageView farmImg = new MyImageView();
        farmImg.setImage(farm);
        farmImg.setFitHeight(300);
        farmImg.setFitWidth(300);

        Image tree0 =
                new Image(new File("src/GUI/Resources/tree.png").toURI().toString());

        MyImageView tree0Img = new MyImageView();
        tree0Img.setImage(tree0);
        tree0Img.setFitHeight(220);
        tree0Img.setFitWidth(220);


        MyImageView tree1Img = new MyImageView();
        tree1Img.setImage(tree0);
        tree1Img.setFitHeight(220);
        tree1Img.setFitWidth(220);


        MyImageView tree2Img = new MyImageView();
        tree2Img.setImage(tree0);
        tree2Img.setFitHeight(220);
        tree2Img.setFitWidth(220);


        MyImageView tree3Img = new MyImageView();
        tree3Img.setImage(tree0);
        tree3Img.setFitHeight(220);
        tree3Img.setFitWidth(220);

        MyImageView tree4Img = new MyImageView();
        tree4Img.setImage(tree0);
        tree4Img.setFitHeight(220);
        tree4Img.setFitWidth(220);


        hboxForTopControllers.getChildren().addAll(
                turnsLabel,
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                cityNameLabel,
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                playerGoldAmountLabel,
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                playerFoodAmountLabel,
                Constants.spaceButton2(),
                Constants.spaceButton2(),
                mapButton);


        cityViewGridPane.add(stablesImg, 0, 0);
        cityViewGridPane.add(tree0Img, 0, 1);

        cityViewGridPane.add(tree1Img, 1, 0);
        cityViewGridPane.add(archeryRangeImg, 1, 1);

        cityViewGridPane.add(farmImg, 2, 0);
        cityViewGridPane.add(marketImg, 2, 1);

        cityViewGridPane.add(tree3Img, 3, 0);
        cityViewGridPane.add(tree2Img, 3, 1);

        cityViewGridPane.add(barracksImg, 4, 0);
        cityViewGridPane.add(tree4Img, 4, 1);

        bottomHbox.getChildren().addAll(buildButton, Constants.spaceButton3(),
                armiesButton, Constants.spaceButton3(),
                defendingArmyButton, Constants.spaceButton3(), attackButton);

        borderPane.setTop(hboxForTopControllers);
        borderPane.setCenter(cityViewGridPane);
        borderPane.setBottom(bottomHbox);

        this.cityViewScene = new MyScene(borderPane);
    }

    public MyScene getCityViewScene() {
        return cityViewScene;
    }
}
