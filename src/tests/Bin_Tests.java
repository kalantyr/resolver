package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Bin;

import java.util.HashMap;
import java.util.stream.Stream;

public class Bin_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double d, Double b){
        var inputData = new HashMap<String,String>();
        if (d!=null)
            inputData.put("d", String.valueOf(d.doubleValue()));
        var map = new HashMap<String,String>();
        if (b!=null)
            map.put("b", String.valueOf(b.doubleValue()));
        var bin =  new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(100, 1100100),
                Arguments.of(5, 101),
                Arguments.of(124, 1111100),
                Arguments.of(39, 100111),
                Arguments.of(506, 111111010)
        );
    }
}
