package com.BasicLearn.javaBean;

//如果一个类满足一下三条标准的类就是JavaBean
//如果一个类满足一下三条标准的类就是JavaBean
//1 公共类
//2 有一个无参的公共构造函数
//3 有属性，并且有对应的getter and setter

public class Demo {

    private String name;

    public Demo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
