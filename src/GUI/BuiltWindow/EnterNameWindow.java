package GUI.BuiltWindow;

import GUI.Constants;
import GUI.CustomControllers.MyButton;
import GUI.CustomControllers.MyLabel;
import GUI.CustomControllers.MyTextField;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.File;

public class EnterNameWindow {

    private final MyScene enterNameScene;

    public EnterNameWindow() {



        //        Setting the background image for the welcome page
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/GUI/Resources/background_welcome.png")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        MyBorderPane enterNameSceneLayout = new MyBorderPane();
        enterNameSceneLayout.setBackground(new Background(backgroundImage));


//        Creating and setting hbox for title
        //        setting the label properties
        MyLabel enterNameLabel = new MyLabel("Please Enter Your Name:");
        enterNameLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 70));
        enterNameLabel.setTextFill(Color.DARKGOLDENROD);
        MyHbox enterNameTitleHbox = new MyHbox();
        enterNameTitleHbox.getChildren().add(enterNameLabel);
        enterNameTitleHbox.setPadding(new Insets(160, 0, 200, 600));


//        Creating Hbox for textfield and textfield
        MyHbox enterNameFieldHbox = new MyHbox();
        MyTextField textField = new MyTextField();
        textField.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 40));
        textField.setStyle("-fx-text-inner-color: #6A1412");
        textField.setOpacity(0.8);
        textField.setAlignment(Pos.BASELINE_CENTER);
        enterNameFieldHbox.setPadding(new Insets(0, 0, 0, 670));
        enterNameFieldHbox.getChildren().add(textField);


//        Setting button properties and hbox for button
        MyHbox readyButtonHbox = new MyHbox();
        readyButtonHbox.setPadding(new Insets(0, 0, 100, 850));
        MyButton readyButton = new MyButton("Ready");
        readyButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        readyButton.setTextFill(Color.DARKGOLDENROD);
        readyButton.setShape(new Circle(1.5));
        readyButton.setMinSize(200, 200);
        readyButton.setOpacity(0.9);
        readyButtonHbox.getChildren().add(readyButton);

        enterNameSceneLayout.setTop(enterNameTitleHbox);
        enterNameSceneLayout.setCenter(enterNameFieldHbox);
        enterNameSceneLayout.setBottom(readyButtonHbox);

        this.enterNameScene = new MyScene(enterNameSceneLayout);
    }

    public MyScene getWelcomeScene() {
        return enterNameScene;
    }
}
