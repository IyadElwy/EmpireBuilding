package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTableView;
import GUI.HelperClasses.UnitsHelperClass;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyGridPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class AttackWithWindow {
    public static MyLabel title;

    private final MyScene attackWithScene;

    public AttackWithWindow() {
        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        MyGridPane gridPane = new MyGridPane();
        MyVbox vbox = new MyVbox();
        vbox.setAlignment(Pos.CENTER);

        title = new MyLabel("Choose Attacking Unit");
        title.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 70));
        title.setTextFill(Color.DARKGOLDENROD);


        TableColumn<UnitsHelperClass, String> typeColumn = new TableColumn<>(
                "Type");
        TableColumn<UnitsHelperClass, String> levelColumn = new TableColumn<>(
                "Level");
        TableColumn<UnitsHelperClass, String> maxSoldierColumn = new TableColumn<>(
                "Max Soldiers");
        TableColumn<UnitsHelperClass, String> currentSoldiersColumn = new TableColumn<>(
                "Current Soldiers");
        TableColumn<UnitsHelperClass, RadioButton> radioButtonColumn =
                new TableColumn<>(
                        "Attacking Unit");

        typeColumn.setMinWidth(390);
        typeColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        levelColumn.setMinWidth(390);
        levelColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        maxSoldierColumn.setMinWidth(390);
        maxSoldierColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        currentSoldiersColumn.setMinWidth(390);
        currentSoldiersColumn.setStyle("-fx-padding: 0.5em;\n" +
                "    -fx-border-color: transparent -fx-box-border transparent transparent;\n" +
                "    -fx-font: 13px \"Arial\";\n" +
                "    -fx-text-fill: red;");
        radioButtonColumn.setMinWidth(390);


        typeColumn.setCellValueFactory(new PropertyValueFactory<>(
                "type"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>(
                "level"));
        maxSoldierColumn.setCellValueFactory(new PropertyValueFactory<>(
                "maxSoldierConunt"));
        currentSoldiersColumn.setCellValueFactory(new PropertyValueFactory<>(
                "currentSoldierCount"));
        radioButtonColumn.setCellValueFactory(new PropertyValueFactory<>(
                "attackButton"));

        ShowArmyWindow.tableView = new MyTableView();
        ShowArmyWindow.tableView.setEditable(false);
        ShowArmyWindow.tableView.setItems(Controller.putUnits());
        ShowArmyWindow.tableView.getColumns().addAll(typeColumn, levelColumn, maxSoldierColumn,
                currentSoldiersColumn,
                radioButtonColumn);


        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 160, 0));




        hbox.getChildren().add(title);
        gridPane.add(Constants.spaceButton2(), 0, 0);
        gridPane.add(Constants.spaceButton2(), 2, 0);
        gridPane.add(Constants.spaceButton2(), 4, 0);
        gridPane.add(Constants.spaceButton2(), 6, 0);
        vbox.getChildren().addAll(hbox, gridPane, Constants.spaceButton2(),
                ShowArmyWindow.tableView, Constants.spaceButton2(), buttonsHbox);
        borderPane.setTop(vbox);


        this.attackWithScene = new MyScene(borderPane);
    }

    public MyScene getAttackWithScene() {
        return attackWithScene;
    }
}