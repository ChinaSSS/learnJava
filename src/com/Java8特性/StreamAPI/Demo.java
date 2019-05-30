package com.Java8特性.StreamAPI;
/*
* SteamAPI ， 用于数据的计算操作，比如对非关系型数据库，提取全部数据，在java层面上对数据进行
* 筛选等操作。本身不存储数据。
*
* */

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

    @Test
    public void getStream_1(){
        //通过集合获得Stream
        Collection collection = new HashSet();
        //获得串行的stream
        Stream stream = collection.stream();
        //获得并行处理的stream
        Stream parallelStream = collection.parallelStream();

    }

    @Test
    public void getStream_2(){
        //通过数组获得
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
        //通过自定义类型的数组获取
        Stream<MyType> myTypeStream = Arrays.stream(new MyType[]{new MyType(), new MyType()});
        //通过泛型指定类型
    }

    @Test
    public void getStream_3(){
        //通过自身方法获得,stream 的的对像是容器
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
    }

    @Test
    public void getStream_4(){
        //通过无限流获得
        Stream.iterate(0,t -> t+1).limit(10).forEach(System.out :: println);
        //方法引用
        Stream<Double> generate = Stream.generate(Math::random);
    }


}
class MyType{
    private String name;
    private int age;
}
