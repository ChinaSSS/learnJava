package com.FileL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcessFileDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile Reader = new RandomAccessFile("D:\\test\\test\\zhang.txt","r");
            RandomAccessFile Writer = new RandomAccessFile("D:\\test\\test\\zhang2.txt","rw");
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len = Reader.read(bytes))!=-1){
                Writer.write(bytes,0,len);
            }
            Reader.close();
            Writer.close();
            System.out.println("复制成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
