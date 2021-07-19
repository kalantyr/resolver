package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Diff;
import resolver.models.Sum;

import java.util.HashMap;
import java.util.stream.Stream;

public class Diff_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double a, Double b, Double r){
        var inputData = new HashMap<String,String>();
        if (a!=null)
            inputData.put("a", String.valueOf(a.doubleValue()));
        if (b!=null)
            inputData.put("b", String.valueOf(b.doubleValue()));

        var map = new HashMap<String,String>();
        if (r!=null)
            map.put("r", String.valueOf(r.doubleValue()));

        var diff = new Diff();
        var k = diff.calculate(inputData);
        Assertions.assertEquals(map, k);
    }
    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(5.0, 2.0, 3.0),
                Arguments.of(null, 2.0, -2.0),
                Arguments.of(80.5, null, 80.5),
                Arguments.of(100.0, 2123.35464, -2023.35464),
                Arguments.of(7.5, -5.0, 12.5)
        );
    }
}
