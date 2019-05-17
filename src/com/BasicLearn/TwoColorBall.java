package com.BasicLearn;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoColorBall {
    //双色球案例色实现
    public static void main(String[] args) {
        int[] sysred = new int[6];      //系统红球
        int[] usered = new int[6];      //用户红球
        int sysblue = 0;                //系统蓝球
        int useblue = 0;                //用户蓝球

        boolean flag = true;
        OUT:
        while(flag){
            System.out.println("have a good time");
            System.out.println("------------------双色球------------------");
            System.out.println("请选择数字选取模式 : 电脑输入 1  , 手动输入 2 按 0退出选号");
            Scanner in = new Scanner(System.in);
            int i = in.nextInt();
            switch (i){
                case 1:
                    System.out.println("即将为您随机选号");
                    int[] temp = getRandomNum();
                    usered = Arrays.copyOf(temp,6);
                    useblue = temp[temp.length-1];
                    break;
                case 2:
                    System.out.println("亲输入6个0-33之间的数字");
                    int tmep2;
                    for(int j=0;j<usered.length;j++){
                        tmep2 = in.nextInt();
                        usered[j] = tmep2;
                    }
                    System.out.println("亲输入您选中的蓝球");
                    tmep2 = in.nextInt();
                    useblue = tmep2;
                    break;
                case 0:
                    System.out.println("欢迎下次再来!!!");
                    break OUT;
                    default:
                        System.out.println("输入不匹配");
                        break;
            }
            //电脑选择一个中奖号码
            int[] temp = getRandomNum();
            sysblue = temp[temp.length-1];
            sysred = Arrays.copyOf(temp,6);
            //公布中奖结果
            CheckAndDeclear(sysred,usered,sysblue,useblue);
        }
    }

    public static int[] getRandomNum(){
        int[] list = new int[34];
        //填充数组
        for(int i=0;i<=33;i++){
            list[i] = i;
        }
        //获取随机数
        int[] temp = new int[7];
        int tempnum = 0;
        Random random = new Random();
        for(int i=0;i<7;i++){
            int index = random.nextInt(list.length-i);
            temp[i] = list[index];
            //把取出的值放入数组末尾
            tempnum = list[index];
            list[index] = list[list.length-1-i];
            list[list.length-1-i] = tempnum;
        }
        return temp;
    }

    public static void CheckAndDeclear(int[] sys,int[] user ,int system,int userblue){
        int redcommont = 0;
        int bluecommont =0;
        //将所得数组排序
        Sort(sys);
        Sort(user);
        //查找相同个数
        for(int i:sys){
            for(int j:user){
                if(i == j){
                    redcommont ++;
                }
            }
        }
        if(system == userblue){
            bluecommont = 1;
        }

        System.out.println("中奖红球号码是  "+Arrays.toString(sys)+" 蓝球号码是 "+system);
        System.out.println("用户选择红球号码 "+Arrays.toString(user)+" 蓝球号码是 "+userblue);
        System.out.println("中奖结果");
        //公布结果
        showResult(redcommont,bluecommont);
    }

    public static void showResult(int redcommont,int bluecommont){
        switch (bluecommont){
            case 0:
                if(redcommont == 0){
                    System.out.println("谢谢惠顾");
                }else if(redcommont == 1){
                    System.out.println("中奖--5元");
                }else if (redcommont == 2){
                    System.out.println("中奖25元");
                }else  if (redcommont == 3){
                    System.out.println("中奖--125元");
                }else if(redcommont == 4){
                    System.out.println("中奖--625");
                }else if (redcommont == 5){
                    System.out.println("中奖--1000");
                }else if (redcommont == 6){
                    System.out.println("中奖--2000");
                }
                break;
            case 1:
                if(redcommont == 0){
                    System.out.println("小奖励--10yuan");
                }else if (redcommont==1){
                    System.out.println("money -- 100");
                }else if (redcommont ==2){
                    System.out.println("money -- 200");
                }else if(redcommont == 3){
                    System.out.println("money -- 500");
                }else if (redcommont==4){
                    System.out.println("money --1000");
                }else if (redcommont==5){
                    System.out.println("money --5000");
                }else if (redcommont==6){
                    System.out.println("小姐姐一个");
                }

                break;
        }
        System.out.println("--------------------------------------------------");
    }


    public static void Sort(int[] list){
        //排序
        // 1 2 3 4 5
    /*
    2 1 3 4 5
    2 3 1 4 5
    2 3 4 1 5
    2 3 4 5 1
    2 3 4 5
    3 2 4 5
    3 4 2 5
    3 4 5 2
    3 4 5
    4 3 5
    4 5 3
    4 5
    5 4
     */
        int temp = 0;
        for(int i=0;i<list.length-1;i++){
            for(int j=0;j<list.length-1-i;j++){
                if(list[j]>list[j+1]){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }
}
