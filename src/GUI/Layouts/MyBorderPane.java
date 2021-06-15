package GUI.Layouts;

import javafx.scene.layout.BorderPane;

public class MyBorderPane extends BorderPane {
    private BorderPane borderPane;

    public MyBorderPane() {
        this.borderPane = new BorderPane();
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }
}
