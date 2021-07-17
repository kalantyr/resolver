package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Sum;

import java.util.HashMap;
import java.util.stream.Stream;

public class Sum_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double a, Double b, Double s){
        var inputData = new HashMap<String,String>();
        if (a!=null)
            inputData.put("a", String.valueOf(a.doubleValue()));
        if (b!=null)
            inputData.put("b", String.valueOf(b.doubleValue()));

        var map = new HashMap<String,String>();
        if (s!=null)
            map.put("s", String.valueOf(s.doubleValue()));

        var sum = new Sum();
        var k = sum.calculate(inputData);
        Assertions.assertEquals(map, k);
    }
    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(5.0, 5.0, 10.0),
                Arguments.of(null, 2.0, 2.0),
                Arguments.of(8.9, null, 8.9),
                Arguments.of(3.14, 255.0, 258.14),
                Arguments.of(-7.2, 5.0, -2.2)
        );
    }
}
