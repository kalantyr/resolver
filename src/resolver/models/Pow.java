package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Степень", description = "Возводит число в степень")
public class Pow extends MathProblem{
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var a = getValue(inputData,"a",0.0);
        var s = getValue(inputData,"s",0.0);
        var c = Math.pow(a,s);
        var result = new HashMap<String,String>();
        result.put("c",String.valueOf(c));
        return result;
    }
}
