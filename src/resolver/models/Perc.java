package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Проценты", description = "Расчитывает отношение одного числа к другому в процентах")
public class Perc extends MathProblem{
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var a = getValueOrThrow(inputData,"a","Введите параметр a");
        var b = getValueOrThrow(inputData,"b","Введите параметр b");
        if (b==0)
           throw new RuntimeException("Параметр b не может быть 0");
        var p = a/b*100;
        var result = new HashMap<String,String>();
        result.put("p",String.valueOf(p));
        return result;
    }
}
