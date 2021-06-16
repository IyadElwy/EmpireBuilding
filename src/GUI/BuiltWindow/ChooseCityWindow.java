package GUI.BuiltWindow;

import GUI.Constants;
import GUI.CustomControllers.MyButton;
import GUI.Layouts.MyHbox;
import GUI.Layouts.MyVbox;
import GUI.Main;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;

import java.io.File;

public class ChooseCityWindow {

    private final MyScene chooseCityScene;

    public ChooseCityWindow() {

        double buttonWidth =
                Constants.GAME_WINDOW_SIZE_X - Constants.GAME_WINDOW_SIZE_X * 0.8799;

//        Setting up the layouts and properties
        MyHbox allCitiesHbox = new MyHbox();
        BackgroundSize vboxBackgroundSize = new BackgroundSize(Constants.GAME_WINDOW_SIZE_X,
                Constants.GAME_WINDOW_SIZE_Y, false,
                false, false, true);


        MyVbox cairoVbox = new MyVbox();
        BackgroundImage backgroundImageCairo = new BackgroundImage(new Image(new File(
                "src/GUI/Resources/cairo_pyramids.jpg")
                .toURI().toString()), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, vboxBackgroundSize);
        cairoVbox.setBackground(new Background(backgroundImageCairo));
        MyButton cairoButton = new MyButton("Cairo");
        cairoButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        cairoButton.setPadding(new Insets(0,
                buttonWidth
                , 0,
                buttonWidth));
        cairoButton.setTextFill(Color.WHITE);
        cairoButton.setOnMouseEntered(e -> {
            cairoButton.setTextFill(Color.RED);
            cairoButton.setEffect(new InnerShadow());
        });
        cairoButton.setOnMouseExited(e -> {
            cairoButton.setTextFill(Color.WHITE);
            cairoButton.setEffect(new InnerShadow(0, Color.WHITE));
        });
        cairoButton.setOnAction(e -> {

        });

        cairoButton.setFont(Font.loadFont(new File("src/GUI/Resources" +
                "/BerkshireSwash-Regular.ttf").toURI().toString(), 70));
        cairoVbox.getChildren().add(cairoButton);
        cairoVbox.setAlignment(Pos.CENTER);


        MyVbox romeVbox = new MyVbox();
        BackgroundImage backgroundImageRome = new BackgroundImage(new Image(new File(
                "src/GUI/Resources/roman_empire.jpg")
                .toURI().toString()), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, vboxBackgroundSize);
        romeVbox.setBackground(new Background(backgroundImageRome));
        MyButton romeButton = new MyButton("Rome");
        romeButton.setTextFill(Color.WHITE);
        romeButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        romeButton.setPadding(new Insets(0,
                buttonWidth
                , 0,
                buttonWidth));
        romeButton.setFont(Font.loadFont(new File("src/GUI/Resources" +
                "/BerkshireSwash-Regular.ttf").toURI().toString(), 70));
        romeButton.setOnMouseEntered(e -> {
            romeButton.setTextFill(Color.RED);
            romeButton.setEffect(new InnerShadow());
        });
        romeButton.setOnMouseExited(e -> {
            romeButton.setTextFill(Color.WHITE);
            romeButton.setEffect(new InnerShadow(0, Color.WHITE));
        });
        romeVbox.getChildren().add(romeButton);
        romeVbox.setAlignment(Pos.CENTER);


        MyVbox spartaVbox = new MyVbox();
        BackgroundImage backgroundImageSparta =
                new BackgroundImage(new Image(new File(
                        "src/GUI/Resources/sparta.jpg")
                        .toURI().toString()), BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, vboxBackgroundSize);
        spartaVbox.setBackground(new Background(backgroundImageSparta));
        MyButton spartaButton = new MyButton("Sparta");
        spartaButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        spartaButton.setTextFill(Color.WHITE);
        spartaButton.setPadding(new Insets(0, buttonWidth
                , 0,
                buttonWidth));
        spartaButton.setFont(Font.loadFont(new File("src/GUI/Resources" +
                "/BerkshireSwash-Regular.ttf").toURI().toString(), 70));
        spartaButton.setOnMouseEntered(e -> {
            spartaButton.setTextFill(Color.RED);
            spartaButton.setEffect(new InnerShadow());
        });
        spartaButton.setOnMouseExited(e -> {
            spartaButton.setTextFill(Color.WHITE);
            spartaButton.setEffect(new InnerShadow(0, Color.WHITE));
        });
        spartaVbox.getChildren().add(spartaButton);
        spartaVbox.setAlignment(Pos.CENTER);


        allCitiesHbox.getChildren().addAll(cairoVbox, romeVbox, spartaVbox);


        this.chooseCityScene = new MyScene(allCitiesHbox);
    }

    public MyScene getChooseCityScene() {
        return chooseCityScene;
    }
}
