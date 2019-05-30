package com.FileL.标准输入输出流;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*
* system.in
* system.out
*
* */
public class Demo {

    public static void main(String[] args) throws IOException {


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        OUT:
        while (true) {
            String data = bufferedReader.readLine();
            if (data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")) {
                System.out.println("程序结束");
                break OUT;
            }
            System.out.println(data.toUpperCase());
        }
    }

}