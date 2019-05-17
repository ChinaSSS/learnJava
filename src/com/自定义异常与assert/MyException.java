package com.自定义异常与assert;

public class MyException extends Exception {

    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }

}
