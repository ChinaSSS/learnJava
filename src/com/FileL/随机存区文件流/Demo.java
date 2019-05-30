package com.FileL.随机存区文件流;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo {

    /*
    * 既可以作为输入流也可以作为输出流
    * 直接继承于object类
    * 实现类dataoutput
    * 和datainput
    * 只能覆盖不能追加  ---  是对文件内容覆盖而不是对文件覆盖*/


    public static void main(String[] args) throws IOException {

        File file = new File("D:\\test\\test\\zhang.txt");

        RandomAccessFile in = new RandomAccessFile("D:\\test\\test\\zhang.txt","r");
        RandomAccessFile out = new RandomAccessFile("D:\\test\\test\\zhang.txt","rw");

        //写入
        String content = "zhangqinlang is a good man";
        out.writeUTF(content);

        //覆盖插入
//        content = "charude zifuchuang";
//        将文件指针指定位置，实现文件的插入和追加
//        out.seek(3);
//        out.writeUTF(content);


        //追加
//        content = ", the end is me";
//        out.seek(file.length());
//        out.writeUTF(content);


        //无覆盖插入
        StringBuilder stringBuilder= new StringBuilder((int) file.length());
        content = "i am the insert ,";
        in.seek(14);
        byte[] bytes = new byte[5];
        int len = -1;
        while((len = in.read(bytes)) != -1){
            stringBuilder.append(new String(bytes,0,len));
        }

        out.seek(14);
        out.writeUTF(content);
        out.writeUTF(String.valueOf(stringBuilder));
        in.seek(0);
        System.out.println(in.readUTF());


    }





}
