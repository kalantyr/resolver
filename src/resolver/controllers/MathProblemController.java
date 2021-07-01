package resolver.controllers;

import javafx.stage.Stage;
import resolver.Main;
import resolver.models.MathProblem;
import resolver.models.MathProblemInfo;

public class MathProblemController {
    private MathProblem mathProblem;

    public void init(Stage stage, Class<MathProblem> cl) {
        var an = cl.getAnnotation(MathProblemInfo.class);
        stage.setTitle(an.name());

        try
        {
            mathProblem = cl.newInstance();
            mathProblem.equals(null);
        }
        catch (Exception e) {
            Main.showError(e);
        }
    }
}
