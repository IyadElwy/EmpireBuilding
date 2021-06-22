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
import GUI.Main;
import GUI.Scenes.MyScene;
import engine.City;
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
import units.*;

import java.io.File;
import java.util.Random;

public class ShowDefendingArmyOfCityWindow {

    private final MyScene scene;

    public static MyTableView defendingArmytableView;
    public static MyLabel defendingArmytitle;
    public static MyButton backButton;
    public static MyButton relocateButton;
    public static MyButton chooseToAttackButton;

    public ShowDefendingArmyOfCityWindow(String city, boolean ofAttack,
                                         boolean chooseToAttack) {
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


        typeColumn.setCellValueFactory(new PropertyValueFactory<>(
                "type"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>(
                "level"));
        maxSoldierColumn.setCellValueFactory(new PropertyValueFactory<>(
                "maxSoldierCount"));
        currentSoldiersColumn.setCellValueFactory(new PropertyValueFactory<>(
                "currentSoldierCount"));


        defendingArmytableView = new MyTableView();
        defendingArmytableView.setEditable(false);
        if (ofAttack) {
            defendingArmytableView.setItems(Controller.putDefendingputdArmyUnits(Controller.cityToAttack));
        } else {
            defendingArmytableView.setItems(Controller.putDefendingputdArmyUnits(Controller.inWhatCity));
        }
        defendingArmytableView.getColumns().addAll(typeColumn, levelColumn, maxSoldierColumn,
                currentSoldiersColumn
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

        chooseToAttackButton = new MyButton("Choose To Attack");
        chooseToAttackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        chooseToAttackButton.setTextFill(Color.DARKGOLDENROD);
        chooseToAttackButton.setOnAction(event -> {

            BattleFieldWindow.mapButton.setDisable(true);


            if (AttackWithWindow.currentAttackingUnit instanceof Archer) {
                double factor = 0;
                if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Archer) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.3;
                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.4;
                    } else {
                        factor = 0.5;
                    }
                } else if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Infantry) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.2;
                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.3;
                    } else {
                        factor = 0.4;
                    }
                } else if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Cavalry) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1 ||
                            ((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.1;
                    } else {
                        factor = 0.2;
                    }
                }

                City city1 = null;
                for (City cityTemp : Controller.game.getAvailableCities()
                ) {
                    if (cityTemp.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        city1 = cityTemp;
                    }
                }


                city1.getDefendingArmy().getUnits().remove(((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()));

            } else if (AttackWithWindow.currentAttackingUnit instanceof Cavalry) {
                double factor = 0;

                if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Archer) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.5;
                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.6;
                    } else {
                        factor = 0.7;
                    }
                } else if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Infantry) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.3;
                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.4;
                    } else {
                        factor = 0.5;
                    }
                } else if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Cavalry) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1 ||
                            ((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.2;
                    } else {
                        factor = 0.3;
                    }
                }


                City city1 = null;
                for (City cityTemp : Controller.game.getAvailableCities()
                ) {
                    if (cityTemp.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        city1 = cityTemp;
                    }
                }

                city1.getDefendingArmy().getUnits().remove(((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()));

            } else if (AttackWithWindow.currentAttackingUnit instanceof Infantry) {
                double factor = 0;
                if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Archer) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.3;

                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.4;
                    } else {
                        factor = 0.5;
                    }
                } else if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Infantry) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.1;

                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.2;
                    } else {
                        factor = 0.3;
                    }
                } else if (defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Cavalry) {
                    if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 2) {
                        factor = 0.1;
                    } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()).getLevel() == 1) {
                        factor = 0.2;
                    } else {
                        factor = 0.25;
                    }
                }


                City city1 = null;
                for (City cityTemp : Controller.game.getAvailableCities()
                ) {
                    if (cityTemp.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                        city1 = cityTemp;
                    }
                }

                if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()) instanceof Archer) {
                    BattleFieldWindow.battleLogTextArea.appendText("Your Opponent " +
                            "lost an Archer Unit");
                } else if (((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()) instanceof Cavalry) {
                    BattleFieldWindow.battleLogTextArea.appendText("Your Opponent " +
                            "lost a Cavalry Unit");
                } else {
                    BattleFieldWindow.battleLogTextArea.appendText("Your Opponent " +
                            "lost an Infantry Unit");
                }

                city1.getDefendingArmy().getUnits().remove(((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()));

            }


//            Oponents turn:

            BattleFieldWindow.battleLogTextArea.appendText("\n\nYour Opponent Will" +
                    " " +
                    "Strike Now....\n\n");


            Random rand = new Random();
            int upperBound =
                    rand.nextInt(Controller.game.getPlayer().getControlledArmies().get(0).getUnits().size());

            if (Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(upperBound) instanceof Archer) {
                BattleFieldWindow.battleLogTextArea.appendText("You lost " +
                        "lost an Archer Unit");
            } else if (Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(upperBound) instanceof Cavalry) {
                BattleFieldWindow.battleLogTextArea.appendText("You lost " +
                        "lost a Cavalry Unit");
            } else {
                BattleFieldWindow.battleLogTextArea.appendText("You lost " +
                        "lost an Infantry Unit");
            }

            Controller.game.getPlayer().getControlledArmies().get(0).getUnits().remove(
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(upperBound)
            );

            Controller.game.endTurn();
            Controller.showDefendingArmiesWindow.close();


//            Checking if battle lost or won
            City city1 = null;
            for (City cityTemp : Controller.game.getAvailableCities()
            ) {
                if (cityTemp.getName().equalsIgnoreCase(Controller.cityToAttack)) {
                    city1 = cityTemp;
                }
            }

            if (city1.getDefendingArmy().getUnits().isEmpty()) {
                BattleFieldWindow.mapButton.setDisable(false);
                new PopUpWindow("You Won This Battle");
                if (MapViewWindow.cairoButton.getText().equalsIgnoreCase(city1.getName())) {
                    Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "cairo");
                    MapViewWindow.cairoButton.setDisable(false);
                } else if (MapViewWindow.romeButton.getText().equalsIgnoreCase(city1.getName())) {
                    Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "rome");
                    MapViewWindow.romeButton.setDisable(false);
                } else if (MapViewWindow.spartaButton.getText().equalsIgnoreCase(city1.getName())) {
                    Controller.game.occupy(Controller.game.getPlayer().getControlledArmies().get(0), "sparta");
                    MapViewWindow.spartaButton.setDisable(false);
                }
                Controller.game.getPlayer().getControlledCities().add(city1);
                Main.window.setScene(new MapViewWindow().getMapViewScene());

                if (Controller.game.isGameOver()) {
                    Main.window.setScene(new GameOverWindow("Won").getGameOverScene());
                }
            }

            if (Controller.game.getPlayer().getControlledArmies().get(0).getUnits().isEmpty()) {
                BattleFieldWindow.mapButton.setDisable(false);
                new PopUpWindow("You Lost This Battle");
                Main.window.setScene(new MapViewWindow().getMapViewScene());

            }

        });

        relocateButton = new

                MyButton("Relocate");
        relocateButton.setFont(Font.loadFont(new

                File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").

                toURI().

                toString(), 50));
        relocateButton.setTextFill(Color.DARKGOLDENROD);
        relocateButton.setOnAction(event ->

        {

//            Controller.game.endTurn();

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

        buttonsHbox.getChildren().

                addAll(
                        backButton, Constants.spaceButton2(),
                        !ofAttack ? relocateButton : Constants.spaceButton3(),
                        chooseToAttack ? chooseToAttackButton : Constants.spaceButton3());


        hbox.getChildren().

                add(defendingArmytitle);
        gridPane.add(Constants.spaceButton2(), 0, 0);
        gridPane.add(Constants.spaceButton2(), 2, 0);
        gridPane.add(Constants.spaceButton2(), 4, 0);
        gridPane.add(Constants.spaceButton2(), 6, 0);

        vbox.getChildren().

                addAll(hbox, gridPane, Constants.spaceButton2(),

                        defendingArmytableView, Constants.spaceButton2(), buttonsHbox);
        borderPane.setTop(vbox);


        this.scene = new

                MyScene(borderPane);

    }

    public MyScene getScene() {
        return scene;
    }
}
