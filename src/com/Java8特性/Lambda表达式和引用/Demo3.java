package com.Java8特性.Lambda表达式和引用;

//方法引用
//当要传递给lambda的方法已经有实现的方法了，可以使用方法引用

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

public class Demo3 {

    @Test
    public void test(){
        //consumer
        //printstream 中的void println()
        Consumer<String> consumer = s -> System.out.println("i am s");

        //对象:: 非静态方法
        System.out.println("111111111111111");
        PrintStream out = System.out;
        Consumer<String> consumer1 = out::println;
        consumer1.accept("good");

        //类 :: 静态方法
        System.out.println("22222222222222");
        //comparator compare
        //int compare
        Comparator<Integer> comparator = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator.compare(1,3));
        System.out.println("------------------");
        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println(comparator1.compare(2, 1));


        // 类 :: 实例化方法
        //Comparator int compare(T t1,T t2)
        //String int t1.compareTo(t2)
        Comparator<String> comparator2 = (t1,t2) -> t1.compareTo(t2);
        System.out.println(comparator2.compare("abc","aaa"));

        //相当于时掉对象的静态方法
        Comparator<String> comparator3 = String :: compareTo;
        System.out.println(comparator3.compare("aaa", "aba"));
    }


}
