package GUI.BuiltWindow;

import GUI.Scenes.MyScene;

public class CityViewWindow {
    private final MyScene cityViewScene;

    public CityViewWindow() {


        this.cityViewScene = new MyScene();
    }

    public MyScene getCityViewScene() {
        return cityViewScene;
    }
}
