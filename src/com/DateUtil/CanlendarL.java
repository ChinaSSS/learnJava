package com.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CanlendarL {
    public static void main(String[] args) throws ParseException {

        //获得日期
        Calendar calendar = new GregorianCalendar(3000,2,23,4,44,34);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH+1);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println(year);
        //设置日期
        Calendar calendar1 = new GregorianCalendar();
        calendar.set(Calendar.YEAR,2018);
        //日期计算
        Calendar calendar2 = new GregorianCalendar();
        calendar2.add(Calendar.DAY_OF_YEAR,100);
        System.out.println(calendar2.get(Calendar.YEAR)+"年"+calendar2.get(Calendar.MONTH)+"月"+calendar2.get(Calendar.DAY_OF_MONTH));
        //日期类和时间类的转换
        Date date = new Date();
        Calendar calendar3 = new GregorianCalendar();
        calendar3.setTime(date);//把date中的事件提取出日期来赋值给calendar

        //
        String str = "2019-1-3";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        Date date1 = format.parse(str);
        System.out.println(date1);
        Calendar calendar4 = new GregorianCalendar();
        calendar4.setTime(date1);
        System.out.println(calendar4.get(Calendar.YEAR)+"年"+calendar4.get(Calendar.MONTH)+"月"+calendar4.get(Calendar.DAY_OF_MONTH  ));
    }
}
