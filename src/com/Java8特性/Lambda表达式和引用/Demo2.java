package com.Java8特性.Lambda表达式和引用;


//函数式接口 ，四大核心

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo2 {

    @Test
    public void test(){
        //消费型，有传入 T 无传出
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("i get "+integer);
            }
        };

        Consumer<Integer> consumer1 = integer-> System.out.println("good");

        //供给型，无输入 T 有返回 T
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 100;
            }
        };

        Supplier<Integer> supplier1 = ()-> 100;


        //函数型，有输入有输出
        Function<Integer,Boolean> function = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer integer) {
                if(integer == 0){
                    return false;
                }else {
                    return true;
                }
            }
        };

        Function<Integer,Boolean> function1 = integer->{
            if(integer == 0){
                return false;
            }else {
                return true;
            }
        };

        //断言型接口
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 0){
                    return true;
                }else {
                    return false;
                }
            }
        };

        Predicate<Integer> predicate1 = integer -> {
            if(integer>0){
                return true;
            }else {
                return false;
            }
        };
    }

}
