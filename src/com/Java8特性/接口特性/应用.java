package com.Java8特性.接口特性;

public class 应用 implements A,B{


    @Override
    public void help() {
        A.super.help();
        B.super.help();
    }
}

interface A {
    default void help(){
        System.out.println("老妈我来救你了");
    }
}

interface B{
    default void help(){
        System.out.println("宝贝我来救你了");
    }
}
