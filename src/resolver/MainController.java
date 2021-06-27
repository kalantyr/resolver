package resolver;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class MainController {
//    @FXML
//    private javafx.scene.control.MenuItem miClose;

    private Scene scene;
    public void setScene(Scene scene) { this.scene = scene; }

    @FXML
    public void onExit(Event e) {
        scene.getWindow().hide();
    }
}
