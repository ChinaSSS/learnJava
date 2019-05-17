package com.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class showCalendar {
    public static void main(String[] args) throws ParseException {
        String str = "2018-05-07";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(str);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //存储day
        int markday = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        //获得最大天数
        int maxday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //打印头部
        System.out.println(calendar.get(Calendar.YEAR)+"年"+calendar.get(Calendar.MONTH)+"月");
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for(int i=1;i<=maxday;i++) {
            if(i==1){
                int one = calendar.get(Calendar.DAY_OF_WEEK);
                switch (one){
                    case 0:
                        break;
                    case 1:
                        System.out.print("\t");
                        break;
                    case 2:
                        System.out.print("\t\t");
                        break;
                    case 3:
                        System.out.print("\t\t\t");
                        break;
                    case 4:
                        System.out.print("\t\t\t\t");
                        break;
                    case 5:
                        System.out.print("\t\t\t\t\t");
                        break;
                    case 6:
                        System.out.print("\t\t\t\t\t\t");
                }
            }
            if(markday == calendar.get(Calendar.DAY_OF_MONTH)){
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"*"+"\t");
            }else{
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");
            }

            if(calendar.get(Calendar.DAY_OF_WEEK)==6){
                System.out.print("\n");
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
