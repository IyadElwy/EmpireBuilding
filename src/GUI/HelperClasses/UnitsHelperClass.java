package GUI.HelperClasses;

import GUI.BuiltWindow.PopUpWindow;
import GUI.BuiltWindow.ShowDefendingArmyOfCityWindow;
import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import exceptions.MaxCapacityException;
import javafx.stage.Stage;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Unit;

public class UnitsHelperClass {
    private MyButton attackButton;
    private MyButton relocateButton;
    private int level;
    private int maxSoldierConunt;
    private int currentSoldierCount;
    private String type;

    public static Stage relocateStage;

    public UnitsHelperClass(Unit unit) {
        this.level = unit.getLevel();
        this.maxSoldierConunt = unit.getMaxSoldierCount();
        this.currentSoldierCount = unit.getCurrentSoldierCount();
        this.relocateButton = new MyButton("Relocate");
        this.attackButton = new MyButton("Choose");
        if (unit instanceof Archer) {
            type = "Archer";
        } else if (unit instanceof Cavalry) {
            type = "Cavalry";
        } else {
            type = "Infantry";
        }

        relocateButton.setOnAction(e -> {

            UnitsHelperClass selectedItem = (UnitsHelperClass) ShowDefendingArmyOfCityWindow.
                    defendingArmytableView.getSelectionModel().getSelectedItem();
            ShowDefendingArmyOfCityWindow.defendingArmytableView.getItems().remove(selectedItem);
//            City cityOfDefendingArmy = null;
//            for (City city: Controller.game.getPlayer().getControlledCities()
//                 ) {
//                if (city.getName().equalsIgnoreCase(Controller.inWhatCity)) {
//                    cityOfDefendingArmy = city;
//                }
//            }
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
//            Controller.unitsObservableListDefendingArmy.remove(unit);
//            Controller.showDefendingArmiesWindow.close();

        });

        attackButton.setOnAction(e -> {
            Constants.playEffect(Constants.clickButton);
            Controller.attackWithWindow.close();
        });
    }


    public MyButton getAttackButton() {
        return attackButton;
    }

    public MyButton getRelocateButton() {
        return relocateButton;
    }


    public int getLevel() {
        return level;
    }

    public int getMaxSoldierConunt() {
        return maxSoldierConunt;
    }

    public int getCurrentSoldierCount() {
        return currentSoldierCount;
    }

    public String getType() {
        return type;
    }
}
