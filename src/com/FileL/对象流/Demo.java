package com.FileL.对象流;

/*
*序列化：将Java对象保存到磁盘中，或者通过网络传输出去*/

import org.junit.jupiter.api.Test;

import java.io.*;

public class Demo {

   public static void main(String[] args) throws IOException, ClassNotFoundException {


       //避免出错最好将inputstream放在outputstream后面
       //再socket 编程 中client一定要先获得输出再获得输入
       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\test\\test\\zhang.obj"));
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\test\\test\\zhang.obj"));


       Dog dog = new Dog("zhnag",14);

       oos.writeObject(dog);
       oos.flush();
       oos.close();

       //读出对象
       Dog dog1 = (Dog) ois.readObject();
       System.out.println(dog.hashCode());
       System.out.println(dog1.hashCode());
       System.out.println(dog.getName());
       System.out.println(dog1.getName());

    }

}

class Dog implements Serializable{


    //保证内部的数据类型可序列化
    //基本数据类型自动可序列化
    //内部类或者属性类需要序列化
    //不能含有static或者transient
    //transit 加再不想序列化的数据

    public static final long serialVersionUID = 12545251425144L;
    //设置唯一的标识
    private String name;
    private int age;

    public Dog(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

/*
* 关于*/