package resolver.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@MathProblemInfo(name = "Разложение на простые множители", description = "Находит все простые числа, произведение которых равно данному числу")
public class Pri extends MathProblem {

    public static final int maxMultCount = 25;

    public ArrayList<Integer> primeNumbers(int max) {
        var np = 0;
        var primes = new ArrayList<Integer>();
        primes.add(1);
        primes.add(2);
        for (var n = 3; n <= max/2; n++) {
            for (var k = 2; k < primes.size(); k++) {
                if (n % primes.get(k) == 0) {
                    np=1;
                    break;
                }
            }
            if (np==0) {
                primes.add(n);
            }
            np=0;
        }
        return primes;
    }

    @Override
    public Map<String, String> calculate(Map<String, String> inputData) {
        var n = (int)(getValue(inputData, "n", 0.0));
        var result = new HashMap<String, String>();
        var count = 1;
        var pNumbers = primeNumbers(n);
        if (n <= 1) {
            result.put("a", "0");
            return result;
        }
        for (var t = 1; t <= pNumbers.size() - 1; t++) {
            for (var k = 1; k <= maxMultCount; k++) {
                if (n % pNumbers.get(t) != 0)
                    break;
                if (n % pNumbers.get(t) == 0) {
                    result.put("p" + count, String.valueOf(pNumbers.get(t)));
                    n = n / pNumbers.get(t);
                    count++;
                }
            }
        }
        if (result.size() <= 1) {
            result.clear();
            result.put("a", "0");
        }
            return result;
    }
}