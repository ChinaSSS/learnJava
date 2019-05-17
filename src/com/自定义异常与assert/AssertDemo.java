package com.自定义异常与assert;

//断言,
/*
作用：
作为开发人员检查代码，与自己的逻辑匹配是否一致
 */
public class AssertDemo {

    public static void main(String[] args) {
        int result = add(10,10);
        assert result == 10:"逻辑不正确";
    }

    public static int add(int a,int b){
        return a+b;
    }

}
