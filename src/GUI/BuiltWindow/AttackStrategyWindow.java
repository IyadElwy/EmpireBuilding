package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class AttackStrategyWindow {

    private final MyScene scene;

    public AttackStrategyWindow(boolean conquoredCairo, boolean conquoredRome,
                                boolean conquoredSparta) {

        String[] cities = new String[2];
        cities[0] = "conquered";
        cities[1] = "conquered";
        for (int i = 0; i < cities.length; i++) {
            if (conquoredCairo == false) {
                cities[i] = "Cairo";
                conquoredCairo = true;
            } else if (conquoredRome == false) {
                cities[i] = "Rome";
                conquoredRome = true;
            } else if (conquoredSparta == false) {
                cities[i] = "Sparta";
                conquoredSparta = true;
            }
        }


        MyVbox vbox = new MyVbox();
        MyHbox hbox = new MyHbox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setPadding(new Insets(0, 0, 100, 0));
        hbox.setAlignment(Pos.CENTER);
        MyVbox vbox2 = new MyVbox();
        vbox2.setAlignment(Pos.CENTER);
        MyVbox vbox3 = new MyVbox();
        vbox3.setAlignment(Pos.CENTER);


        MyLabel chooseArmyLabel = new MyLabel("Attack: ");
        chooseArmyLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 130));
        chooseArmyLabel.setTextFill(Color.DARKGOLDENROD);

        MyButton city1Button = new MyButton(cities[0]);
        city1Button.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        city1Button.setTextFill(Color.DARKGOLDENROD);
        city1Button.setOnAction(event -> {
            Controller.cityToAttack = cities[0];
            Controller.cityToAttackButtonPressed();
        });

        MyButton city2Button = new MyButton(cities[1]);
        city2Button.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        city2Button.setTextFill(Color.DARKGOLDENROD);
        city2Button.setOnAction(event -> {
            Controller.cityToAttack = cities[1];
            Controller.cityToAttackButtonPressed();
        });

        MyButton autoResolveBtn1 = new MyButton("Auto-Resolve");
        autoResolveBtn1.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        autoResolveBtn1.setTextFill(Color.DARKGOLDENROD);
        autoResolveBtn1.setOnAction(event -> {
            Controller.autoresolveButtonPressed();
        });

        MyButton autoResolveBtn2 = new MyButton("Auto-Resolve");
        autoResolveBtn2.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        autoResolveBtn2.setTextFill(Color.DARKGOLDENROD);
        autoResolveBtn2.setOnAction(event -> {
            Controller.autoresolveButtonPressed();
        });


        vbox2.getChildren().addAll(city1Button, Constants.spaceButton(),
                autoResolveBtn1);
        vbox3.getChildren().addAll(city2Button, Constants.spaceButton(), autoResolveBtn2);
        vbox.getChildren().addAll(chooseArmyLabel, Constants.spaceButton2(), hbox);
        hbox.getChildren().addAll(vbox2, Constants.spaceButton(),
                vbox3);

        this.scene = new MyScene(vbox);
    }

    public MyScene getScene() {
        return scene;
    }
}
