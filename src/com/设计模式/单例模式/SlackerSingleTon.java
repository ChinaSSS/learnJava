package com.设计模式.单例模式;

//此处饿汉式单例 , 缺陷 : 线程不安全。(可以加同步)

public class SlackerSingleTon {

    public static void main(String[] args) {

        Dog dog = Dog.getDog();
        Dog dog1 = Dog.getDog();
        if(dog == dog1){
            System.out.println("is true");
        }

    }

}

class Dog extends Animal{


    //私有化类的构造器
    private Dog(){
        super();
    }

    //声明实例
    private static Dog dog = null;

    //提供方法
   public static Dog getDog(){
       if(dog == null){
           dog = new Dog();
       }
       return dog;
   }

    {
        System.out.println(" i am the static code blocks");
    }

}

class Animal {
    public Animal(){
        System.out.println(" i am your father");
    }
}

//静态代码块只执行一次，通常用来加载配置文件,执行的顺序 ：
//父类构造函数
//静态代码块
//子类构造函数