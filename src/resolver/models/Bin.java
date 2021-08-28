package resolver.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Двоичный вид числа", description = "Преобразует число из десятичной системы в двоичную")
public class Bin extends MathProblem{
    public Map<String, String> calculate(Map<String, String> inputData) {
        ArrayList<Integer> Numbers = new ArrayList<>();
        int bin = 0;
        var d = (int)(getValue(inputData, "d", 0.0));
        if (d<0)
            throw new RuntimeException("d не может быть меньше 0");
        if (d>1023)
            throw new RuntimeException("Слишком большое число");
        while (d>=1){
            Numbers.add(d%2);
            d=d/2;
        }
        for (var n=Numbers.size(); n>0; n--){
            bin=(int)(bin+Numbers.get(n-1)*(Math.pow(10,n-1)));
        }
        var result = new HashMap<String, String>();
        result.put("b", String.valueOf(bin));
        return result;
    }
}
