package com.FileL.标准输入输出流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyScanner {


    public static void main(String[] args) throws IOException {
        MyScanner myScanner = new MyScanner();
        String string = myScanner.getstring();
        int num = myScanner.getint();
        System.out.println(num + string);
    }


    public String getstring() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();

    }

    public Integer getint() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        //string 转换成integer类型
        return Integer.parseInt(s);

    }
}
