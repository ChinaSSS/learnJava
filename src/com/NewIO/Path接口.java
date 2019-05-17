package com.NewIO;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Path接口 {
    public static void main(String[] args) {
        Path path = Paths.get("D:","test","test","zhang.txt");
        System.out.println(path);

        File file = new File(String.valueOf(path));
        System.out.println(file.toPath());

        FileSystems.getDefault().getPath("D:","test","test","zhang.txt");

    }
}
