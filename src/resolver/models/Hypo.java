package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Гипотенуза", description = "Рассчитывает гипотенузу прямоугольного треугольника")
public class Hypo extends MathProblem{
    @Override
    public Map<String,String> calculate(Map<String,String> inputData) {
        var a = getValueOrThrow(inputData,"a","Введите параметр a");
        var b = getValueOrThrow(inputData,"b","Введите параметр b");
        if (a<=0)
            throw new RuntimeException("Параметр a должен быть больше 0");
        if (b<=0)
            throw new RuntimeException("Параметр b должен быть больше 0");
        var h = Math.sqrt(a*a+b*b);
        var result = new HashMap<String,String>();
        result.put("h",String.valueOf(h));
        return result;
    }
}
