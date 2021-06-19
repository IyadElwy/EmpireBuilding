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


    public static Stage showSettingsStage;
    public static void settingsButtonPressed() {
        showSettingsStage = new Stage();
        showSettingsStage.initModality(Modality.APPLICATION_MODAL);
        showSettingsStage.setScene(new SettingsWindow().getSettingsScene());
        showSettingsStage.showAndWait();
    }


    //  SettingsWindow
    public static void settingsButtonOnAction(String choice) {
        if (choice.equals("Back")) {
            Constants.playEffect(Constants.clickButton);
            showSettingsStage.close();
        } else {
            Constants.playEffect(Constants.clickButton);
            System.exit(0);
        }
    }


    //    CityOrArmyWindow
    public static Stage showArmyWindowStage;
    public static void chooseCityOrArmy(String choice) {
        if (choice.equals("City")) {
            Constants.playEffect(Constants.clickButton);
            Main.window.setScene(new CityViewWindow().getCityViewScene());

        } else {
            Constants.playEffect(Constants.clickButton);
            showArmyWindowStage = new Stage();
            showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
            showArmyWindowStage.setScene(new ShowArmyWindow().getShowArmyScene());
            showArmyWindowStage.showAndWait();
        }
    }


    //    ShowArmyWindow
    public static void updateShowArmyWindowTitleLabel() {

    }

    public static void updateShowArmyWindowStatusTextField() {

    }

    public static void updateShowArmyWindowMarchingToCityTextField() {

    }

    public static void updateShowArmyWindowBesiegingCityTextField() {

    }

    public static void showArmyWindowRelocateButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
    }


    public static void showArmyWindowBackButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage.close();
    }

    public static ObservableList<UnitsHelperClass> putShowArmyWindowUnits() {
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

//    public static Stage defendingArmyStatusFromBattleField;
    public static void showDefendingArmyStatus() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow().getScene());
        showDefendingArmiesWindow.showAndWait();
    }

    public static void showAttackingArmyStatus() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
        showArmyWindowStage.setScene(new ShowArmyWindow().getShowArmyScene());
        showArmyWindowStage.showAndWait();
    }

    public static Stage attackWithWindow;
    public static void chooseNextAttack() {
        Constants.playEffect(Constants.clickButton);
        attackWithWindow = new Stage();
        attackWithWindow.initModality(Modality.APPLICATION_MODAL);
        attackWithWindow.setScene(new AttackWithWindow().getAttackWithScene());
        attackWithWindow.showAndWait();
    }


    //    AttackWith Window
    public static void goBackFromAttackWithWindow() {
        Constants.playEffect(Constants.clickButton);
        attackWithWindow.close();
    }


    //    CityViewWindow
    public static void openMapFromCityView() {
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new MapViewWindow().getMapViewScene());
    }

    public static void updateCityName() {

    }

    public static void updatePlayerGoldAmount() {

    }

    public static void updatePlayerFoodAmount() {

    }

    public static void addBuildingToCity() {

    }

    public static void updateBuildingLevel() {

    }

    public static Stage editBuildingwindow;
    public static void buildButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        editBuildingwindow = new Stage();
        editBuildingwindow.initModality(Modality.APPLICATION_MODAL);
        editBuildingwindow.setScene(new EditBuildingWindow().getEditBuildingScene());
        editBuildingwindow.showAndWait();
    }

    public static Stage showControlledArmiesWindow;
    public static void armiesButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showControlledArmiesWindow = new Stage();
        showControlledArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showControlledArmiesWindow.setScene(new ShowControlledArmiesWindow().getScene());
        showControlledArmiesWindow.showAndWait();
    }

    public static Stage showDefendingArmiesWindow;
    public static void defendingArmyButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow().getScene());
        showDefendingArmiesWindow.showAndWait();
    }

    public static Stage showAttackStrategyWindow;
    public static void attackButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showAttackStrategyWindow = new Stage();
        showAttackStrategyWindow.initModality(Modality.APPLICATION_MODAL);
        showAttackStrategyWindow.setScene(new AttackStrategyWindow().getScene());
        showAttackStrategyWindow.showAndWait();
    }

//    EditBuildingWindow

    public static void goBackToCityFromEditBuilding() {
        Constants.playEffect(Constants.clickButton);
        editBuildingwindow.close();
    }

    public static String getValueChoiceBox() {
        return EditBuildingWindow.buildingChoiceBox.getValue();
    }

    public static void upgradeBuildingButtonPressed() {
        Constants.playEffect(Constants.clickButton);
    }

    public static void harvestButtonPressed() {
        Constants.playEffect(Constants.clickButton);
    }

    public static void recruitButtonPressed() {
        Constants.playEffect(Constants.clickButton);
    }

    public static void updateBuildingLevelLabel() {

    }


    //    GameOverWindow
    public static void upDateGameEndResult() {

    }


    //    ShowControlledArmiesWindow
    public static void controlledArmyOfCityChosen(String city) {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
        showArmyWindowStage.setScene(new ShowArmyWindow().getShowArmyScene());
        showArmyWindowStage.showAndWait();
    }

    public static void goBackControlledArmiesWindow() {
        Constants.playEffect(Constants.clickButton);
        showControlledArmiesWindow.close();
    }


//    ShowDefendingArmyOfCityWindow

    public static void showDefendingArmyWindowBackButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow.close();
    }

    public static ObservableList<UnitsHelperClass> putDefendingArmyUnits() {
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


    //    RelocateWindow
    public static void updateButtonTextRelocate() {

    }

    public static void relocateUnitButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        UnitsHelperClass.relocateStage.close();
    }


    //    AttackStrategyWindow
    public static void cityToAttackButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showAttackStrategyWindow.close();
        Main.window.setScene(new BattleFieldWindow().getScene());
    }

    public static void autoresolveButtonPressed() {
        Constants.playEffect(Constants.clickButton);
    }


}
