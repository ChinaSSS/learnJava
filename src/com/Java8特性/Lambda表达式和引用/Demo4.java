package com.Java8特性.Lambda表达式和引用;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//函数引用之引用构造器

public class Demo4 {


    //consumption type
    @Test
    public void test1(){

        //primitive write
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                //
            }
        };

        //lambda write
        Consumer<String> consumer1 = s -> {};

        //reference constructor
        Consumer<String> consumer2 = Myclass :: new;

    }


    //supply type
    @Test
    public void test2(){

        //primitive write
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return new String("string");
            }
        };

        //lambda write
        Supplier<String> supplier1 = ()-> new String("string");
        System.out.println(supplier1.get());

        //reference constructor
        Supplier<String> supplier2 = Myclass :: getString;

    }


    //function type
    @Test
    public void test3(){

        //primitive write
        Function<Integer,String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return new String(integer+"");
            }
        };

        //lambda write
        Function<Integer,String> function1 = integer -> new String("good");

        //reference constructor
        Function<Integer,String> function2 = Myclass :: getString;
        System.out.println(function2.apply(1));

    }

    //predicate type
    @Test
    public void test4(){

        //primitive write
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 0 ){
                    return true;
                }else{
                    return false;
                }
            }
        };

        //lambda write
        Predicate<Integer> predicate1 = integer -> {
            if(integer>0){
                return true;
            }else {
                return false;
            }
        };

        //reference function
        Predicate<Integer> predicate2 = Myclass :: get;
        System.out.println(predicate2.test(1));
    }

    @Test
    public void test5(){
        //数组引用
        Function<Integer,String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        //通过lambda的方式
        Function<Integer,String[]> function1 = integer -> new String[integer];
        //通过数组引用
        //类似于数组构造函数的引用
        Function<Integer,String[]> function2 = String[] :: new;
        //使用String[]的构造方法，实现接口中的抽象方法
        //function2 代表的是实现了方法的obj
        System.out.println(Arrays.toString(function2.apply(5)));
    }

}

class Myclass{

    private String name;
    private int age;

    public static String getString(){
        return new String("string");
    }

    public static boolean get(Integer integer){
        if(integer>0){
            return true;
        }else {
            return false;
        }
    }

    public Myclass(String name) {
        this.name = name;
        System.out.println("in constructor");
    }

    public static String getString(Integer integer){
        return new String(integer+"");
    }
    public Myclass(String name, int age) {
        System.out.println("in constructor");
        this.name = name;
        this.age = age;
    }

}

