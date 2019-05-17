package com.BasicLearn;

public class CloneDemo implements Cloneable {

    private String name ;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CloneDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        CloneDemo cloneDemo1 = new CloneDemo("zhang",2);
        try {
            CloneDemo cloneDemo2 = (CloneDemo) cloneDemo1.clone();
            System.out.println(cloneDemo2.getAge()+"=="+cloneDemo2.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
