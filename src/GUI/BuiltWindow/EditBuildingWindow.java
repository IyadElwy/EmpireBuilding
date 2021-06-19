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


    public EditBuildingWindow() {

        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hboxTop = new MyHbox();
        hboxTop.setAlignment(Pos.CENTER);
        hboxTop.setPadding(new Insets(50, 0, 0, 0));
        MyHbox hboxCenter = new MyHbox();
        hboxCenter.setAlignment(Pos.CENTER);


        buildingChoiceBox = new MyChoiceBox();
        buildingChoiceBox.getItems().addAll("Stables", "Barracks", "Archery Range"
                , "Market", "Farm");
        buildingChoiceBox.setPrefSize(300, 100);
        buildingChoiceBox.setStyle("-fx-font-size : 20pt;");
        buildingChoiceBox.setOnAction(e -> {

        });


        buildingLevelLabel = new MyLabel("Level: 0");
        buildingLevelLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 90));
        buildingLevelLabel.setTextFill(Color.DARKGOLDENROD);



        MyButton harvestOrRecruitButton = new MyButton("Action");
        harvestOrRecruitButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        harvestOrRecruitButton.setTextFill(Color.DARKGOLDENROD);
        harvestOrRecruitButton.setOnAction(event -> {
            Controller.harvestButtonPressed();
        });

        MyButton upgrade = new MyButton("Upgrade");
        upgrade.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        upgrade.setTextFill(Color.DARKGOLDENROD);
        upgrade.setOnAction(event -> {
            Controller.upgradeBuildingButtonPressed();
        });

        MyButton backButton = new MyButton("Back");
        backButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        backButton.setTextFill(Color.DARKGOLDENROD);
        backButton.setOnAction(event -> {
            Controller.goBackToCityFromEditBuilding();

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
