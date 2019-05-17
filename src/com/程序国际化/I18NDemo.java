package com.程序国际化;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NDemo {
    public static void main(String[] args) {
        Locale locale_CN = new Locale("zh","CN");
        Locale locale_US = new Locale("en","US");
        //获取本地系统默认的语言环境
        Locale locale_defaul = Locale.getDefault();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.程序国际化.info",locale_CN);
        System.out.println(resourceBundle.getString("system.name"));
        System.out.println(resourceBundle.getString("input.name"));
    }
}
