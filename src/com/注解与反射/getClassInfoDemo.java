package com.注解与反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class getClassInfoDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        String path = "com.注解与反射.Dog";
        Class<?> aClass = Class.forName(path);

//        get the name and simple name
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
//
//        get Field
        Field[] fields = aClass.getFields();    //获取的属性必须是公开的public ， 否则获取不到
        System.out.println(Arrays.toString(fields));
        //加上declare 就能够获取非public的属性了
        Field[] fields1 = aClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields1));
        Field field = aClass.getField("name2");
        System.out.println(field);
//
//        get method
        Method[] methods = aClass.getMethods();
        System.out.println(Arrays.toString(methods));
        Method method = aClass.getMethod("run",int.class);
        System.out.println(method);
//
//        get the constructor
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));


    }

}
