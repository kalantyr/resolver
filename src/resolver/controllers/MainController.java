package resolver.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import resolver.Main;
import resolver.models.MathProblem;
import resolver.models.MathProblemInfo;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    private javafx.scene.control.Menu miProblems;

    private Scene scene;
    public void setScene(Scene scene) {
        this.scene = scene;

        var classes = MathProblem.searchAllClasses();
        for (var cl : classes) {
            var an = cl.getAnnotation(MathProblemInfo.class);
            var menuItem = new MenuItem();
            menuItem.setText(an.name() + "...");
            menuItem.setUserData(cl);
            menuItem.setOnAction(actionEvent -> {
                try {
                    var mi = (MenuItem)actionEvent.getSource();
                    var c = (Class<MathProblem>)mi.getUserData();
                    showMathProblem(c);
                } catch (Exception e) {
                    Main.showError(e);
                }
            });
            miProblems.getItems().add(menuItem);
        }
    }

    private void showMathProblem(Class<MathProblem> cl) throws IOException {
        var loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../fxml/MathProblemWindow.fxml")));
        var root = (Parent)loader.load();

        var stage = new Stage();
        stage.initOwner(scene.getWindow());
        stage.setScene(new Scene(root, 480, 360));
        stage.show();

        var controller = loader.<MathProblemController>getController();
        controller.init(stage, cl);
    }

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
