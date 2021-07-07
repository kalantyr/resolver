package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Квадратное уравнение", description = "Расчитывает корни квадратного уравнения")
public class KvUr extends MathProblem {
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var result = new HashMap<String,String>();

        var a = getValue(inputData,"a",0.0);
        var b = getValue(inputData,"b",0.0);
        var c = getValue(inputData,"c",0.0);

        var d = b*b-4*a*c;
        var k=0;
        if (d==0)
            k=1;
        if (d>0)
            k=2;

        if (k>0) {
            var x1 = (-b + Math.sqrt(d)) / (2 * a);
            result.put("x1",String.valueOf(x1));
            result.put("x2",String.valueOf(x1));
        }
        if (k==2){
            var x2 = (-b - Math.sqrt(d)) / (2 * a);
            result.replace("x2",String.valueOf(x2));
        }
        return result;
    }
}
