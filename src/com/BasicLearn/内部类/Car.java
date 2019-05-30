package com.BasicLearn.内部类;

public class Car {

    private String name;
    private int Licence_palte_num;

    public void Run(){

        class engine{

            public void start_up(){
                System.out.println(" i am going to start");
            }

            public void stalling(){
                System.out.println(" stalling ....");
            }

        }

    }

    //车模式
    class Mode{

        public String model;

        public void setMOdel_drift(){
            System.out.println(" in drift model");
        }

        public void setModel_normal(){
            System.out.println(" in normal model");
        }

        //成员内部类调用外部类的属性
        public void get_out_field(){
            //直接调用外部类的属性
            System.out.println(name);
        }

    }

    //有重名的情况
    class Temp{
        public String name;

        public void gg(){
            System.out.println(Car.this.name);
        }
    }

    public static void main(String[] args) {
        //创建成员内部类(非静态的依赖于对象存在)
        Car car = new Car();
        Car.Mode mode = car.new Mode();
        mode.setMOdel_drift();

    }

}
