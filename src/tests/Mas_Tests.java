package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import resolver.models.Mas;

import java.util.HashMap;

public class Mas_Tests {
    @Test
    public void calculate_test1(){
        int[] massive = new int[6];
        massive[0]=3;
        massive[1]=-5;
        massive[2]=6;
        massive[3]=4;
        massive[4]=8;
        massive[5]=15;
        var map = new HashMap<String, String>();
        map.put("c", String.valueOf(2));
        var mas = new Mas();
        var count = mas.countCalculate(massive);
        var result = new HashMap<String,String>();
        result.put("c",String.valueOf(count));
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test2(){
        int[] massive = new int[5];
        massive[0]=5;
        massive[1]=5;
        massive[2]=10;
        massive[3]=20;
        massive[4]=40;
        var map = new HashMap<String, String>();
        map.put("c", String.valueOf(4));
        var mas = new Mas();
        var count = mas.countCalculate(massive);
        var result = new HashMap<String,String>();
        result.put("c",String.valueOf(count));
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test3(){
        int[] massive = new int[7];
        massive[0]=-3;
        massive[1]=2;
        massive[2]=20;
        massive[3]=14;
        massive[4]=12;
        massive[5]=-6;
        massive[6]=17;
        var map = new HashMap<String, String>();
        map.put("c", String.valueOf(0));
        var mas = new Mas();
        var count = mas.countCalculate(massive);
        var result = new HashMap<String,String>();
        result.put("c",String.valueOf(count));
        Assertions.assertEquals(map, result);
    }
    @Test
    public void calculate_test4(){
        int[] massive = new int[7];
        massive[0]=-3;
        massive[1]=2;
        massive[2]=20;
        massive[3]=14;
        massive[4]=12;
        massive[5]=-6;
        massive[6]=17;
        var mas = new Mas();
        var count = mas.countCalculate(massive);
        Assertions.assertEquals(0, count);
    }
}
