package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Число сочетаний из n по k", description = "Вычисляет число сочетаний")
public class Comb extends MathProblem{
    @Override
    public Map<String, String> calculate(Map<String, String> inputData) {
        var k = (getValue(inputData, "k", 0.0));
        var n = (getValue(inputData, "n", 0.0));
        if (k>n){
            throw new RuntimeException("K не может быть больше n");
        }
        var fk=1d;
        var fn=1d;
        var fr=1d;
        for (var f=1; f<=k; f++){
            fk = fk*f;
        }
        for (var i=1; i<=n; i++){
            fn = fn*i;
        }
        for (var j=1; j<=n-k; j++){
            fr = fr*j;
        }
        var c = fn/(fk*fr);
        var result = new HashMap<String, String>();
        result.put("c", String.valueOf(c));
        return result;
    }
}
