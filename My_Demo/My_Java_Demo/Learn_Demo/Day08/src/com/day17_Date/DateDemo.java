package com.day17_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
//        DateD();
        DateTwo();
    }

    public static void DateD() {
        Date date = new Date();
        //Sat Jul 27 18:29:40 CST 2019
        System.out.println(date);
        long getDate = date.getTime();
        System.out.println(getDate);
//        String string = date.toLocaleString();
//        System.out.println(string);

        System.out.println("==============");
        date.setTime(13213);
        //Thu Jan boot_01 08:00:13 CST 1970
        System.out.println(date);
        getDate = date.getTime();
        System.out.println(getDate);

//        string = date.toLocaleString();
//        System.out.println(string);

    }

    public static void DateTwo() throws ParseException {

        // 19-7-27 下午6:40
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);

        //2019年07月27日 18:46:22
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);

        //2019-07-27 18:47:18
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);

        //Sat Jul 27 11:23:40 CST 2019
        String dateStr = "2019年07月27日 11:23:40";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = simpleDateFormat.parse(dateStr);
        String s = simpleDateFormat.format(date);
        System.out.println(date);
        System.out.println(s);
    }
}
