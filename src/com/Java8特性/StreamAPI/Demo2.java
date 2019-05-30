package com.Java8特性.StreamAPI;

import jdk.javadoc.doclet.Doclet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {

    @Test
    public void test(){
        //获取Stream
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        list.add(new Animal("111111"));
        Stream<Animal> animalStream = list.stream();
        //筛选
        animalStream.filter(animal -> animal.age.equals("0000")).forEach(System.out :: println);
        System.out.println("--------------------");
        //截断流,关闭stream后是不可以对其操作了的
        list.stream().limit(3).forEach(System.out :: println);
        System.out.println("---------------------------");
        //跳过
        list.stream().skip(3).forEach(System.out :: println);
        System.out.println("----------------------");
        //去重distinct
        list.stream().distinct().forEach(System.out::println);
    }

}

class Animal {
    public String age;

    public Animal(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
