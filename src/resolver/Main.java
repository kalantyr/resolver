package resolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import resolver.controllers.MainController;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("fxml/MainWindow.fxml")));
        var root = (Parent)loader.load();

        primaryStage.setTitle("resolver");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        var controller = loader.<MainController>getController();
        controller.setScene(primaryStage.getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showError(Exception exc) {
//        var alert = new Alert(Alert.AlertType.ERROR, String.join(", ", exc.getMessage()));
        var alert = new Alert(Alert.AlertType.ERROR, exc.getMessage());
        alert.showAndWait();
    }
}
