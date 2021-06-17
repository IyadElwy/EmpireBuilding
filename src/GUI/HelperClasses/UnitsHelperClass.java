package GUI.HelperClasses;

import javafx.scene.control.RadioButton;
import units.Archer;
import units.Cavalry;
import units.Unit;

public class UnitsHelperClass {
    private RadioButton radioButton;
    private int level;
    private int maxSoldierConunt;
    private int currentSoldierCount;
    private String type;

    public UnitsHelperClass(Unit unit) {
        this.level = unit.getLevel();
        this.maxSoldierConunt = unit.getMaxSoldierCount();
        this.currentSoldierCount = unit.getCurrentSoldierCount();
        this.radioButton = new RadioButton();
        if (unit instanceof Archer) {
            type = "Archer";
        } else if (unit instanceof Cavalry) {
            type = "Cavalry";
        } else {
            type = "Infantry";
        }
    }

    public RadioButton getRadioButton() {
        return radioButton;
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
