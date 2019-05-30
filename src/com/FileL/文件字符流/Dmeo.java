package com.FileL.文件字符流;

import org.junit.jupiter.api.Test;

import java.io.*;

//文本文件不能用字节流操作
//文本文件存的是

public class Dmeo {

    @Test
    public void test(){
        Writer writer = null;
        Reader reader = null;
        try {
            //不写truem默认是覆盖，文件不存在则创建
            writer = new FileWriter("D:\\test\\test\\zhangg.txt",true);//追加模式。
            writer.write("文件输出流");
            reader = new FileReader("D:\\test\\test\\zhang.txt");
            char[] chars = new char[5];
            int len = -1;
            StringBuffer buffer = new StringBuffer();
            while((len = reader.read(chars))!=-1){
                buffer.append(new String(chars,0,len));
            }
            System.out.println(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
