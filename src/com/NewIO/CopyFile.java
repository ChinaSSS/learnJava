package com.NewIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//应用通道
public class CopyFile {

    private static void randomAccessFileCopy(){

    }

   private static void copyFile() throws IOException {
        //获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //得到管道,输入和输出
        FileChannel fileChannel_in = new FileInputStream(new File("D:"+File.separator+"test"+File.separator+
                "test"+File.separator+"wang.txt")).getChannel();
        FileChannel fileChannel_out = new FileOutputStream("D:\\test\\test\\zhang.txt").getChannel();
        //用缓冲区来承载数据(读入数据到缓冲区，在将缓冲区的数据通过管道写入文件
        while(fileChannel_in.read(buffer)!=-1){
            buffer.flip();
            fileChannel_out.write(buffer);
            buffer.clear();
        }
        if(fileChannel_in != null){
            fileChannel_in.close();
        }
        if(fileChannel_out != null){
            fileChannel_out.close();
        }
        System.out.println("复制完毕");
    }

    public static void main(String[] args) {
        try {
            copyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
