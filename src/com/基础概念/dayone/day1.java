package com.基础概念.dayone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class day1 {

    public static void main(String[] args) throws IOException {
        //two ways to get keyboards input

        //use scanner
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
//        input.close();

        //use BufferedReader
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        String str2 = input2.readLine();
        System.out.println(str2);
    }

}
