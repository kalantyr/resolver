package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Comb;
import resolver.models.Diff;

import java.util.HashMap;
import java.util.stream.Stream;

public class Comb_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double n, Double k, Double c){
        var inputData = new HashMap<String,String>();
        if (n!=null)
            inputData.put("n", String.valueOf(n.doubleValue()));
        if (k!=null)
            inputData.put("k", String.valueOf(k.doubleValue()));

        var map = new HashMap<String,String>();
        if (c!=null)
            map.put("c", String.valueOf(c.doubleValue()));

        var comb = new Comb();
        var g = comb.calculate(inputData);
        Assertions.assertEquals(map, g);
    }
    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(5.0, 3.0, 10.0),
                Arguments.of(15.0, 6.0, 5005.0),
                Arguments.of(20.0, 8.0, 125970.0),
                Arguments.of(0.0, 0.0, 1.0),
                Arguments.of(12.0, 11.0, 12.0)
        );
    }
}
