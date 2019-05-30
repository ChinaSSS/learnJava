package com.BasicLearn.内部类;

//当类的内部需要一个完整的结构描述，并服务于外部的类，可以使用内部类
/*
* 1 .成员内部类的实例化:
* 2 .如何在成员内部类调用外部类的结构
* 3 .开发中的使用
* */

public class People {

    private String name;
    private String sex;
    private int age;

    public People(){

        //构造器中的局部内部类
        class randSex{

        }

        //

    }


    //==========成员内部类=============
    //直接定义在类中
    class Hand{
        //field

        //method
    }

    class Foot{
        //field

        //method
    }

    class Head{



    }
    //========局部内部类=============

    //代码块中的局部内部类
    {
        class Brith{

        }
    }

    //定义在方法中的局部内部类
    public void sport(){

        class Run{

        }

    }
}
