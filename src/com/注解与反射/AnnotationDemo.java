package com.注解与反射;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationDemo {

    @MyAnnotation(name="wang",age=2,sex = "nv")
    @Test
    //the annotation can superposition
    public void method1(){
        System.out.println("this is my first annotation !");
    }


}


//add the meta annotation
@Target(ElementType.METHOD)   //only act on the method ,if you make it act on class and so on ,
                                //  the compiler error for reporting
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

    //must have () , could have default

    String name() default "zhang";
    int age() default 0;
    String sex() default "nan";

}

