package com.自定义异常与assert;

public class Login {

    public static void main(String[] args) {
        UserServer server = new UserServer();
        try {
            server.login();
            User user = new User("zhang",33,"nam",3333333);
            System.out.println("欢迎登陆");
            System.out.println(user);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

}
