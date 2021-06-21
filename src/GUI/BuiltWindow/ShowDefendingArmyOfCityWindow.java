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
import engine.City;
import exceptions.FriendlyFireException;
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
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Unit;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

        chooseToAttackButton = new MyButton("Choose To Attack");
        chooseToAttackButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        chooseToAttackButton.setTextFill(Color.DARKGOLDENROD);
        chooseToAttackButton.setOnAction(event -> {


            if ((Unit) ShowDefendingArmyOfCityWindow.
                    defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Archer) {
                Constants.playEffect(Constants.archerSound);
            } else if ((Unit) ShowDefendingArmyOfCityWindow.
                    defendingArmytableView.getSelectionModel().getSelectedItem() instanceof Cavalry) {
                Constants.playEffect(Constants.horseSound);
            } else {
                Constants.playEffect(Constants.infantrySound);
            }

            try {
                BattleFieldWindow.mapButton.setDisable(false);
                BattleFieldWindow.battleLogTextArea.appendText("\n" +
                        AttackWithWindow.currentAttackingUnit + " attacked " + (Unit) ShowDefendingArmyOfCityWindow.
                        defendingArmytableView.getSelectionModel().getSelectedItem() + "\n" +
                        "Current Soldier Count of " + ShowDefendingArmyOfCityWindow.
                        defendingArmytableView.getSelectionModel().getSelectedItem() + " is \n" + ((Unit) ShowDefendingArmyOfCityWindow.
                        defendingArmytableView.getSelectionModel().getSelectedItem()).getCurrentSoldierCount() + "\n");


                try {
                    AttackWithWindow.currentAttackingUnit.attack(((Unit) defendingArmytableView.getSelectionModel().getSelectedItem()));
                } catch (FriendlyFireException e) {
                    e.printStackTrace();
                }



                for (Unit unit :
                        Controller.game.getPlayer().getControlledArmies().get(0).getUnits()
                ) {
                    if (unit == AttackWithWindow.currentAttackingUnit) {
                        for (City cityTemp : Controller.game.getAvailableCities()
                        ) {
                            for (Unit unitToAttack : cityTemp.getDefendingArmy().getUnits()
                            ) {
                                if (unitToAttack == defendingArmytableView.getSelectionModel().getSelectedItem()) {
                                    unit.attack(unitToAttack);
                                    if (unit instanceof Archer) {
                                        BattleFieldWindow.currentAttacker.setImage(Constants.archeryRight);
                                    } else if (unit instanceof Cavalry) {
                                        BattleFieldWindow.currentAttacker.setImage(Constants.cavalryRight);
                                    } else {
                                        BattleFieldWindow.currentAttacker.setImage(Constants.infantryRight);
                                    }


                                }
                            }
                        }
                    }
                }


                Controller.showDefendingArmiesWindow.close();
                Controller.game.endTurn();
                if (ShowDefendingArmyOfCityWindow.defendingArmytableView.getItems().isEmpty()) {
                    Controller.game.occupy(AttackWithWindow.currentAttackingUnit.getParentArmy(),
                            Controller.cityToAttack);
                    BattleFieldWindow.mapButton.setDisable(false);
                }
            } catch (Exception e) {
//                new PopUpWindow(e.toString());
                e.printStackTrace();
            }

            Controller.game.endTurn();
            Controller.attackWithWindow.close();

            BattleFieldWindow.battleLogTextArea.appendText("\n\nWaiting For " +
                    "Defending Army To Finish Attack\n\n");
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Random rand = new Random();
            int int_random =
                    rand.nextInt(Controller.game.getPlayer().getControlledArmies().get(0).getUnits().size());
            int int_random2 =
                    rand.nextInt(defendingArmytableView.getSelectionModel().getSelectedItems().size());

            try {
                ((Unit) defendingArmytableView.getItems().get(int_random2)).attack(((Unit) ShowArmyWindow.tableView.getItems().get(int_random)));
            } catch (FriendlyFireException e) {
                e.printStackTrace();
            }
            for (City cityTemp : Controller.game.getAvailableCities()
            ) {
                for (Unit unitToAttack : cityTemp.getDefendingArmy().getUnits()
                ) {
                    if (unitToAttack == defendingArmytableView.getSelectionModel().getSelectedItems().get(int_random2)) {
                        try {
                            unitToAttack.attack(Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(int_random));
                            if (unitToAttack instanceof Archer) {
                                BattleFieldWindow.currentAttacker.setImage(Constants.archeryLeft);
                            } else if (unitToAttack instanceof Cavalry) {
                                BattleFieldWindow.currentAttacker.setImage(Constants.archeryLeft);
                            } else {
                                BattleFieldWindow.currentAttacker.setImage(Constants.archeryLeft);
                            }
                        } catch (FriendlyFireException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


            BattleFieldWindow.battleLogTextArea.appendText("\n" +
                    defendingArmytableView.getSelectionModel().getSelectedItems().get(int_random2) + " attacked " +
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(int_random) + "\n" +
                    "Current Soldier Count of " + Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(int_random) + " is \n" +
                    Controller.game.getPlayer().getControlledArmies().get(0).getUnits().get(int_random).getCurrentSoldierCount() + "\n");

            Controller.game.endTurn();


        });

        relocateButton = new MyButton("Relocate");
        relocateButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        relocateButton.setTextFill(Color.DARKGOLDENROD);
        relocateButton.setOnAction(event -> {

            Controller.game.endTurn();

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
                backButton, Constants.spaceButton2(),
                !ofAttack ? relocateButton : Constants.spaceButton3(),
                chooseToAttack ? chooseToAttackButton : Constants.spaceButton3());


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
