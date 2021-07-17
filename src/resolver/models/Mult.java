package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Произведение двух чисел", description = "Перемножает два числа")
public class Mult extends MathProblem {
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var result = new HashMap<String,String>();

        var a = getValue(inputData,"a",1.0);
        var b = getValue(inputData,"b",1.0);

        var p = a*b;
        result.put("p",String.valueOf(p));

        return result;
    }
}
