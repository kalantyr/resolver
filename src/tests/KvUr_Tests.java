package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.KvUr;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.stream.Stream;

public class KvUr_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double a, Double b, Double c, Double x1, Double x2){
        var kvur = new KvUr();

        var inputData = new HashMap<String,Object>();
        if (a!=null)
            inputData.put("a",a);
        if (b!=null)
            inputData.put("b",b);
        if (c!=null)
            inputData.put("c",c);
        var k = kvur.calculate(inputData);

        var map = new HashMap<String,Object>();
        if (x1!=null)
            map.put("x1",x1);
        if (x2!=null)
            map.put("x2",x2);
        Assertions.assertEquals(map, k);
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(1.0, -5.0, 4.0, 4.0, 1.0),
                Arguments.of(1.0, -3.0, 2.0, 2.0, 1.0),
                Arguments.of(1.0, 2.0, 1.0, -1.0, -1.0),
                Arguments.of(10.0, 1.0, 10.0, null, null),
                Arguments.of(10.0, 10.0, 0.0, 0.0, -1.0),
                Arguments.of(5.0,null,null,0.0,0.0)
        );
    }
}
