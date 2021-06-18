package GUI.HelperClasses;

import GUI.CustomControllers.MyButton;
import javafx.scene.control.RadioButton;
import units.Archer;
import units.Cavalry;
import units.Unit;

public class UnitsHelperClass {
    private MyButton attackButton;
    private MyButton relocateButton;
    private int level;
    private int maxSoldierConunt;
    private int currentSoldierCount;
    private String type;

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

        });

        attackButton.setOnAction(e -> {

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
