package com.FileL.打印流;

/*
* printStream
* printWriter
* println()调用的就是打印流的各种重载的函数*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo {

    //1.PrintStream

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\test\\test\\zhang.txt");
        System.setIn(inputStream);
    }

    //2.PirntWriter


}
