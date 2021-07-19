package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Разность двух чисел", description = "Вычитает из одного числа другое")
public class Diff extends MathProblem{
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var a = getValue(inputData,"a",0.0);
        var b = getValue(inputData,"b",0.0);
        var r = a-b;
        var result = new HashMap<String,String>();
        result.put("r",String.valueOf(r));
        return result;
    }
}
