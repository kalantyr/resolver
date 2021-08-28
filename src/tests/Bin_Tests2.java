package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import resolver.models.Bin;

import java.util.HashMap;

public class Bin_Tests2 {
    @Test
    public void calculate_test1(){
        var d = 100;
        var inputData = new HashMap<String,String>();
        inputData.put("d",String.valueOf(d));
        var map = new HashMap<String, String>();
        map.put("b", String.valueOf(1100100));
        var bin = new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test2(){
        var d = 5;
        var inputData = new HashMap<String,String>();
        inputData.put("d",String.valueOf(d));
        var map = new HashMap<String, String>();
        map.put("b", String.valueOf(101));
        var bin = new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test3(){
        var d = 124;
        var inputData = new HashMap<String,String>();
        inputData.put("d",String.valueOf(d));
        var map = new HashMap<String, String>();
        map.put("b", String.valueOf(1111100));
        var bin = new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test4(){
        var d = 39;
        var inputData = new HashMap<String,String>();
        inputData.put("d",String.valueOf(d));
        var map = new HashMap<String, String>();
        map.put("b", String.valueOf(100111));
        var bin = new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test5(){
        var d = 506;
        var inputData = new HashMap<String,String>();
        inputData.put("d",String.valueOf(d));
        var map = new HashMap<String, String>();
        map.put("b", String.valueOf(111111010));
        var bin = new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test6(){
        var d = 1;
        var inputData = new HashMap<String,String>();
        inputData.put("d",String.valueOf(d));
        var map = new HashMap<String, String>();
        map.put("b", String.valueOf(1));
        var bin = new Bin();
        var result = bin.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
}
