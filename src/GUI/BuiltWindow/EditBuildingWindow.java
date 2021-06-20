package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyChoiceBox;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class EditBuildingWindow {
    private final MyScene editBuildingScene;

    public static ChoiceBox<String> buildingChoiceBox;
    public static MyLabel buildingLevelLabel;
    public static MyButton harvestOrRecruitButton;


    public EditBuildingWindow(String marketLevel, String farmLevel,
                              String archeryRangeLevel, String stablesLevel,
                              String barracksLevel) {

        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hboxTop = new MyHbox();
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPadding(new Insets(50, 0, 0, 0));
        MyHbox hboxCenter = new MyHbox();
        hboxCenter.setAlignment(Pos.CENTER);


        buildingChoiceBox = new MyChoiceBox();
        buildingChoiceBox.getItems().addAll("Stable", "Barracks", "ArcheryRange"
                , "Market", "Farm");
        buildingChoiceBox.setPrefSize(300, 100);
        buildingChoiceBox.setStyle("-fx-font-size : 20pt;");
        buildingChoiceBox.setOnAction(e -> {
            if (buildingChoiceBox.getValue().equals("Stable")) {
                buildingLevelLabel.setText("Level: " + stablesLevel);
                harvestOrRecruitButton.setText("Recruit");
            } else if (buildingChoiceBox.getValue().equals("Barracks")) {
                buildingLevelLabel.setText("Level: " + barracksLevel);
                harvestOrRecruitButton.setText("Recruit");
            } else if (buildingChoiceBox.getValue().equals("ArcheryRange")) {
                buildingLevelLabel.setText("Level: " + archeryRangeLevel);
                harvestOrRecruitButton.setText("Recruit");
            } else if (buildingChoiceBox.getValue().equals("Market")) {
                buildingLevelLabel.setText("Level: " + marketLevel);
                harvestOrRecruitButton.setText("Harvest");
            } else if (buildingChoiceBox.getValue().equals("Farm")) {
                buildingLevelLabel.setText("Level: " + farmLevel);
                harvestOrRecruitButton.setText("Harvest");
            }
        });


        buildingLevelLabel = new MyLabel("Level: 0");
        buildingLevelLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 90));
        buildingLevelLabel.setTextFill(Color.DARKGOLDENROD);


        harvestOrRecruitButton = new MyButton("Action");
        harvestOrRecruitButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        harvestOrRecruitButton.setTextFill(Color.DARKGOLDENROD);
        harvestOrRecruitButton.setOnAction(event -> {
            try {
                Controller.recruitButtonPressed(buildingChoiceBox.getValue());
                Controller.game.endTurn();
            } catch (Exception e) {
                new PopUpWindow(e.toString());
            }
        });

        MyButton upgrade = new MyButton("Build");
        upgrade.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        upgrade.setTextFill(Color.DARKGOLDENROD);
        upgrade.setOnAction(event -> {
            try {
                Controller.buildButtonPressed(buildingChoiceBox.getValue());
                Controller.game.endTurn();
            } catch (Exception e) {
                new PopUpWindow(e.toString());
            }
        });

        MyButton backButton = new MyButton("Upgrade");
        backButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        backButton.setTextFill(Color.DARKGOLDENROD);
        backButton.setOnAction(event -> {
            try {
                Controller.upgradeButtonPressed(buildingChoiceBox.getValue());
                Controller.game.endTurn();
            } catch (Exception e) {
                new PopUpWindow(e.toString());
            }
        });


        hboxTop.getChildren().addAll(buildingChoiceBox,
                Constants.spaceButton2(), buildingLevelLabel);

        hboxCenter.getChildren().addAll(harvestOrRecruitButton,
                Constants.spaceButton2(), upgrade, Constants.spaceButton2(),
                backButton);

        borderPane.setTop(hboxTop);
        borderPane.setCenter(hboxCenter);

        this.editBuildingScene = new MyScene(borderPane);
    }

    public MyScene getEditBuildingScene() {
        return editBuildingScene;
    }
}
