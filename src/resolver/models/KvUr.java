package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Квадратное уравнение", description = "Расчитывает корни квадратного уравнения")
public class KvUr extends MathProblem {
    @Override
    public Map<String,Object> calculate(Map<String,Object> inputData) {
        var result = new HashMap<String,Object>();

        var a = inputData.get("a");
        if (a==null)
            a=0.0;
        var a1=(double)a;

        var b = inputData.get("b");
        if (b==null)
            b=0.0;
        var b1=(double)b;

        var c = inputData.get("c");
        if (c==null)
            c=0.0;
        var c1=(double)c;

        var d = b1*b1-4*a1*c1;
        var k=0;
        if (d==0)
            k=1;
        if (d>0)
            k=2;

        if (k>0) {
            var x1 = (-b1 + Math.sqrt(d)) / (2 * a1);
            result.put("x1",x1);
            result.put("x2",x1);
        }
        if (k==2){
            var x2 = (-b1 - Math.sqrt(d)) / (2 * a1);
            result.replace("x2",x2);
        }
        return result;
    }
}
