package tests;

import org.junit.jupiter.api.Test;
import resolver.models.KvUr;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class KvUr_Tests {
    @Test
    public void Kvur_calculate_test_1(){
        var kvur = new KvUr();

        var inputData = new HashMap<String,Object>();
        inputData.put("a",1);
        inputData.put("b",-5);
        inputData.put("c",4);
        var k = kvur.calculate(inputData);

        var map = new HashMap<String,Object>();
        map.put("x1",4.0);
        map.put("x2",1.0);
        Assertions.assertEquals(map, k);
    }
    @Test
    public void Kvur_calculate_test_2(){
        var kvur = new KvUr();

        var inputData = new HashMap<String,Object>();
        inputData.put("a",1);
        inputData.put("b",-3);
        inputData.put("c",2);
        var k = kvur.calculate(inputData);

        var map = new HashMap<String,Object>();
        map.put("x1",2.0);
        map.put("x2",1.0);
        Assertions.assertEquals(map, k);
    }
    @Test
    public void Kvur_calculate_test_3(){
        var kvur = new KvUr();

        var inputData = new HashMap<String,Object>();
        inputData.put("a",1);
        inputData.put("b",2);
        inputData.put("c",1);
        var k = kvur.calculate(inputData);

        var map = new HashMap<String,Object>();
        map.put("x1",-1.0);
        map.put("x2",-1.0);
        Assertions.assertEquals(map, k);
    }
    @Test
    public void Kvur_calculate_test_4(){
        var kvur = new KvUr();

        var inputData = new HashMap<String,Object>();
        inputData.put("a",10);
        inputData.put("b",1);
        inputData.put("c",10);
        var k = kvur.calculate(inputData);

        var map = new HashMap<String,Object>();
        Assertions.assertEquals(map, k);
    }
    @Test
    public void Kvur_calculate_test_5(){
        var kvur = new KvUr();

        var inputData = new HashMap<String,Object>();
        inputData.put("a",10);
        inputData.put("b",10);
        inputData.put("c",0);
        var k = kvur.calculate(inputData);

        var map = new HashMap<String,Object>();
        map.put("x1",0.0);
        map.put("x2",-1.0);
        Assertions.assertEquals(map, k);
    }
}
