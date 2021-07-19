package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Сумма двух чисел", description = "Складывает два числа")
public class Sum extends MathProblem {
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var result = new HashMap<String,String>();
        var a = getValue(inputData,"a",0.0);
        var b = getValue(inputData,"b",0.0);

        var s = a+b;
        result.put("s",String.valueOf(s));
        return result;
    }
}
