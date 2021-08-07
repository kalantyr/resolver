package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import resolver.models.Pri;

import java.util.HashMap;

public class Pri_Tests {
    @Test
    public void calculate_test1(){
        var n = 6;
        var inputData = new HashMap<String,String>();
        inputData.put("n",String.valueOf(n));
        var map = new HashMap<String, String>();
        map.put("p1", String.valueOf(2));
        map.put("p2", String.valueOf(3));
        var pri = new Pri();
        var result = pri.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test2(){
        var n = 10;
        var inputData = new HashMap<String,String>();
        inputData.put("n",String.valueOf(n));
        var map = new HashMap<String, String>();
        map.put("p1", String.valueOf(2));
        map.put("p2", String.valueOf(5));
        var pri = new Pri();
        var result = pri.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test3(){
        var n = 13;
        var inputData = new HashMap<String,String>();
        inputData.put("n",String.valueOf(n));
        var map = new HashMap<String, String>();
        map.put("a", String.valueOf(0));
        var pri = new Pri();
        var result = pri.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test4(){
        var n = 1890;
        var inputData = new HashMap<String,String>();
        inputData.put("n",String.valueOf(n));
        var map = new HashMap<String, String>();
        map.put("p1", String.valueOf(2));
        map.put("p2", String.valueOf(3));
        map.put("p3", String.valueOf(3));
        map.put("p4", String.valueOf(3));
        map.put("p5", String.valueOf(5));
        map.put("p6", String.valueOf(7));
        var pri = new Pri();
        var result = pri.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test5(){
        var n = 1953125;
        var inputData = new HashMap<String,String>();
        inputData.put("n",String.valueOf(n));
        var map = new HashMap<String, String>();
        map.put("p1", String.valueOf(5));
        map.put("p2", String.valueOf(5));
        map.put("p3", String.valueOf(5));
        map.put("p4", String.valueOf(5));
        map.put("p5", String.valueOf(5));
        map.put("p6", String.valueOf(5));
        map.put("p7", String.valueOf(5));
        map.put("p8", String.valueOf(5));
        map.put("p9", String.valueOf(5));
        var pri = new Pri();
        var result = pri.calculate(inputData);
        Assertions.assertEquals(map, result);
    }
}
