package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTableView;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyGridPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import exceptions.MaxCapacityException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import units.Army;
import units.Unit;

import java.io.File;

public class ShowDefendingArmyOfCityWindow {

    private final MyScene scene;

    public static MyTableView defendingArmytableView;
    public static MyLabel defendingArmytitle;
    public static MyButton backButton;
    public static MyButton relocateButton;

    public ShowDefendingArmyOfCityWindow(String city, boolean ofAttack) {
        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        MyGridPane gridPane = new MyGridPane();
        MyVbox vbox = new MyVbox();
        vbox.setAlignment(Pos.CENTER);

        if (ofAttack) {
            defendingArmytitle = new MyLabel(city + " Defending Army");
        } else {
            defendingArmytitle = new MyLabel(Controller.inWhatCity + " Defending Army");
        }
        defendingArmytitle.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 70));
        defendingArmytitle.setTextFill(Color.DARKGOLDENROD);


        TableColumn<Unit, String> typeColumn = new TableColumn<>(
                "Type");
        TableColumn<Unit, String> levelColumn = new TableColumn<>(
                "Level");
        TableColumn<Unit, String> maxSoldierColumn = new TableColumn<>(
                "Max Soldiers");
        TableColumn<Unit, String> currentSoldiersColumn = new TableColumn<>(
                "Current Soldiers");
//        TableColumn<UnitsHelperClass, RadioButton> radioButtonColumn =
//                new TableColumn<>(
//                        "Relocate");


        typeColumn.setMinWidth(478);
        typeColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        levelColumn.setMinWidth(478);
        levelColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        maxSoldierColumn.setMinWidth(478);
        maxSoldierColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        currentSoldiersColumn.setMinWidth(478);
        currentSoldiersColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
//        radioButtonColumn.setMinWidth(390);


        typeColumn.setCellValueFactory(new PropertyValueFactory<>(
                "type"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>(
                "level"));
        maxSoldierColumn.setCellValueFactory(new PropertyValueFactory<>(
                "maxSoldierCount"));
        currentSoldiersColumn.setCellValueFactory(new PropertyValueFactory<>(
                "currentSoldierCount"));
//        radioButtonColumn.setCellValueFactory(new PropertyValueFactory<>(
//                "relocateButton"));


        defendingArmytableView = new MyTableView();
        defendingArmytableView.setEditable(false);
        if (ofAttack) {
            defendingArmytableView.setItems(Controller.putDefendingputdArmyUnits(Controller.cityToAttack));
        } else {
            defendingArmytableView.setItems(Controller.putDefendingputdArmyUnits(Controller.inWhatCity));
        }
        defendingArmytableView.getColumns().addAll(typeColumn, levelColumn, maxSoldierColumn,
                currentSoldiersColumn
//                , radioButtonColumn
        );

        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 160, 0));


        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);

        backButton = new MyButton("Back");
        backButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        backButton.setTextFill(Color.DARKGOLDENROD);
        backButton.setOnAction(event -> {
            Controller.showDefendingArmyWindowBackButtonOnAction();
        });

        relocateButton = new MyButton("Relocate");
        relocateButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        relocateButton.setTextFill(Color.DARKGOLDENROD);
        relocateButton.setOnAction(event -> {

            Unit unit = (Unit) ShowDefendingArmyOfCityWindow.
                    defendingArmytableView.getSelectionModel().getSelectedItem();

            if (Controller.game.getPlayer().getControlledArmies().isEmpty()) {
                Controller.game.getPlayer().initiateArmy(Controller.game.getPlayer().getControlledCities().get(0),
                        unit);
                for (Army army : Controller.game.getPlayer().getControlledArmies()
                ) {
                    try {
                        army.relocateUnit(unit);
                    } catch (MaxCapacityException maxCapacityException) {
                        new PopUpWindow(maxCapacityException.toString());
                    }
                }
            } else {
                for (Army army : Controller.game.getPlayer().getControlledArmies()
                ) {
                    try {
                        army.relocateUnit(unit);
                    } catch (MaxCapacityException maxCapacityException) {
                        new PopUpWindow(maxCapacityException.toString());
                    }
                }
            }

            ShowDefendingArmyOfCityWindow.defendingArmytableView.getItems().remove(unit);

            Controller.showDefendingArmiesWindow.close();
            Constants.playEffect(Constants.clickButton);


        });

        buttonsHbox.getChildren().addAll(
                backButton, Constants.spaceButton2(), relocateButton);


        hbox.getChildren().add(defendingArmytitle);
        gridPane.add(Constants.spaceButton2(), 0, 0);
        gridPane.add(Constants.spaceButton2(), 2, 0);
        gridPane.add(Constants.spaceButton2(), 4, 0);
        gridPane.add(Constants.spaceButton2(), 6, 0);

        vbox.getChildren().addAll(hbox, gridPane, Constants.spaceButton2(),
                defendingArmytableView, Constants.spaceButton2(), buttonsHbox);
        borderPane.setTop(vbox);


        this.scene = new MyScene(borderPane);
    }

    public MyScene getScene() {
        return scene;
    }
}
