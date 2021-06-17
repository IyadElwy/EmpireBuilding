module EmpireBuilding {
    requires javafx.media;
    requires java.xml;
    requires javafx.controls;
    exports GUI.HelperClasses;
    opens GUI.HelperClasses to javafx.graphics;
    opens GUI;
}