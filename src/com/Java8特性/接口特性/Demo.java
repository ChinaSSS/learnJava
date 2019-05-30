package com.Java8特性.接口特性;

/*
* jdk 8 中除了定义全局常量外，还可以定义静态方法和默认方法*/

public class Demo extends Good implements Interface //,Interface2
{

    public static void main(String[] args) {
        Demo demo = new Demo();
        //1.接口中定义的静态方法只能通过接口调用，实现接口的类也不能调用
        //类中也一样，子类无法继承父类的静态方法，和静态变量
        demo.NotStaticMethod();
        System.out.println(demo.age);
        //静态变量也一样
        //2.如果接口和父类有同名的方法,会调用父类的方法，类优先原则
        demo.DefaultMethod();
        //3.实现的接口中含有同名的默认不抽象方法，编译器会报错，无法辨别优先级。 -- 接口冲突
        //必须从写此方法 。相当于没有用接口的。
        demo.DefaultMethod2();

    }

    @Override
    public void DefaultMethod2() {
        System.out.println("i am rewrite");
        play();
    }

    //4.调用接口中被从写的方法
    public void play(){
        Interface.super.DefaultMethod2(); //在子类方法中调用接口被从写的方法
    }
}

interface Interface{
    //接口内权限都是Public

    static void StaticMethod(){
        System.out.println(" i am the static method");
    }

    default void DefaultMethod(){
        System.out.println(" i am the default method in interface");
    }

    default void DefaultMethod2(){
        System.out.println(" i am the default method2 in interface");
    }

}

class Good{

    public static String name = "zhang";
    public int age = 10;

    public static void StaticMethod(){
        System.out.println(" i am the static method");
    }

    public void NotStaticMethod(){
        System.out.println(" i am not static ");
    }

    public void DefaultMethod(){
        System.out.println("i am the default method in super");
    }

}

