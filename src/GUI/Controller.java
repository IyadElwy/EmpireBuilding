package GUI;

import GUI.BuiltWindow.*;
import buildings.*;
import engine.City;
import engine.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import units.Army;
import units.Unit;

public class Controller {
    public static Game game;
    public static String playerName;
    public static String playerCity;

    public static String inWhatCity;
    public static int farmLevel = 0;
    public static int marketLevel = 0;
    public static int archeryRangeLevel = 0;
    public static int barracksLevel = 0;
    public static int stableLevel = 0;

    public static boolean conquoredCairo;
    public static boolean conquoredRome;
    public static boolean conquoredSparta;

    public static String cityToAttack;

    public static boolean playFirstTime = true;


    public static boolean button2Disabled = false;
    public static boolean button1Disabled = false;

    public static int roundsUntilArrived = -1;

    public static void updateInWhatCity(String city) {
        inWhatCity = city;
    }


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
            playerName = EnterNameWindow.textField.getText();
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
            playerCity = "Cairo";
        } else if (cityName.equals("Rome")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
            playerCity = "Rome";
        } else if (cityName.equals("Sparta")) {
            Main.window.setScene(new MapViewWindow().getMapViewScene());
            Constants.playEffect(Constants.clickButton);
            playerCity = "Sparta";
        }
        try {
            game = new Game(playerName, playerCity);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


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
        long endTime = System.nanoTime();
        long totalTime = endTime - Main.startTime;

        showSettingsStage = new Stage();
        showSettingsStage.initModality(Modality.APPLICATION_MODAL);
        showSettingsStage.setScene(new SettingsWindow(game.getPlayer().getName(),
                Long.toString(totalTime / 1000000000)
        ).getSettingsScene());
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
        City currentCity = null;


        if (choice.equals("City")) {
            Constants.playEffect(Constants.clickButton);
            if (inWhatCity.equalsIgnoreCase("cairo")) {

                for (City city : game.getPlayer().getControlledCities()
                ) {
                    if (city.getName().equalsIgnoreCase("cairo")) {
                        currentCity = city;
                    }
                }

                for (Building building : currentCity.getEconomicalBuildings()
                ) {
                    if (building instanceof Market) {
                        marketLevel = building.getLevel();
                    } else {
                        farmLevel = building.getLevel();
                    }
                }

                for (Building building : currentCity.getMilitaryBuildings()
                ) {
                    if (building instanceof ArcheryRange) {
                        archeryRangeLevel = building.getLevel();
                    } else if (building instanceof Barracks) {
                        barracksLevel = building.getLevel();
                    } else {
                        stableLevel = building.getLevel();
                    }
                }

                Main.window.setScene(new CityViewWindow(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()), Integer.toString(marketLevel),
                        Integer.toString(farmLevel),
                        Integer.toString(archeryRangeLevel),
                        Integer.toString(stableLevel),
                        Integer.toString(barracksLevel)
                ).getCityViewScene());


            } else if (inWhatCity.equalsIgnoreCase("rome")) {

                for (City city : game.getPlayer().getControlledCities()
                ) {
                    if (city.getName().equalsIgnoreCase("rome")) {
                        currentCity = city;
                    }
                }

                for (Building building : currentCity.getEconomicalBuildings()
                ) {
                    if (building instanceof Market) {
                        marketLevel = building.getLevel();
                    } else {
                        farmLevel = building.getLevel();
                    }
                }

                for (Building building : currentCity.getMilitaryBuildings()
                ) {
                    if (building instanceof ArcheryRange) {
                        archeryRangeLevel = building.getLevel();
                    } else if (building instanceof Barracks) {
                        barracksLevel = building.getLevel();
                    } else {
                        stableLevel = building.getLevel();
                    }
                }

                Main.window.setScene(new CityViewWindow(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()), Integer.toString(marketLevel),
                        Integer.toString(farmLevel),
                        Integer.toString(archeryRangeLevel),
                        Integer.toString(stableLevel),
                        Integer.toString(barracksLevel)
                ).getCityViewScene());

            } else if (inWhatCity.equalsIgnoreCase("sparta")) {

                for (City city : game.getPlayer().getControlledCities()
                ) {
                    if (city.getName().equalsIgnoreCase("sparta")) {
                        currentCity = city;
                    }
                }


                for (Building building : currentCity.getEconomicalBuildings()
                ) {
                    if (building instanceof Market) {
                        marketLevel = building.getLevel();
                    } else {
                        farmLevel = building.getLevel();
                    }
                }

                for (Building building : currentCity.getMilitaryBuildings()
                ) {
                    if (building instanceof ArcheryRange) {
                        archeryRangeLevel = building.getLevel();
                    } else if (building instanceof Barracks) {
                        barracksLevel = building.getLevel();
                    } else {
                        stableLevel = building.getLevel();
                    }
                }

                Main.window.setScene(new CityViewWindow(
                        inWhatCity
                        ,
                        Double.toString(game.getPlayer().getTreasury()),
                        Double.toString(game.getPlayer().getFood()),
                        Integer.toString(game.getCurrentTurnCount()), Integer.toString(marketLevel),
                        Integer.toString(farmLevel),
                        Integer.toString(archeryRangeLevel),
                        Integer.toString(stableLevel),
                        Integer.toString(barracksLevel)
                ).getCityViewScene());
            }

        } else {
            Constants.playEffect(Constants.clickButton);

            Army army = getArmyOfCity();
            showArmyWindowStage = new Stage();
            showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
            if (army != null) {
                showArmyWindowStage.setScene(new ShowArmyWindow("City To Attack",
                        army.getCurrentStatus().toString(), army.getTarget(),
                        Integer.toString(army.getDistancetoTarget()), army.getTarget(),
                        getCityBeingAttacked(army.getTarget()).getName()).getShowArmyScene());
            } else {
                showArmyWindowStage.setScene(new ShowArmyWindow("City To Attack",
                        "status", "marching\t", "reached in",
                        "besieging city\t", "turns besieging").getShowArmyScene());
            }
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

    public static ObservableList<Unit> unitsObservableList;

    public static ObservableList<Unit> putShowArmyWindowUnits() {

        unitsObservableList =
                FXCollections.observableArrayList();

        for (Army army : game.getPlayer().getControlledArmies()
        ) {
            for (Unit unit : army.getUnits()) {
                unitsObservableList.add(unit);

            }
        }
        return unitsObservableList;
    }


//    BattleFieldWindow

    public static void mapButtonPressedBattleField() {
//        if battle is going on this button is greyed out
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new MapViewWindow().getMapViewScene());
    }

    public static void updateBattleLog() {
//        BattleFieldWindow.battleLogTextArea.appendText("Battle between " + inWhatCity + " and " + cityToAttack
//                + " may commence!\nMay the most worthy win.");
    }

    //    public static Stage defendingArmyStatusFromBattleField;
    public static void showDefendingArmyStatus() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow(cityToAttack, true, false).getScene());
        showDefendingArmiesWindow.showAndWait();
    }

    public static void chooseUnitToAttack() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow(cityToAttack, true, true).getScene());
        showDefendingArmiesWindow.showAndWait();
    }


    public static void showAttackingArmyStatus() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);

        showArmyWindowStage.setScene(new ShowArmyWindow("City To Attack",
                "status", "marching\t", "reached in",
                "besieging city\t", "turns besieging").getShowArmyScene());

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


    public static void addBuildingToCity() {

    }

    public static void updateBuildingLevel() {

    }

    public static Stage editBuildingwindow;

    public static void buildButtonPressed() {
        Constants.playEffect(Constants.clickButton);

        editBuildingwindow = new Stage();
        editBuildingwindow.initModality(Modality.APPLICATION_MODAL);
        editBuildingwindow.setScene(new EditBuildingWindow(Integer.toString(marketLevel),
                Integer.toString(farmLevel),
                Integer.toString(archeryRangeLevel),
                Integer.toString(stableLevel),
                Integer.toString(barracksLevel)).getEditBuildingScene());
        editBuildingwindow.showAndWait();
    }


    public static void armiesButtonPressed() {
        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
        showArmyWindowStage.setScene(new ShowArmyWindow("", "", "",
                "", "", "").getShowArmyScene());
        showArmyWindowStage.showAndWait();
    }

    public static Stage showDefendingArmiesWindow;

    public static void defendingArmyButtonPressed(String city) {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow = new Stage();
        showDefendingArmiesWindow.initModality(Modality.APPLICATION_MODAL);
        showDefendingArmiesWindow.setScene(new ShowDefendingArmyOfCityWindow(inWhatCity,
                false, false).getScene());
        showDefendingArmiesWindow.showAndWait();
    }

    public static Stage showAttackStrategyWindow;

    public static void attackButtonPressed() {

        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase("Cairo")) {
                conquoredCairo = true;
            }
            if (city.getName().equalsIgnoreCase("Rome")) {
                conquoredRome = true;
            }
            if (city.getName().equalsIgnoreCase("Sparta")) {
                conquoredSparta = true;
            }
        }

        Constants.playEffect(Constants.clickButton);
        showAttackStrategyWindow = new Stage();
        showAttackStrategyWindow.initModality(Modality.APPLICATION_MODAL);
        showAttackStrategyWindow.setScene(new AttackStrategyWindow(conquoredCairo,
                conquoredRome, conquoredSparta, button1Disabled, button2Disabled).getScene());
        showAttackStrategyWindow.showAndWait();
    }

