package com.注解与反射;

public class Dog {
    public String name;
    private int age ;

    public Dog(){
        name = "a dog";
        age = 3;
    }

    public Dog(String name ){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void eat(){}

    public void run(int age){}

}
