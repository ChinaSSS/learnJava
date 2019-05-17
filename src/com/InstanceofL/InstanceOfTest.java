package com.InstanceofL;
//左右两边有继承的关系
import org.junit.jupiter.api.Test;

public class InstanceOfTest {

    class Animal{}
    class Dog extends Animal{}
    class LittleDog extends Dog{}
    class Person{}
    class Man extends Person{}

    @Test
    public void test(){
        LittleDog littleDog = new LittleDog();
        Animal animal = new Animal();
        if(animal instanceof LittleDog){
            System.out.println("is right");
        }else{
            System.out.println("is wrong");
        }

        if(animal instanceof Object){
            System.out.println("i am a son of object");
        }
    }

}
