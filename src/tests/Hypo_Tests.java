package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Hypo;
import resolver.models.Perc;

import java.util.HashMap;
import java.util.stream.Stream;

public class Hypo_Tests {
    @ParameterizedTest
    @MethodSource("testData")
    public void calculate_test(Double a, Double b, Double h){
        var inputData = new HashMap<String,String>();
        if (a!=null)
            inputData.put("a", String.valueOf(a.doubleValue()));
        if (b!=null)
            inputData.put("b", String.valueOf(b.doubleValue()));

        var map = new HashMap<String,String>();
        if (h!=null)
            map.put("h", String.valueOf(h.doubleValue()));

        var hypo = new Hypo();
        var k = hypo.calculate(inputData);
        Assertions.assertEquals(map, k);
    }

    @ParameterizedTest
    @MethodSource("negativeData")
    public void negative_test(Double a, Double b, String error) {
        var inputData = new HashMap<String,String>();
        if (a!=null)
            inputData.put("a", String.valueOf(a.doubleValue()));
        if (b!=null)
            inputData.put("b", String.valueOf(b.doubleValue()));
        var e = Assertions.assertThrows(RuntimeException.class,()->{
            var hypo = new Hypo();
            var k = hypo.calculate(inputData);
        });
        Assertions.assertEquals(error, e.getMessage());
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(3.0, 4.0, 5.0),
                Arguments.of(18.0, 24.0, 30.0),
                Arguments.of(10.0, 10.0, 14.142135623730951)
        );
    }

    private static Stream<Arguments> negativeData(){
        return Stream.of(
                Arguments.of(10.0, 0.0, "Параметр b должен быть больше 0"),
                Arguments.of(null, 30.0, "Введите параметр a"),
                Arguments.of(29.4, null, "Введите параметр b"),
                Arguments.of(-120.0, 40.0, "Параметр a должен быть больше 0")
        );
    }
}
