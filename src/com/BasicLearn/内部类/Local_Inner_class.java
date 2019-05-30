package com.BasicLearn.内部类;

public class Local_Inner_class {



    //返回一个实现Comparable接口的类对象
    public Comparable getComparable(){

        class myComparable implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        return new myComparable();
    }

    //方法二，匿名内部类
    public Comparable getComparable2(){

        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

}
