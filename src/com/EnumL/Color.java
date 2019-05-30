package com.EnumL;

//定义枚举类型
public enum Color {

    RED(10){
        @Override
        public void introduce() {
            System.out.println("i am red");
        }
    },GREEN(20){
        @Override
        public void introduce() {
            System.out.println("i am green");
        }
    },BLUE{
        @Override
        public void introduce() {
            System.out.println("i am blue");
        }
    };
    //代表枚举的对象(不单单是字符串,只能在内部定义)

    private int coo;

    private Color(){
        System.out.println("无参构造器");
    }

    private Color(int color){
        this.setCoo(color);
        System.out.println("有参构造器");
    }

    public int getCoo() {
        return coo;
    }

    public void setCoo(int coo) {
        this.coo = coo;
    }

    //definite a abstract method
    public abstract void introduce();
}

//the enum also can implement a interface

class test{

    public static void main(String[] args) {
        Color color = Color.BLUE;
        //when the menu be call , the all obj in menu will be constructed
        if(color.getCoo() ==10){
            System.out.println("true");
        }
        System.out.println(color.getCoo());
        color.introduce();
    }

}
