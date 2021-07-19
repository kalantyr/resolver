package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Diff;
import resolver.models.Pow;

import java.util.HashMap;
import java.util.stream.Stream;

public class Pow_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double a, Double s, Double c){
        var inputData = new HashMap<String,String>();
        if (a!=null)
            inputData.put("a", String.valueOf(a.doubleValue()));
        if (s!=null)
            inputData.put("s", String.valueOf(s.doubleValue()));

        var map = new HashMap<String,String>();
        if (c!=null)
            map.put("c", String.valueOf(c.doubleValue()));

        var pow = new Pow();
        var k = pow.calculate(inputData);
        Assertions.assertEquals(map, k);
    }
    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(2.0, 2.0, 4.0),
                Arguments.of(null, 2.0, 0.0),
                Arguments.of(15.0, null, 1.0),
                Arguments.of(10.0, 3.0, 1000.0),
                Arguments.of(12.0, 3.5, 5985.96759095804)
        );
    }
}
