package com.Java8特性.Lambda表达式和引用;

/*
* -> lambda 操作符
* left : lambda 形参列表,接口中的抽象方法形参
* right : lambda 体，方法体
* lambda 表达式本质: 作为接口的实例
* */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Demo {


    //无参无返回值
    @Test
    public void test1(){

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("good");
            }
        };

        Runnable runnable = () -> System.out.println("i am running");
        runnable.run();
    }

    //有参数无返回值
    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("i am consumer");
            }

        };

        Consumer<String> consumer1 = (String s)-> System.out.println("i am new consumer");
        consumer1.accept("s");
    }

    //数据类型可以省略，基于编译器的类型推断
    @Test
    public void test3(){
        Consumer<String> consumer1 = (s)-> System.out.println(s);
        consumer1.accept("i am new new consumer");
    }

    //如果形参只有一个参数，（）可以省
    @Test
    public void test4(){
        Consumer<String> consumer1 = s-> System.out.println("i am new consumer");
        consumer1.accept("s");
    }

    //lambda 如果需要两个及以上的参数，并且多条语句，有返回值
    @Test
    public void test5(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1 - o2;
            }
        };

        Comparator<Integer> comparator1 = (o1,o2)->{
                {
                    System.out.println(o1);
                    System.out.println(o2);
                    return o1 - o2;
            }
        };
        System.out.println(comparator1.compare(2, 45));
    }

    //当lambda只有一条语句式时，return和大括号可以省略
    @Test
    public void test6(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> comparator1 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator1.compare(10,25));
    }


}
