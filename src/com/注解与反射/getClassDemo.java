package com.注解与反射;

public class getClassDemo {

    //dynamic loading class has many ways
    //java is not the dynamic language , but it has the reflection mechanism.
    //the class is only be loaded once

    public static void main(String[] args) throws ClassNotFoundException {

        //use static method class.forname()
        String path = "com.注解与反射.Dog";
        Class aClass = Class.forName(path);
        System.out.println("path:"+aClass.hashCode());

        //by getclass
        //path is a String , so String.class == path.getClass ,都是String类型，获得的就是一个String的视图
        Class bClass = path.getClass();
        System.out.println(bClass.hashCode());

        //by .class
        Class cClass = String.class;
        Class dClass = int.class;
        System.out.println(cClass.hashCode());
        System.out.println(dClass.hashCode());

        //about array
        int[] a = new int[4];
        int[] b = new int[5];
        if(a.getClass().hashCode() == b.getClass().hashCode()){
            System.out.println("is true");
        }
        //维度不同的，double类型的都不同
        //类和对象的不同的，类是磨具，对象的实例
    }
}
