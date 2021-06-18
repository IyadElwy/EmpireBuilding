package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTableView;
import GUI.CustomControllers.MyTextField;
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

public class ShowArmyWindow {
    private final MyScene showArmyScene;
    public static MyTableView tableView;
    public static MyLabel title;
    public static MyTextField statusTextField;
    public static MyTextField marchingToCityTextField;
    public static MyTextField besiegingCityTextField;
    public static MyButton relocateButton;
    public static MyButton backButton;

    public ShowArmyWindow() {
        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        MyGridPane gridPane = new MyGridPane();
        MyVbox vbox = new MyVbox();
        vbox.setAlignment(Pos.CENTER);

        title = new MyLabel("CityName Army");
        title.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 70));
        title.setTextFill(Color.DARKGOLDENROD);

        statusTextField = new MyTextField();
        statusTextField.setText("Status: ");
        statusTextField.setEditable(false);
        statusTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        statusTextField.setStyle("-fx-text-inner-color: #6A1412");


        marchingToCityTextField = new MyTextField();
        marchingToCityTextField.setText("Marching to 'city'. Target Reached In ..." +
                " Turns");
        marchingToCityTextField.setEditable(false);
        marchingToCityTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        marchingToCityTextField.setStyle("-fx-text-inner-color: #6A1412");
        marchingToCityTextField.setPrefWidth(600);

        besiegingCityTextField = new MyTextField();
        besiegingCityTextField.setText("Besieging 'city'. ... Turns Besieging");
        besiegingCityTextField.setEditable(false);
        besiegingCityTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        besiegingCityTextField.setStyle("-fx-text-inner-color: #6A1412");
        besiegingCityTextField.setPrefWidth(550);

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
                        "Relocate");

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
                "relocateButton"));

        tableView = new MyTableView();
//        tableView.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD,
//                new CornerRadii(60,false), new Insets(300,300,300,300))));
        tableView.setEditable(false);
        tableView.setItems(Controller.putUnits());
        tableView.getColumns().addAll(typeColumn, levelColumn, maxSoldierColumn,
                currentSoldiersColumn,
                radioButtonColumn);


        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 160, 0));

        relocateButton = new MyButton("Relocate");
        relocateButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        relocateButton.setTextFill(Color.DARKGOLDENROD);
        relocateButton.setOnAction(event -> {
            Controller.showArmyWindowRelocateButtonOnAction();
        });

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
            Controller.showArmyWindowBackButtonOnAction();
        });

        buttonsHbox.getChildren().addAll(
                backButton);


        hbox.getChildren().add(title);
        gridPane.add(Constants.spaceButton2(), 0, 0);
        gridPane.add(statusTextField, 1, 0);
        gridPane.add(Constants.spaceButton2(), 2, 0);
        gridPane.add(marchingToCityTextField, 3, 0);
        gridPane.add(Constants.spaceButton2(), 4, 0);
        gridPane.add(besiegingCityTextField, 5, 0);
        gridPane.add(Constants.spaceButton2(), 6, 0);
        vbox.getChildren().addAll(hbox, gridPane, Constants.spaceButton2(),
                tableView, Constants.spaceButton2(), buttonsHbox);
        borderPane.setTop(vbox);


        this.showArmyScene = new MyScene(borderPane);
    }


    public MyScene getShowArmyScene() {
        return showArmyScene;
    }
}