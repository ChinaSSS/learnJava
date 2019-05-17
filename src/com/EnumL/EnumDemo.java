package com.EnumL;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

@SuppressWarnings("all")
public class EnumDemo {

    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    public int color;

    @Test
    public void test1(){
        color = 4;
    }

    public Color color2;

    @Test
    public void test2(){

        color2 = Color.BLUE;
        System.out.println(color2);
        System.out.println(color2.name());
        System.out.println(color2.ordinal());
        System.out.println(color2.toString());

        //静态方法获取值
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
        //工具类Arrays.toString(List);
    }

//对枚举的支持

    @Test
    public void test3(){
        EnumSet<Color> set = EnumSet.allOf(Color.class);
//        System.out.println(Color.class);
        for(Color c : set){
            System.out.println(c);
        }
    }

    @Test
    public void test4(){
        EnumMap<Color,String> map = new EnumMap<Color, String>(Color.class);
        map.put(Color.RED,"red color");
        map.put(Color.GREEN,"green color");
        map.put(Color.BLUE,"bule color");
        //迭代遍历
        Iterator iterator = map.keySet().iterator();
        String value;
        while(iterator.hasNext()){
            value = map.get(iterator.next());
            System.out.println(value);
        }
    }

}
