package com.FileL.数据流;

import org.junit.jupiter.api.Test;

import java.io.*;

/*
* 将内存中的基本数据类型写入文件中，
* 不是以单一的char写入
* 持久化
* 可以按类型读出*/
public class demo {

    /*
    * 1.读数据的顺序要和写入的顺序一致*/

    @Test
    public void test() throws IOException {

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:\\test\\test\\zhang.txt"));
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("D:\\test\\test\\zhang.txt"));

        String name = "zhang";
        int age = 14;
        boolean sex = true;

        //写入数据
        outputStream.writeUTF(name);
        outputStream.writeInt(age);
        outputStream.writeBoolean(sex);
        outputStream.flush();
        if(outputStream != null){
            outputStream.close();
        }

        //读入文件
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readBoolean());

        if(dataInputStream != null){
            dataInputStream.close();
        }
    }

}
