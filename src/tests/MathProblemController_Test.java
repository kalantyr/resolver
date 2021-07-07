package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import resolver.controllers.MathProblemController;

import java.util.HashMap;
import java.util.stream.Stream;

public class MathProblemController_Test {
    @ParameterizedTest
    @MethodSource("testData")
    public void parseTest(String text, String keyName, String expectedValue){
        var data = MathProblemController.parse(text);
        Assertions.assertEquals(expectedValue,data.get(keyName));
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of("a=-3.5", "a", "-3.5"),
                Arguments.of("b=100", "b", "100"),
                Arguments.of("f=да", "f", "да"),
                Arguments.of("f=да\na=1\nb=-7.7", "f", "да"),
                Arguments.of("f=да\na=1\nb=-7.7", "a", "1"),
                Arguments.of("f=да\na=1\nb=-7.7", "b", "-7.7")
        );
    }

    @Test
    public void toStringTest(){
        var data = new HashMap<String,String>();
        data.put("x1","10");
        data.put("x2","5");
        var v =MathProblemController.toString(data);
        Assertions.assertEquals("x1 = 10\nx2 = 5",v);
    }
}