//    EditBuildingWindow

    public static void goBackToCityFromEditBuilding() {
        Constants.playEffect(Constants.clickButton);
        Main.window.setScene(new CityOrArmyWindow().getCityOrArmyWindow());
        editBuildingwindow.close();
    }


    public static void buildButtonPressed(String building) {
        City currentCity = null;
        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase(inWhatCity)) {
                currentCity = city;
            }
        }
        try {
            game.getPlayer().build(building, currentCity.getName());
        } catch (Exception e) {
            new PopUpWindow("Not Enough Gold");
            e.printStackTrace();
        }
        Constants.playEffect(Constants.clickButton);
        goBackToCityFromEditBuilding();
    }

    public static void upgradeButtonPressed(String building) {
        City currentCity = null;
        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase(inWhatCity)) {
                currentCity = city;
            }
        }


        Building buildingToUpgrade = null;
        for (Building buildingTemp : currentCity.getMilitaryBuildings()
        ) {
            if (buildingTemp instanceof ArcheryRange && building.equals("ArcheryRange")) {
                buildingToUpgrade = buildingTemp;
            } else if (buildingTemp instanceof Stable && building.equals("Stable")) {
                buildingToUpgrade = buildingTemp;

            } else if (buildingTemp instanceof Barracks && building.equals(
                    "Barracks")) {
                buildingToUpgrade = buildingTemp;

            } else if (buildingTemp instanceof Market && building.equals("Market")) {
                buildingToUpgrade = buildingTemp;

            } else if (buildingTemp instanceof Farm && building.equals("Farm")) {
                buildingToUpgrade = buildingTemp;

            }
        }

        try {
            game.getPlayer().upgradeBuilding(buildingToUpgrade);
        } catch (Exception e) {
            System.out.println(e);
            new PopUpWindow("Not Enough Gold\nOr Not Built Yet\nOr Building In " +
                    "Cool Down");
        }
        Constants.playEffect(Constants.clickButton);
        goBackToCityFromEditBuilding();
    }

    public static void recruitButtonPressed(String building) {
        City currentCity = null;
        for (City city : game.getPlayer().getControlledCities()
        ) {
            if (city.getName().equalsIgnoreCase(inWhatCity)) {
                currentCity = city;
            }
        }


        String typeToRecruitFrom = "";
        for (Building buildingTemp : currentCity.getMilitaryBuildings()
        ) {
            if (buildingTemp instanceof ArcheryRange && building.equals("ArcheryRange")) {
                typeToRecruitFrom = "archer";
            } else if (buildingTemp instanceof Stable && building.equals("Stable")) {
                typeToRecruitFrom = "cavalry";
            } else if (buildingTemp instanceof Barracks && building.equals(
                    "Barracks")) {
                typeToRecruitFrom = "infantry";
            }
        }

        try {
            game.getPlayer().recruitUnit(typeToRecruitFrom, inWhatCity);
            game.endTurn();
        } catch (Exception ignored) {

        }
        Constants.playEffect(Constants.clickButton);
        goBackToCityFromEditBuilding();


//        City currentCity2 = null;
//        for (City city : game.getPlayer().getControlledCities()
//        ) {
//            if (city.getName().equalsIgnoreCase(inWhatCity)) {
//                currentCity2 = city;
//            }
//        }
//        System.out.println("defend " + currentCity2.getDefendingArmy().getUnits().size());
//
//        System.out.println("control " +
//                game.getPlayer().getControlledArmies().get(0).getUnits().size());


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
    public static void controlledArmyOfCityChosen(String cityBeingAttacked) {

        Army army = getArmyOfCity();

        Constants.playEffect(Constants.clickButton);
        showArmyWindowStage = new Stage();
        showArmyWindowStage.initModality(Modality.APPLICATION_MODAL);
        if (army != null) {
            showArmyWindowStage.setScene(new ShowArmyWindow(cityBeingAttacked,
                    army.getCurrentStatus().toString(), army.getTarget(),
                    Integer.toString(army.getDistancetoTarget()), army.getTarget(),
                    getCityBeingAttacked(army.getTarget()).getName()).getShowArmyScene());
        } else {
            showArmyWindowStage.setScene(new ShowArmyWindow(inWhatCity,
                    "status", "marching\t", "reached in",
                    "besieging city\t", "turns besieging").getShowArmyScene());
        }
        showArmyWindowStage.showAndWait();
    }


    private static City getCityBeingAttacked(String cityBeingAttacked) {
        for (City city : game.getAvailableCities()
        ) {
            if (city.getName().equals(cityBeingAttacked)) {
                return city;
            }
        }
        return null;
    }


    private static Army getArmyOfCity() {
        try {
            return game.getPlayer().getControlledArmies().get(0);
        } catch (Exception e) {
            return null;
        }
    }

//    public static void goBackControlledArmiesWindow() {
//        Constants.playEffect(Constants.clickButton);
//        showControlledArmiesWindow.close();
//    }


//    ShowDefendingArmyOfCityWindow

    public static void showDefendingArmyWindowBackButtonOnAction() {
        Constants.playEffect(Constants.clickButton);
        showDefendingArmiesWindow.close();
    }


    public static ObservableList<Unit> unitsObservableListDefendingArmy;

    public static ObservableList<Unit> putDefendingputdArmyUnits(String city) {
        unitsObservableListDefendingArmy = FXCollections.observableArrayList();

        Army army = null;

        for (City cityTemp : game.getAvailableCities()
        ) {
            if (cityTemp.getName().equalsIgnoreCase(city)) {
                army = cityTemp.getDefendingArmy();
            }
        }

        for (Unit unit : army.getUnits()) {
            unitsObservableListDefendingArmy.add(unit);

        }

        return unitsObservableListDefendingArmy;
    }


    //    RelocateWindow
    public static void updateButtonTextRelocate() {

    }
//
//    public static void relocateUnitButtonPressed() {
//        Constants.playEffect(Constants.clickButton);
//        UnitsHelperClass.relocateStage.close();
//    }


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
