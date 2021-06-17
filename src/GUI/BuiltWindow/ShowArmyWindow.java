package GUI.BuiltWindow;

import GUI.Constants;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTableView;
import GUI.CustomControllers.MyTextField;
import GUI.HelperClasses.UnitsHelperClass;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyGridPane;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Main;
import GUI.Scenes.MyScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import units.Archer;

import java.io.File;

public class ShowArmyWindow {
    private final MyScene showArmyScene;

    public ShowArmyWindow() {
        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        MyGridPane gridPane = new MyGridPane();
        MyVbox vbox = new MyVbox();
        vbox.setAlignment(Pos.CENTER);

        MyLabel title = new MyLabel("CityName Army");
        title.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 70));
        title.setTextFill(Color.DARKGOLDENROD);

        MyTextField statusTextField = new MyTextField();
        statusTextField.setText("Status: ");
        statusTextField.setEditable(false);
        statusTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        statusTextField.setStyle("-fx-text-inner-color: #6A1412");


        MyTextField marchingToCityTextField = new MyTextField();
        marchingToCityTextField.setText("Marching to 'city'. Target Reached In ..." +
                " Turns");
        marchingToCityTextField.setEditable(false);
        marchingToCityTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        marchingToCityTextField.setStyle("-fx-text-inner-color: #6A1412");
        marchingToCityTextField.setPrefWidth(600);

        MyTextField besiegingCityTextField = new MyTextField();
        besiegingCityTextField.setText("Besieging 'city'. ... Turns Besieging");
        besiegingCityTextField.setEditable(false);
        besiegingCityTextField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 20));
        besiegingCityTextField.setStyle("-fx-text-inner-color: #6A1412");
        besiegingCityTextField.setPrefWidth(550);


        TableColumn<UnitsHelperClass, String> levelColumn = new TableColumn<>(
                "Level");
        TableColumn<UnitsHelperClass, String> maxSoldierColumn = new TableColumn<>(
                "Max Soldiers");
        TableColumn<UnitsHelperClass, String> currentSoldiersColumn = new TableColumn<>(
                "Current Soldiers");
        TableColumn<UnitsHelperClass, RadioButton> radioButtonColumn =
                new TableColumn<>(
                        "Relocate");

        levelColumn.setMinWidth(200);
        maxSoldierColumn.setMinWidth(200);
        currentSoldiersColumn.setMinWidth(200);
        radioButtonColumn.setMinWidth(200);

        levelColumn.setCellValueFactory(new PropertyValueFactory<>(
                "level"));
        levelColumn.setStyle("-fx-alignment: CENTER-LEFT;");
        maxSoldierColumn.setCellValueFactory(new PropertyValueFactory<>(
                "maxSoldierConunt"));
        currentSoldiersColumn.setCellValueFactory(new PropertyValueFactory<>(
                "currentSoldierCount"));
        radioButtonColumn.setCellValueFactory(new PropertyValueFactory<>("radioButton"));


        MyTableView tableView = new MyTableView();
        tableView.setEditable(false);
        tableView.setItems(putUnits());
        tableView.getColumns().addAll(levelColumn, maxSoldierColumn,
                currentSoldiersColumn,
                radioButtonColumn);


        MyHbox buttonsHbox = new MyHbox();
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(0, 0, 160, 0));

        MyButton continueGameButton = new MyButton("Relocate");
        continueGameButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        continueGameButton.setTextFill(Color.DARKGOLDENROD);
        continueGameButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
        });

        MyButton spaceButton = new MyButton("SP");
        spaceButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        spaceButton.setTextFill(Color.DARKGOLDENROD);
        spaceButton.setOpacity(0);

        MyButton exitGameButton = new MyButton("Back");
        exitGameButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        exitGameButton.setTextFill(Color.DARKGOLDENROD);
        exitGameButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new MapViewWindow().getMapViewScene());
        });

        buttonsHbox.getChildren().addAll(continueGameButton, spaceButton,
                exitGameButton);


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

    public ObservableList<UnitsHelperClass> putUnits() {
        ObservableList<UnitsHelperClass> unitsObservableList = FXCollections.observableArrayList();
        unitsObservableList.add(new UnitsHelperClass(new Archer(2, 2, 3.3, 2.3, 3)));
        return unitsObservableList;
    }

    public MyScene getShowArmyScene() {
        return showArmyScene;
    }
}
