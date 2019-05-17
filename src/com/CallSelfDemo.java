package com;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//注意在递归函数里放置的容器，经过调用自身容纳的东西在回调过程中可能不同

public class CallSelfDemo {

    static List<String> death = new ArrayList<>();

    public static void main(String[] args) {
        Path path = Paths.get("D:","test","test");
        SearchFile(path);
    }


    //递归阶乘
    public static int CC(int i){
        if(i==0||i==1){
            return 1;
        }else {
            return i*CC(i-1);
        }
    }

    //递归查找文件
    public static void SearchFile(Path path){
        File file = new File(String.valueOf(path));
        List<File> fileList = Arrays.asList(file.listFiles());
        for(File f : fileList){
            if(f.toPath().toString().endsWith(".TXT")||f.toPath().toString().endsWith(".txt")){
                death.add(f.getPath());
            }else {
                if (f.isDirectory()){
                    SearchFile(f.toPath());
                }
            }
        }
        System.out.println(Arrays.toString(death.toArray()));
    }


}