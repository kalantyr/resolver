package resolver.models;

import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Количество элементов массива = сумме предыдущих", description = "В случайном массиве находит количество элеметов, равных сумме всех элементов, расположенных левее")
public class Mas extends MathProblem{
    private static final int minMax = 100;
    public Map<String, String> calculate(Map<String, String> inputData) {
        var l = (int)(getValue(inputData, "l", 0.0));
        var count = 0;
        if (l<=0)
            throw new RuntimeException("l Должно быть больше 0");
        int[] massive = new int[l];
        for (var m=0; m<=l-1; m++) {
            massive[m]=(int)(Math.random()*(minMax*2+1))-minMax;
        }
        count=countCalculate(massive);
        var result = new HashMap<String, String>();
        result.put("c", String.valueOf(count));
        return result;
    }
    public int countCalculate(int[] massive){
        var count=0;
        var s=0;
        var l=massive.length;
        for (var m=0; m<=l-1; m++){
            s=s+massive[m];
            if (m<l-1) {
                if (s == massive[m + 1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
