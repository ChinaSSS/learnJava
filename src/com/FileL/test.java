package com.FileL;

public class test {

    public static void main(String[] args) {

        //stringbuilder 线程不安全，但是速度比stringbbuffer快

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        long start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            stringBuffer.append("zhang");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start= System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            stringBuilder.append("zhang");
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
