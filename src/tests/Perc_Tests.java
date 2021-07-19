package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.models.Mult;
import resolver.models.Perc;

import java.util.HashMap;
import java.util.stream.Stream;

public class Perc_Tests {
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

        var perc = new Perc();
        var k = perc.calculate(inputData);
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
            var perc = new Perc();
            var k = perc.calculate(inputData);
        });
        Assertions.assertEquals(error, e.getMessage());
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(10.0, 100.0, 10.0),
                Arguments.of(15.0, 30.0, 50.0),
                Arguments.of(29.4, 29.4, 100.0),
                Arguments.of(-7.2, -3.6, 200.0)
        );
    }

    private static Stream<Arguments> negativeData(){
        return Stream.of(
                Arguments.of(10.0, 0.0, "Параметр b не может быть 0"),
                Arguments.of(null, 30.0, "Введите параметр a"),
                Arguments.of(29.4, null, "Введите параметр b")
        );
    }
}
