package com.通配符和正则.正则表达式;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// matcher
// pattern
//api 文档 patt

public class Demo {

    @Test
    public void test(){
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaaabbbb");
        //从头开始匹配
        boolean b = matcher.matches();
        System.out.println(b);

        pattern = Pattern.compile("[0-9]{11}");
        matcher = pattern.matcher("15171453782");
        b = matcher.matches();
        System.out.println(b);
    }

    @Test
    public void test2(){

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher("fadsfaf124152wfwwffwf");
        //匹配找到的第一个
        boolean b = matcher.find();
        System.out.println(b);
        System.out.println(matcher.group());
    }

    @Test
    public void test3(){

        Pattern pattern = Pattern.compile("\\d+");
        String str = "fafdfa14141fadff52522";
        Matcher matcher = pattern.matcher(str);
        String a = matcher.replaceAll("zhang");
        System.out.println(a);
        // replaceFirst

    }

}
