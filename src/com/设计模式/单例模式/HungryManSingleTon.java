package com.设计模式.单例模式;

/*
*
* 只拥有一个类实例，所有其他类共享该类的实例
* constructor -- private
* getter and setter instance
* */

public class HungryManSingleTon {

    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Bank bank1 = Bank.getInstance();
        if(bank == bank1){
            System.out.println("is true");
        }
    }

}


class Bank{

    //将构造函数私有化
    private Bank(){

    }

    //创建唯一一个实例共享
    private static Bank instance = new Bank();

    //提供外部访问的方法
    public static Bank getInstance() {
        return instance;
    }


}