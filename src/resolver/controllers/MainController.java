package resolver.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {
//    @FXML
//    private javafx.scene.control.MenuItem miClose;

    private Scene scene;
    public void setScene(Scene scene) { this.scene = scene; }

    @FXML
    public void onExit(Event e) {
        scene.getWindow().hide();
    }

    @FXML
    public void onAbout(Event e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/AboutWindow.fxml")));
        var stage = new Stage();
        stage.initOwner(scene.getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("About");
        stage.setScene(new Scene(root, 250, 200));
        stage.showAndWait();
    }
}
