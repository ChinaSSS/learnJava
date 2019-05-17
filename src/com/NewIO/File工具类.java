package com.NewIO;

import java.io.IOException;
import java.nio.file.*;

public class File工具类 {

    public static void main(String[] args) {
        //
    }


    //文件的写入与读取
    public void Read_and_WriteFile(){
        Path path = Paths.get("D:","test","test","zhang.txt");
        String str = "NIO is so good , and the tools is also good";
        try {
            Files.write(path,str.getBytes(), StandardOpenOption.APPEND);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件的复制
    private static void copyFile(){
        Path path = Paths.get("D:","test","test","zhang.txt");
        Path path1 = Paths.get("D:","test","newio");
        try {
            Files.copy(path,path1, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件的移动

}
