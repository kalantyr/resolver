package resolver.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import resolver.Main;
import resolver.models.MathProblem;
import resolver.models.MathProblemInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MathProblemController {
    @FXML
    private javafx.scene.control.TextArea inputText;
    @FXML
    private javafx.scene.control.TextArea resultText;

    private MathProblem mathProblem;

    public void init(Stage stage, Class<MathProblem> cl) {
        var an = cl.getAnnotation(MathProblemInfo.class);
        stage.setTitle(an.name());

        try
        {
            mathProblem = cl.newInstance();
        }
        catch (Exception e) {
            Main.showError(e);
        }
    }

    public static Map<String,String> parse(String text){
        var lines = text.split("\n");
        var result = new HashMap<String,String>();
        for (var line:lines) {
            var parts = line.split("=");
            result.put(parts[0], parts[1]);
        }
        return result;
    }

    public static String toString(Map<String,String> data){
        var list = new ArrayList<String>();
        for (var key:data.keySet()) {
            list.add(key+" = "+data.get(key));
        }
        return String.join("\n",list);
    }

    @FXML
    public void onCalculate(Event e) {
        try
        {
            var inputData = parse(inputText.getText());
            var result = mathProblem.calculate(inputData);
            resultText.setText(toString(result));
        }
        catch (Exception error) {
            Main.showError(error);
        }
    }
}
