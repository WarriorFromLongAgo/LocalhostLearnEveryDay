package com.day17_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeWorkTwo {
    public static void main(String[] args) throws ParseException {
        CalendarHome();
    }

    public static void CalendarHome() throws ParseException {
        String tempTemp = "2019-03-02  12:21:56";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = simpleDateFormat.parse(tempTemp);
        //String strFormat = simpleDateFormat.format(date);
        //System.out.println(date);

        SimpleDateFormat simpleDateFormatTwo = new SimpleDateFormat("yyyy年MM月dd日  HH点mm分ss秒");
        String strFormatTwo = simpleDateFormatTwo.format(date);
        System.out.println(strFormatTwo);

        //2019年07月27日 18:46:22
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
    }
}
