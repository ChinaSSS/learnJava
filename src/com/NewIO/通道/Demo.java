package com.NewIO.通道;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) throws IOException {
        //创建文件
        File file = new File("D://test//test//zhang.txt");
        //创建流
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //获取通道
        FileChannel channel = fileOutputStream.getChannel();

        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //写入文件
        System.out.println("输入消息");
        String s = reader.readLine();
        buffer.put(Byte.parseByte(s));
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
        reader.close();
        fileOutputStream.close();
    }

}
