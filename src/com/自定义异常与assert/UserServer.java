package com.自定义异常与assert;

import java.util.Scanner;

public class UserServer {

    public void login() throws MyException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = input.nextLine();
        System.out.println("请输入密码");
        String passwd = input.nextLine();

        if(!username.equals("zhang")){
            throw new MyException("用户名错误");
        }
        if(!passwd.equals("111")){
            throw new MyException("密码错误");
        }
    }

}
