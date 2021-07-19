package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Mult;
import resolver.models.Sum;

import java.util.HashMap;
import java.util.stream.Stream;

public class Mult_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double a, Double b, Double p){
        var inputData = new HashMap<String,String>();
        if (a!=null)
            inputData.put("a", String.valueOf(a.doubleValue()));
        if (b!=null)
            inputData.put("b", String.valueOf(b.doubleValue()));

        var map = new HashMap<String,String>();
        if (p!=null)
            map.put("p", String.valueOf(p.doubleValue()));

        var mult = new Mult();
        var k = mult.calculate(inputData);
        Assertions.assertEquals(map, k);
    }
    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(5.0, 5.0, 25.0),
                Arguments.of(null, 10.0, 10.0),
                Arguments.of(11.11, null, 11.11),
                Arguments.of(3.14, 2.0, 6.28),
                Arguments.of(-7.2, 0.0, -0.0),
                Arguments.of(-7.2, 1.0, -7.2)
        );
    }
}
