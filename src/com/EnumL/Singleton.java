package com.EnumL;

public enum Singleton {

    SINGLETON;

    public void method(){
        System.out.println("method");
    }

}

//枚举实现单例模式

class aaa{

    public static void main(String[] args) {
        Singleton.SINGLETON.method();
    }

}
