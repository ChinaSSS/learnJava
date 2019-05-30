package com.注解与反射;

import org.junit.jupiter.api.Test;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationDemo2 {

    //反射处理注解

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Cat> catClass = Cat.class;
        //获取类上应用的指定注解
        Annotation_my annotation = catClass.getAnnotation(Annotation_my.class);
        //获取注解上的值
        String name = annotation.name();
        int age = annotation.age();
        //实例化对象
        Cat cat = catClass.getConstructor(String.class,int.class).newInstance(name, age);
        System.out.println(cat);


        //获取方法，看其是否被某个注解作用
        Method method = catClass.getMethod("eat",null);
        if(method.isAnnotationPresent(Annotation_my.class)){
            Annotation_my annotation1 = method.getAnnotation(Annotation_my.class);
            System.out.println(annotation1.name());
            System.out.println(annotation1.age());
        }

    }

}

@Annotation_my(name = "zhang",age = 20)
class Cat{

    private String name;
    private int age;

    public Cat(String name , int age){
        this.name =name;
        this.age = age;
    }

    @Annotation_my(name = "wang",age = 3)
    public void eat(){
        System.out.println("i am eating");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


@Documented
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation_my{

    String name() default "null";
    int age() default 0;

}
