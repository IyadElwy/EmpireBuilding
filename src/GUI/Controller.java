package GUI;

import GUI.BuiltWindow.*;
import GUI.HelperClasses.UnitsHelperClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import units.Archer;
import units.Cavalry;
import units.Infantry;

public class Controller {

    //    WelcomeWindow
    public static void welcomeWindowStartGameButtonAction() {
        WelcomeWindow.startGameButton.setOnAction(event -> {
            //        The enter your name window
            EnterNameWindow enterNameWindow = new EnterNameWindow();
            Main.window.setScene(enterNameWindow.getWelcomeScene());
            Constants.playEffect(Constants.clickButton);
        });
    }

    //    EnterNameWindow
    public static void enterNameWindowReadyButtonOnAction() {
        EnterNameWindow.readyButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
            GameDescriptionWindow gameDescriptionWindow =
                    new GameDescriptionWindow();
            Main.window.setScene(gameDescriptionWindow.getGameDescriptionScene());
        });
    }

    //    GameDescriptionWindow
    public static void gameDescriptionWindowProceedButtonOnAction() {
        GameDescriptionWindow.readyButton.setOnAction(event -> {
            Constants.playEffect(Constants.clickButton);
            ChooseCityWindow chooseCityWindow = new ChooseCityWindow();
            Main.window.setScene(chooseCityWindow.getChooseCityScene());
        });
    }

    //    ChooseCityWindow
    public static void chooseCityWindowButtonOnAction(String cityName) {
        if (cityName.equals("Cairo")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
        } else if (cityName.equals("Rome")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
        } else if (cityName.equals("Sparta")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
        }
    }


    //    MapViewWindow
    public static void enterCityMapButtonOnAction(String cityName) {
        if (cityName.equals("Cairo")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());
        } else if (cityName.equals("Rome")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());
        } else if (cityName.equals("Sparta")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());
        }
    }


    //  SettingsWindow
    public static void settingsButtonOnAction(String choice) {
        if (choice.equals("Back")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new MapViewWindow().getMapViewScene());
        } else {
            Constants.playEffect(Constants.clickButton);
            System.exit(0);
        }
    }


    //    CityOrArmyWindow
    public static void chooseCityOrArmy(String choice) {
        if (choice.equals("City")) {
            Constants.playEffect(Constants.clickButton);

        } else {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new ShowArmyWindow().getShowArmyScene());
        }
    }


    //    ShowArmyWindow
    public static void updateTitleLabel() {

    }

    public static void updateStatusTextField() {

    }

    public static void updateMarchingToCityTextField() {

    }

    public static void updateBesiegingCityTextField() {

    }

    public static void showArmyWindowRelocateButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
    }

    public static void showArmyWindowBackButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new MapViewWindow().getMapViewScene());
    }

    public static ObservableList<UnitsHelperClass> putUnits() {
        ObservableList<UnitsHelperClass> unitsObservableList = FXCollections.observableArrayList();
        unitsObservableList.add(new UnitsHelperClass(new Archer(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Cavalry(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Archer(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Infantry(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Infantry(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Archer(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Cavalry(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Archer(2, 2, 3.3, 2.3, 3)));
        unitsObservableList.add(new UnitsHelperClass(new Cavalry(2, 2, 3.3, 2.3, 3)));
        return unitsObservableList;
    }


//    BattleFieldWindow

    public static void mapButtonPressedBattleField() {
//        if battle is going on this button is greyed out
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new MapViewWindow().getMapViewScene());
    }

    public static void updateBattleLog() {

    }

    public static void showDefendingArmyStatus() {

    }

    public static void showAttackingArmyStatus() {

    }

    public static void chooseNextAttack() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(new AttackWithWindow().getAttackWithScene());
        window.showAndWait();
    }



//    AttackWith Window

}
