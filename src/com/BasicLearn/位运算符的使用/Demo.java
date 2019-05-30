package com.BasicLearn.位运算符的使用;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        int a = 10;

        //在数字没有溢出的前提下，左移相当于乘2的次方
        //右移相当于 整除 /2

        System.out.println(a >> 1); //右移 10/2 = 5；
        System.out.println(a << 1); //左移 10*2 = 20；

        //无符号右移
        //不管原来的数是正数还是负数，高位都拿0补。负数右移一位变成正数
        int b = -10;
        System.out.println(b >>> 1);

        //用异或实现两个数的交换
        int c = 3;
        int d = 4;
        c = c^d;
        d = c^d;
        c = c^d;
        System.out.println(c + "" + d);

    }

}
